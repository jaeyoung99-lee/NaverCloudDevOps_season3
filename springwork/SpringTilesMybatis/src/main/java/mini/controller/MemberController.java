package mini.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import mini.dao.MemberDao;
import mini.dto.MemberDto;

@Controller
@RequiredArgsConstructor
public class MemberController {
	@NonNull
	private MemberDao memberDao;
	
	@GetMapping("/member/form")
	public String login() {
		return "member/memberform";
	}
	
	@GetMapping("/member/list")
	public String memberList(Model model) {
		// 총 멤버 수 얻기
		int totalCount = memberDao.getTotalCout();
		
		model.addAttribute("totalCount", totalCount);
		
		return "member/memberlist";
	}
	
	@PostMapping("/member/addmember")
	public String addMember(HttpServletRequest request, @ModelAttribute MemberDto dto, @RequestParam MultipartFile upload) {
		// 업로드할 실제 경로 구하기
		String path = request.getSession().getServletContext().getRealPath("/resources/upload");
		System.out.println(path);
		
		// 사진을 업로드한 경우 랜덤 파일명을 photo에 저장, 안한 경우 no라고 저장
		String photo = null;
		
		if(upload.getOriginalFilename().equals("")) {
			photo = "no photo";
		}
		
		else {
			photo = UUID.randomUUID().toString();
			
			// 실제 업로드하기
			try {
				upload.transferTo(new File(path + "/" + photo));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// dto에 photo 넣기
		dto.setPhoto(photo);
		
		// db에 insert
		memberDao.insertMember(dto);
		
		return "redirect:./list";
	}
	
	@GetMapping("/member/idcheck")
	@ResponseBody 
	public Map<String, Integer> getIdCouunt(@RequestParam String myid) {
		int count = memberDao.searchIdCount(myid);
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("count", count);
		return map;
	}
	
	@GetMapping("/member/search")
	@ResponseBody
	List<MemberDto> getSearchList(@RequestParam String field, @RequestParam String word) {
		return memberDao.getSearchMember(field, word);
	}
	
	@GetMapping("/member/delete")
	@ResponseBody
	public void deleteMember(@RequestParam int num) {
		memberDao.deleteMember(num);
	}
}
