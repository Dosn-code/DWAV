package com.pcwk.ehr.cmn;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class TxTransactionAdvice {

	final Logger LOG = LogManager.getLogger(getClass());
	PlatformTransactionManager transactionManager;
	
	public TxTransactionAdvice() {}
	
	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}


	public Object transactionAdvice(ProceedingJoinPoint pjp) throws Throwable{
		Object ret = null;
		TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());
		try {
			//분리된 비지니스 로직
			//----------------------
			ret = pjp.proceed();
			//----------------------	
			transactionManager.commit(status);
		}catch(Exception e) {
			LOG.debug("==========================");
			LOG.debug("=rollback****************=");
			LOG.debug("==========================");
			
			transactionManager.rollback(status);
			throw e;
		}
		
		return ret;
	}
	
}
