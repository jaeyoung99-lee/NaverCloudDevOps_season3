package data.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import data.dto.MemberDto;
import data.service.MemberService;
import lombok.RequiredArgsConstructor;
import naver.storage.NcpObjectStorageService;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class MemberController {
	private final MemberService memberService;
	
	// 스토리지 변수
	private final NcpObjectStorageService storageService;
	
	// 비밀번호 암호화를 위한 변수 선언
	private final PasswordEncoder passwordEncoder;
	
	// 버킷 네임
	private String bucketName = "bitcamp-701ex";
	
	// 폴더 네임
	private String folderName = "reactboot";
	
	// 업로드한 파일명
	private String uploadFilename;
	
	@GetMapping("/member/list")
	public Map<String, Object> list(){
		Map<String, Object> map = new HashMap<>();
		int totalCount = memberService.getTotalCount();
		List<MemberDto> mlist = memberService.getAllMembers();
		
		map.put("totalCount", totalCount);
		map.put("mlist", mlist);
		return map;
	}
	
	// 가입 시 먼저 사진 저장
	@PostMapping("/member/upload")
	public String uploadFile(@RequestParam("upload") MultipartFile upload) {
		uploadFilename = storageService.uploadFile(bucketName, folderName, upload);
		return uploadFilename;
	}
	
	@PostMapping("/member/insert")
	public String insert(@RequestBody MemberDto dto) {
		// pass는 암호화해서 db에 저장
		String pass = dto.getPass(); // pass : 암호화되지 않은 비밀번호
		String pass1 = passwordEncoder.encode(pass); // pass1 : 암호화된 비밀번호
		System.out.println("비밀번호 암호화 : " + pass1);
		
		// dto의 pass를 암호화된 pass1로 변경
		dto.setPass(pass1);
		
		// 업로드된 사진
		dto.setPhoto(uploadFilename);
		
		memberService.insertMember(dto);
		uploadFilename = null;
		return "SUCCESS";
	}
	
	// 아이디가 db에 존재하면 1, 존재하지 않으면 0을 반환
	@GetMapping("/member/idcheck")
	public int idcheck(@RequestParam("myid") String myid) {
		return memberService.getIdCheck(myid);
	}
}
