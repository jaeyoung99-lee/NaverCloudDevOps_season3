package data.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		memberService.insertMember(dto);
		uploadFilename = null;
		return "SUCCESS";
	}
}
