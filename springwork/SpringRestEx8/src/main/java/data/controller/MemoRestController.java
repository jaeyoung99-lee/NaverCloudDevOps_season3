package data.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import data.dao.MemoDao;
import data.dto.MemoDto;

@RestController
public class MemoRestController {
	@Autowired
	private MemoDao memoDao;
	
	private String photo; // 먼저 사진을 업로드하는데 그때 저장할 파일명
	
	// 파일 업로드 시 호출되는 메서드
	@PostMapping("/memo/upload")
	public String fileUpload(@RequestParam("upload") MultipartFile upload, HttpServletRequest request) {
		
		System.out.println("업로드한 파일명 : " + upload.getOriginalFilename());
		
		// 파일 업로드할 위치
		String path = request.getSession().getServletContext().getRealPath("/resources/upload");
		System.out.println(path);
		
		// 랜덤 파일명
		photo = UUID.randomUUID().toString();
		
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
		
		return photo;
	}
	
	@GetMapping("/memo/add")
	public void memoAdd(@RequestParam String nickname, @RequestParam String memo) {
		MemoDto dto = new MemoDto();
		dto.setNickname(nickname);
		dto.setMemo(memo);
		dto.setPhoto(photo);
		
		// db insert
		memoDao.insertMemo(dto);
	}
	
	// 메모 목록 json으로 반환
	@GetMapping("/memo/view")
	public List<MemoDto> getAllMemo(){
		return memoDao.getAllMemos();
	}
}
