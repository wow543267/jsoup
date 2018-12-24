package com.tutorial.SpringTutorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.fetchExchangeRateService;

import java.io.IOException;
//-----------------------------------------------------
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONValue;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import model.ExchangeRateBean;

//---------------------------

@Controller
public class userController {

	String back;

	// @Autowired
//	private fetchExchangeRateService aa;
//
//	userController() throws Exception {
//
//		back = aa.fetchData();
//
//	}

	String myBody;

	String myHTMLHead = "<!DOCTYPE HTML>\r\n" + "<html>\r\n" + "<head>\r\n"
			+ "<title>My first Page by thymeleaf</title>\r\n"
			+ "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n" + "</head>\r\n";

	String myHTMLButtom = "</html>";

	public String GetRateBadyString(String str) {

		return "<body>\r\n" + "	<div > " + str + " </div></div>\r\n" + "</body>\r\n";

	}

	public String fetchData() throws IOException {
		String myhomepage = "美元   30.25"+"人民幣  4.42";
 		String tempStr = "";
		int idx2 = 0;
		int idx1 = 0;
		String str_n = "";
		String url = "https://www.esunbank.com.tw/bank/personal/deposit/rate/forex/foreign-exchange-rates";
		String header = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.167 Safari/537.36";
		List<ExchangeRateBean> temp = new ArrayList<ExchangeRateBean>();

		tempStr += Jsoup.connect(url).header("user-agent", header).get();

		idx1 = tempStr.indexOf("美元");

		// str_n= tempStr.substring(idx1+5, idx1+10);
		myhomepage += "美元"; // GetRateBadyString("美元");

		myhomepage += "30.25";

		myhomepage += "人民幣"; // GetRateBadyString("美元");

		myhomepage += "4.427\n";
		
		myhomepage += "日圓"; // GetRateBadyString("美元");

		myhomepage += "4.427\n";
		
		myhomepage += "歐圓"; // GetRateBadyString("美元");

		myhomepage += "4.427\n";
		
		myhomepage += "澳幣"; // GetRateBadyString("美元");

		myhomepage += "4.427\n";
		// idx2=tempStr.indexOf("even", idx1);

		// str_n= tempStr.substring(idx2+5, idx2+10);

		// myhomepage+=GetRateBadyString(str_n);

		// myhomepage+=myHTMLButtom;
		return myhomepage;
	}
	public String fetchData1() throws IOException {
		String myhomepage = "美元   30.25"+"人民幣  4.42";
		return myhomepage;
	}
	public String fetchData2() throws IOException {
		String myhomepage = "美元   30.25"+"人民幣  4.42";
		return myhomepage;
		
	}

//	public String fetchData() throws Exception {
//
//		String url = "https://www.esunbank.com.tw/bank/personal/deposit/rate/forex/foreign-exchange-rates";
//		String header = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.167 Safari/537.36";
//		List<ExchangeRateBean> temp = new ArrayList<ExchangeRateBean>();
//		Document doc = Jsoup.connect(url).header("user-agent", header).get();
//		// 選取USD
//		Elements selectUSD = doc.select("href*=/bank/personal/deposit/rate/forex/exchange-rate-chart?Currency=USD/TWD");
//		// 選取JPY
//		Elements selectJPY = doc.select("href*=/bank/personal/deposit/rate/forex/exchange-rate-chart?Currency=JPY/TWD");
//		// 選取EUR
//		Elements selectEUR = doc.select("href*=/bank/personal/deposit/rate/forex/exchange-rate-chart?Currency=EUR/TWD");
//		// 選取AUD
//		Elements selectAUD = doc.select("href*=/bank/personal/deposit/rate/forex/exchange-rate-chart?Currency=AUD/TWD");
//		// 選取CAD
//		Elements selectCAD = doc.select("href*=/bank/personal/deposit/rate/forex/exchange-rate-chart?Currency=CAD/TWD");
//
//		ExchangeRateBean rate = new ExchangeRateBean();
//		Double.valueOf(selectUSD.toString());
//		rate.setUSD(Double.valueOf(selectUSD.toString()));
//		rate.setJPY(Double.valueOf(selectJPY.toString()));
//		rate.setEUR(Double.valueOf(selectEUR.toString()));
//		rate.setAUD(Double.valueOf(selectAUD.toString()));
//		rate.setCAD(Double.valueOf(selectCAD.toString()));
//
//		temp.add(rate);
//
//		return JSONValue.toJSONString(temp);
//	}

	// ---------------------------------------------------

	@RequestMapping("/MyFirstPage")
	public String greeting(@RequestParam(value = "title", required = false, defaultValue = "鐵人賽 加油!") String title,
			Model model) throws Exception {
		title = fetchData1() + fetchData2();
		model.addAttribute("name", title);
		return "index";
	}

}