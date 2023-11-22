package mini.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import mini.dao.MemberDao;

@Controller
public class LoginController {
	
	@Autowired
	private MemberDao memberDao;
	
	@GetMapping("/login/main")
	public String login() {
		return "login/loginmain";
	}
	
	@GetMapping("/login/process")
	@ResponseBody
	Map<String, Object> login(@RequestParam boolean saveid, @RequestParam String myid, @RequestParam String pass, HttpSession session) {
		System.out.println("saveid : " + saveid);
		Map<String, Object> map = new HashMap<String, Object>();
		
		// 로그인 성공 여부
		boolean blogin = memberDao.isLoginCheck(myid, pass);
		if(blogin) {
			// 세션 유지시간
			session.setMaxInactiveInterval(60 * 60 * 6);
			
			// 로그인 성공 시 세션에 저장할 내용들
			session.setAttribute("loginok", "yes");
			session.setAttribute("saveid", saveid ? "yes" : "no");
			session.setAttribute("myid", myid);
			
			// 아이디에 해당하는 이름 얻기
			String myname = memberDao.getData(myid).getName();
			session.setAttribute("myname", myname);

			// 아이디에 해당하는 사진 얻기
			String myphoto = memberDao.getData(myid).getPhoto();
			session.setAttribute("myphoto", myphoto);
			
			map.put("success", true);
		}
		else {
			map.put("success", false); // 로그인 실패 시
		}
		
		return map;
	}
	
	@GetMapping("/login/logout")
	@ResponseBody
	public void logout(HttpSession session) {
		session.removeAttribute("loginok");
	}
	
	// 프로필 사진 변경
	@PostMapping("/login/photochange")
	@ResponseBody
	Map<String, String> photoChange(@RequestParam MultipartFile upload, HttpSession session, HttpServletRequest request){
		// 현재 로그인한 아이디 얻기
		String myid = (String)session.getAttribute("myid"); // 반환 타입이 Object라서 String으로 형변환
		
		// 사진을 업로드할 경로
		String path = request.getSession().getServletContext().getRealPath("/resources/upload");
		System.out.println(path);
		
		// 랜덤 파일명 얻기
		String fileName = UUID.randomUUID().toString();
		
		// 사진 업로드
		try {
			upload.transferTo(new File(path + "/" + fileName));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// db 수정
		memberDao.updatePhoto(fileName, myid);
		
		// session에서도 사진 변경
		session.setAttribute("myphoto", fileName);
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("fileName", fileName);
		
		return map;
	}
}
