package com.example.springmvc;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.ServletConfigAware;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.support.RequestContextUtils;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController implements ServletContextAware, ServletConfigAware {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private ServletContext servletContext;
	private ServletConfig servletConfig;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpServletRequest request) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		
		WebApplicationContext parent = WebApplicationContextUtils.getWebApplicationContext(this.servletContext);
		logger.info("parent: " + parent + ""); // + this.servletContext.getAttribute(""));
		logger.info("child: " + RequestContextUtils.getWebApplicationContext(request));
		logger.info("servlet name: " + this.servletConfig.getServletName());
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;	
	}

	@Override
	public void setServletConfig(ServletConfig servletConfig) {
		this.servletConfig = servletConfig;		
	}
	
}
