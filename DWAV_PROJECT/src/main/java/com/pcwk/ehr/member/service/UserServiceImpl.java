package com.pcwk.ehr.member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.pcwk.ehr.TestUserServiceException;
import com.pcwk.ehr.cmn.SearchVO;
import com.pcwk.ehr.member.dao.UserDao;
import com.pcwk.ehr.member.domain.Level;
import com.pcwk.ehr.member.domain.MakeHost;
import com.pcwk.ehr.member.domain.UserVO;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/*
 *         <!-- service -->
        <bean id="userService" class="com.pcwk.ehr.member.service.UserServiceImpl">
          <property name="userDao" ref="userDao"/>
          <property name="dataSource" ref="dataSource"></property>
          <property name="transactionManager" ref="transactionManager"/>
          <property name="mailSender" ref="mailSender"></property>
        </bean>
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	final Logger LOG = LogManager.getLogger(getClass());

	public static final boolean TRANSACTION_TEST = false;

	@Autowired
	UserDao userDao;

	MakeHost makeHost;

	@Autowired
	@Qualifier("mailSender")
	MailSender mailSender;

	public UserServiceImpl() {

	}

	@Override
	public void makeHosts() throws Exception {
		List<UserVO> list = userDao.getAll();
		for (UserVO user : list) {
			boolean upgradeHost = false;

			try {
				if (canMakeHost(user)) {
					makeHost(user);
				}
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		} // --for

	}// --upgradeLevels()

	@Override
	public int add(UserVO inVO) throws SQLException {
		// makeHost가 null인 경우, MakeHost.USER
		if(null == inVO.getMakeHost()) {
			inVO.setMakeHost(MakeHost.USER);
		}
		return userDao.doInsert(inVO);
	}

	/**
	 * UserVO의 MakeHost 값이 USER : host신청안함 UserVO의 MakeHost 값이 HOST : host
	 * 
	 * @throws IllegalAccessException
	 * 
	 */
	public Boolean canMakeHost(UserVO user) throws IllegalAccessException {

		MakeHost currentState = user.getMakeHost();

		switch (currentState) {
		case USER:
			return false;
		case ENLIST:
			return true;
		case HOST:
			return false;
		default:
			throw new IllegalAccessException("Unknown Level:" + currentState);
		}
	}

	@Override
	public void makeHost(UserVO user) throws SQLException {
		// transaction테스트 코드 : TRANSACTION_TEST==true면
		if ("PCWK04".equals(user.getUserId()) && TRANSACTION_TEST == true) {
			throw new TestUserServiceException("트랜잭션 테스트:" + user.getUserId());
		}

		user.makeHost();
		userDao.doUpdate(user);
		sendUpgradeMail(user);

	}

	/**
	 * 등업 사용자에게 mail전송.
	 * 
	 * @param user
	 */
	private void sendUpgradeMail(UserVO user) {
//		PasswordAuthentication													
//		Authenticator													
//		Session: Authenticator+PasswordAuthentication													
//		JavaMailSenderImpl		
		SimpleMailMessage simpleMessage = new SimpleMailMessage();
		simpleMessage.setTo(user.geteMail());
		simpleMessage.setFrom("rainbow160@naver.com");
		simpleMessage.setSubject("등업안내");
		simpleMessage.setText("사용자의 등급이 " + user);

		mailSender.send(simpleMessage);

	}

	@Override
	public UserVO doSelectOne(UserVO inVO) throws SQLException {
		return userDao.doSelectOne(inVO);
	}

	@Override
	public int doDelete(UserVO inVO) throws SQLException {
		return userDao.doDelete(inVO);
	}

	@Override
	public int doUpdate(UserVO inVO) throws SQLException {
		return userDao.doUpdate(inVO);
	}

	@Override
	public List<UserVO> doRetrieve(SearchVO inVO) throws SQLException {
		return userDao.doRetrieve(inVO);
	}

}