package mini.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import mini.dto.BoardDto;
import mini.dto.BoardFileDto;
import mini.service.BoardFileService;
import mini.service.BoardService;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private BoardFileService boardFileService;
	
	@GetMapping("/board/list")
	public String list(Model model, @RequestParam(defaultValue = "1") int currentPage) {
		// 페이징 처리
	    // 페이징 처리에 필요한 변수들
	    int perPage = 3; // 한페이지당 보여지는 게시글의 갯수
	    int totalCount = 0; // 총 개시글의 개수
	    int totalPage;// 총 페이지 수
	    int startNum;// 각페이지당 보여지는 글의 시작 번호
	    // int endNum; // Oracle에서만 필요
	    int perBlock = 3; // 한블럭당 보여지는 페이지의 개수
	    int startPage; // 각블럭당 보여지는 페이지의 시작 번호
	    int endPage;

	    // 총 글 개수
	    totalCount = boardService.getTotalCount();

  	    // 총페이지수, 나머지가 있으면 무조건 올림
	    // 총게시글이 37-한페이지 3-12.3333....13페이지
	    totalPage = totalCount / perPage + (totalCount % perPage > 0 ? 1 : 0);

  	    // 각블럭의 시작페이지와 끝페이지
	    startPage = (currentPage - 1) / perBlock * perBlock + 1;
	    endPage = startPage + perBlock - 1;

  	    // endPage는 totalPage를 넘지않도록 한다
	    if(endPage > totalPage)
	    	endPage = totalPage;

	    // 각페이지당 불러올 글의 번호
	    // Oracle 기준 => 1페이지 : 1 ~ 10, 2페이지 : 11 ~ 20, 3페이지 : 31 ~ 40
	    // SQL 기준 => 1페이지 : 0 ~ 9, 2페이지 : 10 ~ 19, 3페이지 : 30 ~ 39
	    // startNum = (currentPage - 1) * perPage + 1; // Oracle용
	    startNum = (currentPage - 1) * perPage;
	    
	    // Oracle용
	    /* 
	    endNum = startNum + perPage - 1;

	    if(endNum > totalCount)
	    	endNum = totalCount;
		*/
	    
	    // 각 페이지의 시작 번호
	    int no = totalCount - (currentPage - 1) * perPage;
	  
	    // 해당페이지에 보여줄 게시판 목록
	    // List<BoardDto> list = dao.getList(startNum, endNum); // Oracle용
	    List<BoardDto> list = boardService.getList(startNum, perPage);
	  
	    // request 에 담을 값들
	    // Oracle용
	    /*
	    model.addObject("list", list);
	    model.addObject("totalCount", totalCount);
	    model.addObject("totalPage", totalPage);
	    model.addObject("startPage", startPage);
	    model.addObject("endPage", endPage);
	    model.addObject("currentPage", currentPage);  
	    model.addObject("no", no);  
		*/
	    
	    // SQL용
	    model.addAttribute("list", list);
	    model.addAttribute("totalCount", totalCount);
	    model.addAttribute("totalPage", totalPage);
	    model.addAttribute("startPage", startPage);
	    model.addAttribute("endPage", endPage);
	    model.addAttribute("currentPage", currentPage);  
	    model.addAttribute("no", no); 
	    
		return "board/boardlist";
	}
	
	@GetMapping("/board/form")
	public String form(Model model, 
			/* 새글일 경우 값이 안넘어오므로 defaultValue 값이 적용된다 */
			@RequestParam(defaultValue = "1") int currentPage, 
			@RequestParam(defaultValue = "0") int num,
			@RequestParam(defaultValue = "0") int regroup, 
			@RequestParam(defaultValue = "0") int restep, 
			@RequestParam(defaultValue = "0") int relevel
			) 
	{
		model.addAttribute("currentPage",currentPage);
		model.addAttribute("num",num);
		model.addAttribute("regroup",regroup);
		model.addAttribute("restep",restep);
		model.addAttribute("relevel",relevel);
		
		// 답글일 경우 제목 가져오기
		String subject = "";
		if(num > 0) {
			subject = boardService.getData(num).getSubject();
		}
		model.addAttribute("subject", subject);
		
		return "board/boardform";
	}
	
	// 새글, 답글 저장
	@PostMapping("/board/addboard")
	public String addBoard(	
			@ModelAttribute BoardDto dto,
			@RequestParam int currentPage,
			@RequestParam List<MultipartFile> upload,
			HttpServletRequest request,
			HttpSession session
			) 
	{
		// 파일 업로드할 경로
		String path = request.getSession().getServletContext().getRealPath("/resources/upload");
		
		// db에 저장할 로그인 정보
		String myid = (String)session.getAttribute("myid");
		String writer = (String)session.getAttribute("myname");
		
		// dto에 넣기
		dto.setMyid(myid);
		dto.setWriter(writer);
		
		// 일단 BoardDto 먼저 저장
		boardService.insertBoard(dto);
		
		// selectKey : num 값 넘어왔는지 확인
		System.out.println("num = " + dto.getNum());
		
		// 사진들 업로드
		// 사진 업로드를 안했을 경우 리스트의 첫 데이터의 파일명이 빈 문자열이 됨
		// 즉 업로드 헀을 경우에만 db에 저장을 함
		if(!upload.get(0).getOriginalFilename().equals("")) {
			for(MultipartFile multi : upload) {
				// 랜덤 파일명 생성
				String fileName = UUID.randomUUID().toString();
				
				// 업로드
				try {
					multi.transferTo(new File(path + "/" + fileName));
					
					// 파일은 따로 db에 insert
					BoardFileDto fdto = new BoardFileDto();
					fdto.setNum(dto.getNum()); // boarddb에 방금 insert된 num 값
					fdto.setPhotoname(fileName);
					
					boardFileService.insertPhoto(fdto);
					
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return "redirect:list?currentPage=" + currentPage;
	}
}
