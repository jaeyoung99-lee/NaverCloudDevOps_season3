package mini.controller;

// 네이버 음성합성 Open API 예제
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;

// Example of Naver Papago Text Translation API
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import java.net.URL;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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

	// 번역 후 반환하는 메서드
	public String translate(String text1, String nation) {
		String clientId = "iqqqyxbiud"; //Application client ID value";
	    String clientSecret = "4q72y46t7rTMPP456psCagvo8B917aeuw9bd0HMe"; //Application client secret value";
	    String returnValue = "";
	    try {
    		String text = URLEncoder.encode(text1, "UTF-8");
            String apiURL = "https://naveropenapi.apigw.ntruss.com/nmt/v1/translation";
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
            con.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);
            
            // post request
            String postParams = "source=ko&target=" + nation + "&text=" + text;
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(postParams);
            wr.flush();
            wr.close();
            int responseCode = con.getResponseCode();
            BufferedReader br;
            
            if(responseCode==200) { // Successful call
                br = new BufferedReader(new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8));
            } 
            else {  // Error occurred
                br = new BufferedReader(new InputStreamReader(con.getErrorStream(), StandardCharsets.UTF_8));
            }
            
            String inputLine;
            StringBuffer response = new StringBuffer();
            
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            
            br.close();
            // System.out.println(response.toString()); // Console에 번역된 내용 찍어줌
            // returnValue = response.toString();
            
            // message.result.translatedText 구조 : JSON 데이터 추출
            JSONObject ob = new JSONObject(response.toString());
            JSONObject result = ob.getJSONObject("message").getJSONObject("result");
            
            returnValue = result.getString("translatedText");
        } 
	    catch (Exception e) {
            System.out.println(e);
        }
	    
	    return returnValue; // 번역된 내용
	}
	
	@GetMapping("/guest/list")
	public String login(Model model, @RequestParam(defaultValue = "en") String nation) { // nation : 기본 번역 언어는 영어
		int totalCount = guestService.getAllGuest().size();
		List<GuestDto> glist = guestService.getAllGuest();
		
		// dto에 번역 내용 저장
		for(GuestDto dto : glist) {
			// 해당 국가 언어로 번역해서 반환
			String trans = translate(dto.getGuest_content(), nation);
			dto.setTrans_lang(trans);
		}
		
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("glist", glist);
		
		return "guest/guestlist";
	}
	
	@PostMapping("/guest/insert")
	public String insertGuest(@ModelAttribute GuestDto dto, @RequestParam MultipartFile upload, @RequestParam String nation) {
		// 네이버 스토리지에 업로드 후 랜덤 파일명 반환
		String guest_photo = storageService.uploadFile(bucketName, folderName, upload);
		
		// dto에 사진 파일명 저장
		dto.setGuest_photo(guest_photo);
		
		// db에 insert
		guestService.insertGuest(dto);
		
		// 목록으로 리다이렉트
		return "redirect:./list?nation="+nation;
	}
	
	// 목소리 반환하는 메서드
	@GetMapping("/guest/voice")
	@ResponseBody
	public String getVoice(String message, String lang, HttpServletRequest request) {
		// 목소리 파일을 업로드할 경로 구하기
		String path = request.getSession().getServletContext().getRealPath("/resources/voice");
		System.out.println(path);
		String clientId = "bo5bt56sn6"; // 애플리케이션 클라이언트 아이디값";
        String clientSecret = "wqh1giEEqLREoqoRbIc0jsoz62qClrxZd97d6IrZ"; // 애플리케이션 클라이언트 시크릿값";
        try {
            String text = URLEncoder.encode(message, "UTF-8"); // 13자
            String apiURL = "https://naveropenapi.apigw.ntruss.com/tts-premium/v1/tts";
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
            con.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);
            
            // post request
            // 나라별 목소리 지정
            String nationVoice = "";
            if(lang.equals("ko")) {
            	nationVoice = "neunseo"; // 한국어
            }
            else if(lang.equals("en")) {
            	nationVoice = "matt"; // 영어
            }
            else if(lang.equals("ja")) {
            	nationVoice = "dnaomi_joyful"; // 일본어
            }
            else if(lang.equals("zh-CN")) {
            	nationVoice = "liangliang"; // 중국어
            }
            else if(lang.equals("es")) {
            	nationVoice = "jose"; // 스페인어
            }
            
            String postParams = "speaker=" + nationVoice + "&volume=0&speed=0&pitch=0&format=mp3&text=" + text;
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(postParams);
            wr.flush();
            wr.close();
            int responseCode = con.getResponseCode();
            BufferedReader br;
            
            if(responseCode==200) { // 정상 호출
                InputStream is = con.getInputStream();
                int read = 0;
                byte[] bytes = new byte[1024];
                
                // 랜덤한 이름으로 mp3 파일 생성
                // String tempname = Long.valueOf(new Date().getTime()).toString(); // 초로 환산
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy년MM월dd일HH시mm분ss초");
                String tempname = sdf.format(new Date());
                // File f = new File(path + "/newvoice.mp3");
                File f = new File(path + "/" + tempname + ".mp3");
                f.createNewFile();
                OutputStream outputStream = new FileOutputStream(f);
                
                while ((read =is.read(bytes)) != -1) {
                    outputStream.write(bytes, 0, read);
                }
                
                is.close();
                return tempname + ".mp3";
            } 
            else {  // 오류 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = br.readLine()) != null) {
                    response.append(inputLine);
                }
                br.close();
                System.out.println(response.toString());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
		
		return "";
	}
	
}
