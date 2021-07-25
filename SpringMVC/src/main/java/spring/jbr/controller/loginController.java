package spring.jbr.controller; 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import spring.jbr.model.User;
import spring.jbr.model.login;
import spring.jbr.service.UserService;


@Controller
public class loginController
{
	@Autowired
	UserService userservice;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView showlogin(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("login",new login());
		
		return mav;
	}
	@RequestMapping(value = "/loginprocess", method = RequestMethod.POST)
	public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("login") login login)
	{
		ModelAndView mav=null;
		User user= userservice.validateUser(login);
		
		if(null!= user) {
			mav = new ModelAndView("Welcome");
			mav.addObject("massage", "Username or Password is wrong!!!");
		}
		return mav;
	}

}


