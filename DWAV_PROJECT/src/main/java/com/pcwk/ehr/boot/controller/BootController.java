package com.pcwk.ehr.boot.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("bootController")
@RequestMapping("boot")
public class BootController {
	final Logger LOG = LogManager.getFormatterLogger(getClass());
	
	@RequestMapping(value = "/boot01.do", method = RequestMethod.GET)
	public String boot01() {
		LOG.debug("++++++++++++++++++++++++");
		LOG.debug("+boot01()+++++++++++++++");
		LOG.debug("++++++++++++++++++++++++");
		
//		<beans:property name="prefix" value="/WEB-INF/views/" />
//		<beans:property name="suffix" value=".jsp" />
		
		return "boot/boot01";
	}
	
	@RequestMapping(value = "/boot02.do", method = RequestMethod.GET)
	public String boot02() {
		LOG.debug("++++++++++++++++++++++++");
		LOG.debug("+boot02()+++++++++++++++");
		LOG.debug("++++++++++++++++++++++++");
		
//		<beans:property name="prefix" value="/WEB-INF/views/" />
//		<beans:property name="suffix" value=".jsp" />
		
		return "boot/boot02";
	}
	
}
