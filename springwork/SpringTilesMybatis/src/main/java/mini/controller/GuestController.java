package mini.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import mini.dto.GuestDto;
import mini.service.GuestService;
import naver.storage.NcpObjectStorageService;

@Controller
public class GuestController {
	
	@Autowired
	private GuestService guestService;
	
	@Autowired
	private NcpObjectStorageService storageService;
	
	private String bucketName = "guest-ljy";
	private String folderName = "guest";

	@GetMapping("/guest/list")
	public String login(Model model) {
		int totalCount = guestService.getAllGuest().size();
		List<GuestDto> glist = guestService.getAllGuest();
		
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("glist", glist);
		return "guest/guestlist";
	}
	
	@PostMapping("/guest/insert")
	public String insertGuest(@ModelAttribute GuestDto dto, @RequestParam MultipartFile upload) {
		// 네이버 스토리지에 업로드 후 랜덤 파일명 반환
		String guest_photo = storageService.uploadFile(bucketName, folderName, upload);
		
		// dto에 사진 파일명 저장
		dto.setGuest_photo(guest_photo);
		
		// db에 insert
		guestService.insertGuest(dto);
		
		// 목록으로 리다이렉트
		return "redirect:./list";
	}
	
}
