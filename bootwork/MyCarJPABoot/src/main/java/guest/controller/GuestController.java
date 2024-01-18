package guest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import guest.data.GuestDao;
import guest.data.GuestDto;
import lombok.RequiredArgsConstructor;
import naver.storage.NcpObjectStorageService;

@RestController
@RequiredArgsConstructor // final 붙은 것만 자동 주입
public class GuestController {
	//storage class 선언
	private final NcpObjectStorageService storageService;
	
	// dao
	private final GuestDao guestDao;
	
	// 업로드한 파일명 저장
	String photo;
	
	//버켓네임 지정
	private String bucketName="bitcamp-701ex";
	
	//저장할 폴더네임 지정
	private String folderName="bootmyshop";
	
	// 사진만 먼저 업로드하기
	@PostMapping("/guest/upload")
	public String uploadFile(@RequestParam("upload") MultipartFile upload) {
		System.out.println("upload : " + upload.getOriginalFilename());
		photo = storageService.uploadFile(bucketName, folderName, upload);
		return photo;
	}
	
	// 사진 db에 넣기
	@PostMapping("/guest/insert")
	public void insert(@RequestBody GuestDto dto) {
		// 미리 업로드한 photo를 dto에 넣기
		dto.setPhoto(photo);
		
		// db insert
		guestDao.addGuest(dto);
		
		// photo 초기화 : 초기화를 해줘야지 같은 사진이 안 들어감
		photo = null;
	}
	
	// 목록 출력
	@GetMapping("/guest/list")
	public List<GuestDto> list(){
		return guestDao.getAllGuests();
	}
	
	// 삭제
	@DeleteMapping("/guest/delete")
	public void delete(@RequestParam("gnum") int gnum) {
		guestDao.deleteGuest(gnum);
	}
}
