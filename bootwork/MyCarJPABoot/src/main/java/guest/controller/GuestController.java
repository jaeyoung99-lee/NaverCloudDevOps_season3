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
@RequiredArgsConstructor
public class GuestController {

	//storage class �꽑�뼵
	private final NcpObjectStorageService storageService;
	
	//dao
	private final GuestDao guestDao;
	
	//�뾽濡쒕뱶�븳 �뙆�씪紐� ���옣
	String photo;

	//踰꾩폆�꽕�엫 吏��젙
	private String bucketName="bitcamp-701ex";
	//���옣�븷 �뤃�뜑�꽕�엫 吏��젙
	private String folderName="bootmyshop";
	
	//�궗吏꾨쭔 癒쇱� �뾽濡쒕뱶�븯湲�
	@PostMapping("/guest/upload")
	public String uploadFile(@RequestParam("upload") MultipartFile upload)
	{
		System.out.println("upload:"+upload.getOriginalFilename());
		photo=storageService.uploadFile(bucketName, folderName, upload);
		return photo;
	}
	
	@PostMapping("/guest/insert")
	public void insert(@RequestBody GuestDto dto)
	{
		//誘몃━ �뾽濡쒕뱶�븳 photo 瑜� dto �뿉 �꽔湲�
		dto.setPhoto(photo);
		//db insert
		guestDao.addGuest(dto);
		//photo 珥덇린�솕
		photo=null;
	}
	
	@GetMapping("/guest/list")
	public List<GuestDto> list()
	{
		return guestDao.getAllGuests();
	}
	
	@DeleteMapping("/guest/delete")
	public void delete(@RequestParam("gnum") int gnum)
	{
		System.out.println("delete>>"+gnum);
		guestDao.deleteGuest(gnum);
	}

}








