package study.spring.day1113;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home() {
		return "start";
	}
	
	@GetMapping("/form1")
	public String form1() {
		return "form1";
	}
	
	@GetMapping("/form2")
	public String form2() {
		return "form2";
	}
	
	@GetMapping("/form3")
	public String form3() {
		return "form3";
	}
	
	@GetMapping("/form4")
	public String form4() {
		return "form4";
	}
}
