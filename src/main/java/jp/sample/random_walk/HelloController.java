package jp.sample.random_walk;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
	@GetMapping("/")
	public String getHello() {
		return "hello";
	}
	
	@GetMapping("/myloc")
	public String getMyloc() {
		return "myloc";
	}
}
