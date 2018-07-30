package com.bridgeit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bridgeit.model.UserModel;
import com.bridgeit.service.UserService;

@RestController
@ControllerAdvice
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ResponseEntity<UserModel> registrationUser(@Valid @RequestBody UserModel userModel, BindingResult result) {
		System.out.println(userModel);
		System.out.println(result);
		List<ObjectError> list=  result.getAllErrors();
		System.out.println(list+"------");
		if (result.hasErrors()) {
			return new ResponseEntity<UserModel>(userModel ,HttpStatus.BAD_REQUEST);
		}
		userService.callToUserdDAO(userModel);
		return new ResponseEntity<UserModel>(userModel,HttpStatus.OK);
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<UserModel> userLogin(@Valid @RequestBody  UserModel userModel,  BindingResult result) {
		if (result.hasErrors()) {
			return new ResponseEntity<UserModel>(HttpStatus.BAD_REQUEST);
		}
		userService.callToUserdDAO(userModel);
		return new ResponseEntity<UserModel>(HttpStatus.OK);

	}

}
