package org.zerock.myapp.controller;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Handles requests for the application home page.
 */
@Controller
@Log4j2
@NoArgsConstructor
public class HomeController {
	

	
	/**
	 Simply selects the home view to render by returning its name.
	 컨트롤러의 핸들러 메소드는 View 의 이름을 반환 한다.
	 */
//	@RequestMapping(value = "/", method = RequestMethod.GET)
	@GetMapping("/")
	public String home(Locale locale, Model model) {
		log.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.DEFAULT, DateFormat.DEFAULT, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
}
