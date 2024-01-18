package mycar.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import mycar.data.MyCarCommentDto;
import mycar.data.MyCarDto;
import mycar.repository.MyCarCommentDao;
import mycar.repository.MyCarDao;
import naver.storage.NcpObjectStorageService;

@Controller
@RequiredArgsConstructor
public class MyCarController {
	private final MyCarDao myCarDao;
	private final MyCarCommentDao commentDao;

	//storage class �꽑�뼵
	private final NcpObjectStorageService storageService;

	//踰꾩폆�꽕�엫 吏��젙
	private String bucketName="bitcamp-701ex";
	//���옣�븷 �뤃�뜑�꽕�엫 吏��젙
	private String folderName="bootmyshop";

	//	@GetMapping("/")
	//	public String list(Model model)
	//	{
	//		//�쟾泥닿갗�닔
	//		Long totalCount=myCarDao.getTotalCount();
	//		//�쟾泥대ぉ濡� 媛��졇�삤湲�
	//		List<MyCarDto> list=myCarDao.getAllCars();
	//
	//		model.addAttribute("totalCount", totalCount);
	//		model.addAttribute("list", list);
	//		return "mycar/mycarlist";
	//	}

	int pageSize;

	@GetMapping("/")
	public String list(Model model,@RequestParam(value = "more",defaultValue = "0") int more)
	{
		//more 媛� 0�씠硫� 湲곕낯 3媛쒕쭔 異쒕젰
		//o�씠 �븘�땲硫� 湲곕낯�궗�씠利덉뿉 more 媛� 異붽��빐�꽌 紐⑸줉 媛��졇�삤湲�
		if(more==0)
			pageSize=3;
		else
			pageSize+=more;
		//�럹�씠吏뺤쿂由щ�� �쐞�븳 �겢�옒�뒪
		Pageable pageable=PageRequest.of(0, pageSize,Sort.by("num").ascending());

		//�럹�씠吏��뿉 �븘�슂�븳 留뚰겮留� 媛��졇�삤湲�
		Page<MyCarDto> result=myCarDao.getAllCars(pageable);
		List<MyCarDto> list=result.getContent();
		for(MyCarDto dto:list)
		{
			//�뙎湲� 媛��닔 ���옣
			int acount=commentDao.getMyCarCommentList(dto.getNum()).size();
			dto.setCommentcount(acount);
		}
		model.addAttribute("totalCount",result.getTotalElements());
		model.addAttribute("totalPage",result.getTotalPages());
		model.addAttribute("list", list);
		model.addAttribute("pageSize", pageSize);

		return "mycar/mycarlist";
	}

	@GetMapping("/addcar")
	public String addform()
	{
		return "mycar/mycarform";
	}

	@PostMapping("/insert")
	public String insert(@ModelAttribute MyCarDto dto,@RequestParam("upload") MultipartFile upload)
	{
		//�씠誘몄�瑜� �뒪�넗由ъ��뿉 ���옣�썑 ���옣�맂 �뙆�씪紐낅컲�솚
		String carphoto=storageService.uploadFile(bucketName, folderName, upload);
		//dto �뿉 �궗吏꾪뙆�씪紐� ���옣
		dto.setCarphoto(carphoto);
		//db insert
		myCarDao.insertMyCar(dto);

		return "redirect:./";//紐⑸줉�쑝濡� �씠�룞
	}

	@GetMapping("detail")
	public String detail(Model model,@RequestParam("num") Long num)
	{
		MyCarDto dto=myCarDao.getData(num);
		model.addAttribute("dto", dto);
		return "mycar/mycardetail";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("num") Long num)
	{
		//�뒪�넗由ъ��쓽 �궗吏꾨��꽣 �궘�젣�븯湲�
		String carphoto=myCarDao.getData(num).getCarphoto();
		storageService.deleteFile(bucketName, folderName, carphoto);
		//db �궘�젣
		myCarDao.deleteMyCar(num);
		//紐⑸줉�쑝濡� �씠�룞
		return "redirect:./";
	}

	@GetMapping("/carupdate")
	public String updateForm(Model model,@RequestParam("num") Long num)
	{
		//num �뿉 �빐�떦�븯�뒗 dto
		MyCarDto dto=myCarDao.getData(num);

		model.addAttribute("dto", dto);

		return "mycar/mycarupdateform";
	}	

	@PostMapping("/update")
	public String update(@ModelAttribute MyCarDto dto,@RequestParam("upload") MultipartFile upload)
	{
		if(upload.getOriginalFilename().equals("")) {
			//�뤌�뿉�꽌 �궗吏꾩쓣 �꽑�깮 �븞�븳寃쎌슦
			myCarDao.updateMycarNoPhoto(dto);
		}else {
			//�궗吏� �닔�젙�쟾�뿉 湲곗〈�궗吏� 癒쇱� �궘�젣�븯湲�
			String carphoto=myCarDao.getData(dto.getNum()).getCarphoto();
			storageService.deleteFile(bucketName, folderName, carphoto);

			//�깉濡� �뾽�뜲�씠�듃�븳 �궗吏� �뒪�넗由ъ��뿉 ���옣
			String newCarphoto=storageService.uploadFile(bucketName, folderName, upload);
			//dto �뿉�꽌 �궗吏꾨챸 �닔�젙
			dto.setCarphoto(newCarphoto);

			//db �닔�젙
			myCarDao.updateMyCar(dto);
		}

		//�긽�꽭蹂닿린 �럹�씠吏�濡� �씠�룞
		return "redirect:./detail?num="+dto.getNum();
	}

}


















