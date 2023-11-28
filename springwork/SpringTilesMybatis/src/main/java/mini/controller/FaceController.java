package mini.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FaceController {
	@GetMapping("/face")
	public String face() {
		return "face/content";
	}
	
	@PostMapping("/face/rec")
	@ResponseBody
	public Map<String, String> faceRec(){
		Map<String, String> map = new HashMap<String, String>();
		
		return map;
	}
}
