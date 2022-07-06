package springmvcjconfig.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import springmvcjconfig.model.User;

@Controller
public class HomeController {

	@RequestMapping("")
	public String baseUrl() {
		return "redirect:/detailForm";
	}
	
	@RequestMapping("/detailForm")
	public String fillForm(Model model) {
		model.addAttribute("user", new User());
		return "contact";
	}
	
	@RequestMapping("/processForm")
	public String fillForm(@ModelAttribute("user") @Valid User user, BindingResult result) {
		System.out.println(user);
		return "detailSuccess";
	}
}
