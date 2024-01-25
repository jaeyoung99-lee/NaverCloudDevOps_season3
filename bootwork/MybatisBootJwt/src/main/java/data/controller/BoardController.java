package data.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import data.dto.BoardDto;
import data.service.BoardService;
import data.service.MemberService;
import lombok.RequiredArgsConstructor;
import naver.storage.NcpObjectStorageService;
import security.setting.JwtTokenProvider;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class BoardController {
	private final BoardService boardService;
	private final MemberService memberService; // 아이디에 해당하는 이름을 얻어야 해서 필요
	
	// 스토리지 변수
	private final NcpObjectStorageService storageService;
	
	private String bucketName = "bitcamp-701ex";
	private String folderName = "reactboot";
	
	@PostMapping("/board/insert")
	public void insertBoard(@RequestParam(value = "upload", required = false) MultipartFile upload, @ModelAttribute BoardDto dto) {
		// 업로드 파일 이름 확인
		// System.out.println("upload file : " + upload.getOriginalFilename()); // 사진 업로드 안했을 경우 에러 나오므로 주석 처리
		
		// 로그인한 아이디
		String myid = JwtTokenProvider.getUserIdFromJWT(dto.getToken());
		System.out.println("myid : " + myid);
		System.out.println("subject: " + dto.getSubject());
		System.out.println("content: " + dto.getContent());
		
		// 사진 업로드하고 dto의 photo 변경
		if(upload != null) {
		String photo = storageService.uploadFile(bucketName, folderName, upload);
		dto.setPhoto(photo);
		}
		else {
			dto.setPhoto(""); // 사진 업로드 안했을 경우
		}
		
		// 아이디(myid)에 해당하는 이름(name) 얻어서 writer에 넣기
		String writer = memberService.getLogin(myid).getName();
		dto.setWriter(writer);
		
		// 아이디도 dto에 저장
		dto.setMyid(myid);
		
		// db insert
		boardService.insertBoard(dto);
	}
	
	@GetMapping("/board/list")
	public Map<String, Object> boardList(@RequestParam(value = "currentPage", defaultValue = "1") int currentPage, @RequestParam(value = "search", defaultValue = "") String search){
		System.out.println("currentPage="+currentPage);
        // 페이징 처리
        int totalCount; // 총 갯수
        int perPage=3; // 한 페이지 당 출력할 글 갯수
        int perBlock=5; // 출력할 페이지 갯수
        int startNum;  // db에서 가져올 시작 번호
        int startPage; // 출력할 시작 페이지
        int endPage; // 출력할 끝 페이지
        int totalPage; // 총 페이지 수
        int no; // 출력할 시작 번호

        // 총 갯수
        totalCount=boardService.getTotalCount(search);
        // 총 페이지 수
        totalPage=totalCount/perPage+(totalCount%perPage==0?0:1);
        // 시작 페이지
        startPage=(currentPage-1)/perBlock*perBlock+1;
        // 끝 페이지
        endPage=startPage+perBlock-1;
        if(endPage>totalPage)
            endPage=totalPage;

        // 시작번호
        startNum=(currentPage-1)*perPage;
        // 각 페이지 당 출력할 번호
        no=totalCount-(currentPage-1)*perPage;

        List<BoardDto> list=boardService.getAllDatas(search, startNum, perPage);

        // 출력할 페이지 번호들을 Vector에 담아서 보내기
        Vector<Integer> parr=new Vector<>();
        for(int i=startPage;i<=endPage;i++){
            parr.add(i);
        }

        // 리액트로 필요한 변수들을 Map 에 담아서 보낸다
        Map<String,Object> smap=new HashMap<>();
        smap.put("totalCount",totalCount);
        smap.put("list",list);
        smap.put("parr",parr);
        smap.put("startPage",startPage);
        smap.put("endPage",endPage);
        smap.put("no",no);
        smap.put("totalPage",totalPage);

        return  smap;

	}
}
