package com.tutorial.SpringTutorial;

import javax.servlet.http.HttpSession;

import org.jboss.logging.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import service.fetchExchangeRateService;

@Controller
public class getjsonController {

	String data;

//	@Autowired
//	private fetchExchangeRateService service;

	@RequestMapping("/MyFirstJson")
	public String getJson(@RequestParam(value = "title", required = false, defaultValue = "ya!!!") String data,
			Model model, HttpSession session) throws Exception {

//		//String data = (String) session.getAttribute("data");

//
//		String back = service.fetchData();
		model.addAttribute("name", data);

		return "";

	}

}
