package mini.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import mini.dto.BoardAnswerDto;
import mini.service.BoardAnswerService;

@RestController
public class BoardAnswerController {
	
	@Autowired
	private BoardAnswerService answerService;
	
	private String fileName; // 댓글에서 업로드되는 사진 파일명
	
	@PostMapping("/answer/upload")
	public Map<String, String> photoUpload(HttpServletRequest request, @RequestParam("") MultipartFile upload){
		String path = request.getSession().getServletContext().getRealPath("/resources/upload");
		
		// 랜덤 파일명
		fileName = UUID.randomUUID().toString();
		
		// 업로드
		try {
			upload.transferTo(new File(path + "/" + fileName));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("photoname", fileName);
		return map;
	}
	
	@PostMapping("/answer/insert")
	public void insertAnswer(@RequestParam int num, @RequestParam String msg, HttpSession session) {
		// 로그인한 정보
		String myname = (String)session.getAttribute("myname");
		String myid = (String)session.getAttribute("myid");
		
		BoardAnswerDto dto = new BoardAnswerDto();
		dto.setNum(num);
		dto.setAnsname(myname);
		dto.setAnsid(myid);
		dto.setAnsphoto(fileName);
		dto.setAnsmsg(msg);
		
		// db insert
		answerService.insertAnswer(dto);
		
		// 사진 초기화
		fileName = null;
	}
	
	@GetMapping("/answer/list")
	public List<BoardAnswerDto> answerList(@RequestParam int num){
		return answerService.getAnswerBoard(num);
	}
	
	@GetMapping("/answer/delete")
	public void deleteAnswer(@RequestParam int ansidx) {
		answerService.deleteAnswer(ansidx);
	}
}
