package com.myapp.SpringMVCApp.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.myapp.SpringMVCApp.model.User;
import com.myapp.SpringMVCApp.dao.UserDaoImpl;
@Controller
public class RegistrationController {
  @Autowired
  public UserDaoImpl userService;
  @RequestMapping(value = "/register", method = RequestMethod.GET)
  public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("register");
    mav.addObject("user", new User());
    System.out.println("Inside the registeration controller");
    System.out.println(this.toString());
    return mav;
    
  }
  @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
  //@PostMapping(path="/registerProcess")
  public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("user") User user) {
	  System.out.println("Inside the registerProcess method");
	  System.out.println(" User :"+user.getFirstname());
	  System.out.println(" User :"+user.getPassword());
	  userService.register(user);
	  System.out.println("Inside the /registerProcess controller");
	  return new ModelAndView("welcome", "firstname", user.getFirstname());
  }
}