package spring.jbr.controller;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import spring.jbr.dao.Userdao;
import spring.jbr.model.User;

@Controller
public class RegisterController 
{
	@Autowired
	public spring.jbr.service.UserService userservice;
	
	@RequestMapping(value ="/Register",method = RequestMethod.GET)
	public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView mav = new ModelAndView("Register");
		mav.addObject("user", new spring.jbr.model.User());
		return mav;
	}
	@RequestMapping(value = "/RegisterProcess",method = RequestMethod.POST)
	public ModelAndView adduser(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("user") Userdao user)
	{
		userservice.register(user);
		return new ModelAndView("welcome","Firstname",((User) user).getFirstname());
	}
		
	
}
