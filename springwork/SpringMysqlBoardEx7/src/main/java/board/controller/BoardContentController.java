package board.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import board.data.AnswerDao;
import board.data.AnswerDto;
import board.data.BoardDao;
import board.data.BoardDto;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class BoardContentController {
	private BoardDao boardDao;
	private AnswerDao answerDao;
	
	@GetMapping("/simple/content")
	public String content(Model model, @RequestParam int num) {
		// 조회수 증가
		boardDao.updateReadCount(num);
		
		// dto 얻기
		BoardDto dto = boardDao.getData(num);
		
		// 해당 글에 대한 댓글 가져오기
		List<AnswerDto> alist = answerDao.getAnswers(num);
		
		// model에 저장
		model.addAttribute("dto", dto);
		model.addAttribute("alist", alist);
		model.addAttribute("acount", alist.size()); // 댓글 개수
		
		return "content";
	}
	
	@GetMapping("/simple/delete")
	public String delete(@RequestParam int num) {
		boardDao.deleteBoard(num);
		return "redirect:./list";
	}
	
	@GetMapping("/simple/updateform")
	public String updateForm(Model model, @RequestParam int num) {
		// num에 해당하는 dto 얻기
		BoardDto dto = boardDao.getData(num);
		
		// dto를 model에 저장
		model.addAttribute("dto", dto);
		
		return "updateform";
	}
	
	@PostMapping("/simple/updateprocess")
	public String update(@ModelAttribute BoardDto dto, @RequestParam MultipartFile upload, HttpServletRequest request) {
		String path = request.getSession().getServletContext().getRealPath("/WEB-INF/upload");
		
		// 사진을 선택하지 않은 경우 photo에 null 값을 보낸다
		String photo = "";
		if(upload.getOriginalFilename().equals(""))
			dto.setPhoto(null);
		else {
			// 랜덤 파일명을 photo에 저장
			photo = UUID.randomUUID().toString();
			dto.setPhoto(photo);
		}
		
		// 업로드
		try {
			upload.transferTo(new File(path + "/" + photo));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// db 수정
		boardDao.updateBoard(dto);
		
		return "redirect:./content?num="+dto.getNum();
	}
	
	// 댓글 추가
	@PostMapping("/simple/addanswer")
	public String addAnswer(@ModelAttribute AnswerDto dto) {
		// 댓글 추가
		answerDao.insertAnswer(dto);
		
		return "redirect:./content?num="+dto.getNum();
	}
}
