package uk.co.barclays.openminds.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = { "/api" })
public class ApiController {
	final static Logger logger = LoggerFactory.getLogger(ApiController.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Transactional
	@RequestMapping(value = "/connect", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, List<Object>> connect(@RequestBody Object connect,
			HttpServletResponse response) {

		return new HashMap<String, List<Object>>();
	}

	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public Object error(HttpServletResponse response) {
		response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		return new Object();
	}

	
}
