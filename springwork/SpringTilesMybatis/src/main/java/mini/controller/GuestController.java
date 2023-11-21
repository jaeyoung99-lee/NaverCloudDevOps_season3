package mini.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GuestController {
	@GetMapping("/guest/list")
	public String login() {
		return "guest/guestlist";
	}
}
