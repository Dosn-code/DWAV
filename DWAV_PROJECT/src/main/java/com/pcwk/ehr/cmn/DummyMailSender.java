package com.pcwk.ehr.cmn;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class DummyMailSender implements MailSender {
    final Logger  LOG = LogManager.getLogger(getClass());
    
	public DummyMailSender() {
	
	}

	public void send(SimpleMailMessage simpleMessage) throws MailException {
	    LOG.debug("************************");
	    LOG.debug("*개발, 실제로는 메일 보내지 않음!==*");
	    LOG.debug("************************");

	}

	public void send(SimpleMailMessage... simpleMessages) throws MailException {
	

	}

}
