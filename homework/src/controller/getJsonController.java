package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import domain.fetchExchangeRateService;
import model.ExchangeRateBean;

@Controller
public class getJsonController {
	// @Autowired
	// private ApplicationContext context;

	@Autowired
	private fetchExchangeRateService service;

	@RequestMapping("/getjson")
	@ResponseBody
	public String getJSON(HttpSession session, ExchangeRateBean bean) throws Exception {
		System.out.println("MAPPING成功!");

		String data = (String) session.getAttribute("data");
		String result = service.fetchData(data);
		return result;

	}

}
