/**
 * 
 */
package com.rest.presentation.controller;

import java.util.List;

import javax.persistence.MappedSuperclass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rest.business.domain.User;
import com.rest.business.service.UserService;

/**
 * @author Admin
 *
 */
@Controller
@RequestMapping("/rest/user")
public class RestController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView getUser(@PathVariable String id){
		
		User user = userService.getUserById(Integer.parseInt(id));
		
		ModelAndView mav = new ModelAndView();
		  mav.setViewName("showMessage");
		
		  mav.addObject("firstName", user.getFirstName());
		  mav.addObject("lastName", user.getLastName());
		  mav.addObject("email", user.getEmail());
		  
		  return mav;
		
	}

	@RequestMapping(method = RequestMethod.GET)
	
	 public ModelAndView getAllUsers() {
	
	  List<User> users=userService.getUsers();
	  
	  ModelAndView mav = new ModelAndView();
	  mav.setViewName("showMessage");
	
	  mav.addObject("message", "attributeValue");
	  return mav;
	
	 }
	
	  

}
