package data.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
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
}
