package com.example.springmvc.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletConfigAware;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.example.springmvc.domain.Employee;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	private Map<Integer, Employee> map = new HashMap<>();

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, Locale locale) {
		logger.info("Welcome home! The client locale is {}.", locale);
		model.addAttribute("serverTime", new Date());
		return "home";

	}

	@PostConstruct
	public void loadEmployees() {
		logger.info("Loading employees ..");
		map.put(1, new Employee("A", "B", "C", "D"));
		map.put(2, new Employee("E", "F", "G", "H"));
	}

	@RequestMapping(value = "/employees/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Employee retrieve(@PathVariable int id) {
		return map.get(id);
	}

	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public @ResponseBody
	List<Employee> retrieveAll() {
		return new ArrayList<Employee>(map.values());
	}

}
