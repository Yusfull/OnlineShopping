package com.ehealth.presentation.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class SecurityTestCOntroller {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String customLogin(ModelMap map) {
		return "login.html";
	}
}
