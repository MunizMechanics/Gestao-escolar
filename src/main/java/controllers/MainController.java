package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MainController {
	
	@Autowired
	public MainController() {
	}
	
	@RequestMapping("/menu")
	public String menu(Model model) {
		return "menu";
	}
	
    @RequestMapping("/")
    public String index() {
        return "index";
    }
    
    @RequestMapping("/home")
    public String home() {
    	return "menu";
    }



}
