package pet.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/hello")
public class Controller2 {

	
	@RequestMapping(path ="/rest",method = RequestMethod.GET)
	@ResponseBody
    public Student restDemo(){
		Student a = new Student();
		a.address ="dd";
		a.name = "jj";
		return  a;
	}
}
