package service;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONValue;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import model.ExchangeRateBean;

@Service
public class fetchExchangeRateService {

	public String fetchData() throws Exception {

		String url = "https://www.esunbank.com.tw/bank/personal/deposit/rate/forex/foreign-exchange-rates";
		String header = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.167 Safari/537.36";
		List<ExchangeRateBean> temp = new ArrayList<ExchangeRateBean>();
		Document doc = Jsoup.connect(url).header("user-agent", header).get();
		// 選取USD
		Elements selectUSD = doc.select("href*=/bank/personal/deposit/rate/forex/exchange-rate-chart?Currency=USD/TWD");
		// 選取JPY
		Elements selectJPY = doc.select("href*=/bank/personal/deposit/rate/forex/exchange-rate-chart?Currency=JPY/TWD");
		// 選取EUR
		Elements selectEUR = doc.select("href*=/bank/personal/deposit/rate/forex/exchange-rate-chart?Currency=EUR/TWD");
		// 選取AUD
		Elements selectAUD = doc.select("href*=/bank/personal/deposit/rate/forex/exchange-rate-chart?Currency=AUD/TWD");
		// 選取CAD
		Elements selectCAD = doc.select("href*=/bank/personal/deposit/rate/forex/exchange-rate-chart?Currency=CAD/TWD");

		ExchangeRateBean rate = new ExchangeRateBean();
		Double.valueOf(selectUSD.toString());
		rate.setUSD(Double.valueOf(selectUSD.toString()));
		rate.setJPY(Double.valueOf(selectJPY.toString()));
		rate.setEUR(Double.valueOf(selectEUR.toString()));
		rate.setAUD(Double.valueOf(selectAUD.toString()));
		rate.setCAD(Double.valueOf(selectCAD.toString()));

		temp.add(rate);

		return JSONValue.toJSONString(rate);
	}
}
