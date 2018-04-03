package com.gc.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gc.creds.AlphaVantageAPICred;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.*;



@Controller

public class HomeController {

	@RequestMapping("/test")
	public ModelAndView testAAPL(Model model) {
		
		String API_KEY = AlphaVantageAPICred.AV_API_KEY;
		String jsonString = "";
		try {
			URL url = new URL("https://www.alphavantage.co/query?function=BATCH_STOCK_QUOTES&symbols=AAPL,FB&apikey=" + API_KEY);
			HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				jsonString += line;
			}
			con.disconnect();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		JsonParser jsonParser = new JsonParser();
		JsonElement element = jsonParser.parse(jsonString);
		JsonObject obj = element.getAsJsonObject();
		JsonElement quoteData = obj.get("Stock Quotes");
		return new ModelAndView("test", "json", quoteData);
	}

	
}
