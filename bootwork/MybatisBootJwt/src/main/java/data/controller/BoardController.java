package data.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import data.dto.BoardDto;
import data.service.BoardService;
import lombok.RequiredArgsConstructor;
import naver.storage.NcpObjectStorageService;
import security.setting.JwtTokenProvider;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class BoardController {
	private final BoardService boardService;
	
	// 스토리지 변수
	private final NcpObjectStorageService storageService;
	
	private String bucketName = "bitcamp-701ex";
	private String folderName = "reactboot";
	
	@PostMapping("/board/insert")
	public void insertBoard(@RequestParam("upload") MultipartFile upload, @ModelAttribute BoardDto dto) {
		// 업로드 파일 이름 확인
		System.out.println("upload file : " + upload.getOriginalFilename());
		
		// 로그인한 아이디
		String myid = JwtTokenProvider.getUserIdFromJWT(dto.getToken());
		System.out.println("myid : " + myid);
		System.out.println("subject: " + dto.getSubject());
	}
}
