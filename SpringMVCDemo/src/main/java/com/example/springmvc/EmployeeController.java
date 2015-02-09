package com.example.springmvc;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.springmvc.domain.Employee;

@Controller
@SessionAttributes("employee")
public class EmployeeController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@RequestMapping(value = "/employeeGetForm", method = RequestMethod.GET)
	public String getForm(Model model) {
		model.addAttribute(new Employee());
		return "employeeForm";
	}
	
	@RequestMapping(value = "/employeeDetails", method = RequestMethod.GET)
	public String getEmployeeDetails() {
		return "employeeDetails";
	}

	@RequestMapping(value = "/employeeSubmitForm", method = RequestMethod.POST)
	public String submitForm(@ModelAttribute Employee employee,
			BindingResult result, SessionStatus status, RedirectAttributes rd) {

		logger.info("Form post: " + employee);

		if (result.hasErrors()) {
			return "forward:employeeForm";
		} else {
			status.setComplete();
			rd.addFlashAttribute(employee);
			return "redirect:employeeDetails";
		}
	}

}
