package study.spring.day1113;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class PhotoUploadController {
	@GetMapping("/uploadform1")
	public String upload1() {
		return "uploadform1";
	}
	
	@GetMapping("/uploadform2")
	public String upload2() {
		return "uploadform2";
	}
	
	@PostMapping("/upload1")
	public String uploadgo1(Model model, @RequestParam String title, @RequestParam MultipartFile upload, HttpServletRequest request) {
		// 사진을 업로드할 배포된 프로젝트 내의 경로의 위치를 구함
		String path = request.getSession().getServletContext().getRealPath("/resources/upload");
		System.out.println(path);
		
		// 현재 업로드한 파일명
		String filename = upload.getOriginalFilename();
		
		// 실제 파일명에서 확장자만 얻는 방법
		// 마지막 .(dot)의 위치
		int dotIdx = filename.lastIndexOf(".");
		String extName = filename.substring(dotIdx); // abc.jpg일 경우 .jpg를 얻음
		
		// 실제 파일명이 아닌 랜덤 파일명으로 저장하기
		String filename2 = UUID.randomUUID().toString() + extName;
		
		//업로드
		try {
			upload.transferTo(new File(path + "/" + filename2));			
			model.addAttribute("path", path);
			model.addAttribute("photo", filename2);
			model.addAttribute("title", title);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "uploadresult1";
	}
	
	@PostMapping("/upload2")
	public String uploadgo2(Model model, HttpServletRequest request, @RequestParam String title, @RequestParam ArrayList<MultipartFile> upload) {
		// 사진을 업로드할 배포된 프로젝트 내의 경로의 위치를 구함
		String path = request.getSession().getServletContext().getRealPath("/resources/upload");
		System.out.println(path);
		
		// 제목 먼저 모델에 저장
		model.addAttribute("title", title);
		
		// 사진은 여러 장이므로 반복문으로 업로드
		// 랜덤 파일명을 저장할 List 선언
		List<String> files = new ArrayList<String>();
		
		for(MultipartFile multi : upload) {
			String f = multi.getOriginalFilename(); // 실제 파일명
			// 실제 파일에서 확장자 분리
			int extIdx = f.lastIndexOf(".");
			String ext = f.substring(extIdx);
			
			//업로드할 랜덤 파일명
			String filename = UUID.randomUUID().toString() + ext;
			
			files.add(filename); // 랜덤 파일명 저장
			
			// 업로드
			try {
				multi.transferTo(new File(path + "/" + filename));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		model.addAttribute("files", files); // 여러 개의 파일명들
		return "uploadresult2";
	}

}
