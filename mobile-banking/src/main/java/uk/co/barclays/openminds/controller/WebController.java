package uk.co.barclays.openminds.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import uk.co.barclays.openminds.model.BankAccount;


@Controller
@RequestMapping("/")
public class WebController {

	final static Logger logger = LoggerFactory.getLogger(WebController.class);

	@RequestMapping(value = "error", method = RequestMethod.GET)
	public String error(HttpServletResponse response) {
		return "error";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("title", "Beacon chat");
		return "index";
	}

	@RequestMapping(value = "piechart", method = RequestMethod.GET)
	public String piechart(Model model) {
		model.addAttribute("data", genData());
		return "piechart";
	}
	
	@RequestMapping(value = "piechart", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String makePiechart(@RequestBody Map<String, ArrayList<ArrayList<Object>>> data, Model model) {
		model.addAttribute("data", data.get("data"));
		return "piechart";
	}
	
	@RequestMapping(value = "linechart", method = RequestMethod.GET)
	public String linechart() {
		return "montecarlo";
	}
	
	private ArrayList<ArrayList<Object>> genData(){
		Object[][] tmpData = new Object[][]{{"Category", "Spent"},
	             {"Rent", 250},
	             {"Food", 100},
	             {"Travel", 70},
	             {"Fuel", 65},
	             {"Bills", 60},
	             {"Enterteinment", 50},
	             {"Heathcare", 25},
	             {"Junkfood", 15},
	             {"Gym", 15}};
		ArrayList<ArrayList<Object>> data = new ArrayList<ArrayList<Object>>();
		for ( Object[] s : tmpData){
			data.add(new ArrayList<Object>(Arrays.asList(s)));
		}
		return data;
	}
	

}
