/**
 * 
 */
package com.rest.presentation.controller;

import java.util.List;

import javax.persistence.MappedSuperclass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.rest.business.domain.RequestDTO;
import com.rest.business.domain.ResponseDTO;
import com.rest.business.domain.User;
import com.rest.business.service.UserService;

/**
 * @author Admin
 *
 */
@Controller
@RequestMapping("/rest/user1")
public class RestController1 {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/second/{id}", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody ResponseEntity<ResponseDTO> postUserAndResponseAsJason(@RequestBody RequestDTO requestDTO,@PathVariable String id) {
		
				
		ResponseDTO responseDTO = new ResponseDTO();
		
		responseDTO.setUserid(requestDTO.getUserid());
		responseDTO.setFirstName(requestDTO.getFirstName());
		responseDTO.setLastName(requestDTO.getLastName());
		responseDTO.setEmail(requestDTO.getEmail());
		
		ResponseEntity<ResponseDTO> responseEntity = null;
		responseEntity = new ResponseEntity<ResponseDTO>(responseDTO, getHttpStatus(requestDTO));
		
		
		
		return responseEntity;
		
	}
	@RequestMapping(value = "/third/{id}", method = RequestMethod.GET, consumes = {
			MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody ResponseEntity<ResponseDTO> getUserAndResponseAsJason(@PathVariable String id) {
		
		User user = userService.getUserById(Integer.parseInt(id));
		
		ResponseDTO responseDTO = new ResponseDTO();
		System.out.println("Inside 3rd.....id is ...."+id);
		responseDTO.setUserid(user.getUserid());
		responseDTO.setFirstName(user.getFirstName());
		responseDTO.setLastName(user.getLastName());
		responseDTO.setEmail(user.getEmail());
		
		ResponseEntity<ResponseDTO> responseEntity = null;
		responseEntity = new ResponseEntity<ResponseDTO>(responseDTO, getHttpStatus(null));
		
		System.out.println("Inside 3rd and response is..."+responseDTO.getEmail());
		
		return responseEntity;
		
	}
	
	@RequestMapping(value = "/fourth/{id}", method = RequestMethod.GET, consumes = {
			MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public ModelAndView getUserAndAReturnView(@PathVariable String id)
	{
		
		User user = userService.getUserById(Integer.parseInt(id));
		
		ModelAndView mav = new ModelAndView();
		  mav.setViewName("user");
		
		  mav.addObject("firstName", user.getFirstName());
		  mav.addObject("lastName", user.getLastName());
		  mav.addObject("email", user.getEmail());
		  
		  System.out.println("Inside 4th and response is..."+user.getEmail());
		 // return new ModelAndView("user", "email", "email.com");
		  return mav;
		
	}
	
	
	@RequestMapping(value = "/fifth/{id}", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public ModelAndView getUserAndAReturnViewToClient(@PathVariable String id) {
		
		User user = userService.getUserById(Integer.parseInt(id));
		
		ModelAndView mav = new ModelAndView();
		  mav.setViewName("user");
		
		  mav.addObject("firstName", user.getFirstName());
		  mav.addObject("lastName", user.getLastName());
		  mav.addObject("email", user.getEmail());
		  
		  System.out.println("Inside 4th and response is..."+user.getEmail());
		 // return new ModelAndView("user", "email", "email.com");
		  return mav;
		
	}
	
	private HttpStatus getHttpStatus(RequestDTO requestDTO){
		
		if (requestDTO != null) {
			if (requestDTO.getFirstName().equals("Arun")) {
				return HttpStatus.OK;
			} else if (requestDTO.getLastName().equals("Kumar")) {
				return HttpStatus.CREATED;
			} else {
				return HttpStatus.ACCEPTED;
			}
		} else {
			return HttpStatus.CREATED;
		}
	}

	@RequestMapping(method = RequestMethod.GET)
	
	 public ModelAndView getAllUsers() {
	
	  List<User> users=userService.getUsers();
	  
	  ModelAndView mav = new ModelAndView();
	  mav.setViewName("user");
	
	  mav.addObject("message", "attributeValue");
	  return mav;
	
	 }

}
