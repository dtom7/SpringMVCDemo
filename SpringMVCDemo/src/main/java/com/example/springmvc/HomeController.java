package com.example.springmvc;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

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
import org.springframework.web.context.ServletConfigAware;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.support.RequestContextUtils;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/home")
public class HomeController implements ServletContextAware, ServletConfigAware {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);
	private ServletContext servletContext;
	private ServletConfig servletConfig;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public String home(@PathVariable String name, Locale locale, Model model,
			HttpServletRequest request) {
		/*
		 * logger.info("Welcome home! The client locale is {}.", locale);
		 * 
		 * 
		 * logger.info("parent1: " +
		 * WebApplicationContextUtils.getWebApplicationContext
		 * (this.servletContext)); logger.info("parent2: " +
		 * this.servletContext.
		 * getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE
		 * )); logger.info("child1: " +
		 * RequestContextUtils.getWebApplicationContext(request));
		 * logger.info("child2: " +
		 * request.getAttribute(DispatcherServlet.WEB_APPLICATION_CONTEXT_ATTRIBUTE
		 * )); logger.info("servlet name: " +
		 * this.servletConfig.getServletName()); logger.info("servlet parma: " +
		 * this.servletConfig.getInitParameter("person"));
		 */

		/*synchronized (request.getSession().getId().intern()) {*/
		logger.info("Current thread: " + Thread.currentThread().getName() + " -- session id: " + request.getSession().getId());
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		/*}*/

		logger.info("Current thread: " + Thread.currentThread().getName()
				+ " done ...");

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("name", name);
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
