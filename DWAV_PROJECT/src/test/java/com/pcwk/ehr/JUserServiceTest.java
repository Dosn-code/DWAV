package com.pcwk.ehr;

import static org.junit.Assert.*;

import java.lang.reflect.Proxy;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.PlatformTransactionManager;

import com.pcwk.ehr.member.dao.UserDao;
import com.pcwk.ehr.member.domain.Level;
import com.pcwk.ehr.member.domain.MakeHost;
import com.pcwk.ehr.member.domain.UserVO;
import com.pcwk.ehr.member.service.UserService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)//JUnit기능 스프링 프레임으로 확장
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
                                   "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class JUserServiceTest {
    final Logger LOG = LogManager.getLogger(getClass());
    
    @Autowired
    ApplicationContext context;
    
    @Autowired
    UserService userService;
    
    @Autowired
    UserDao    userDao;
    
    @Autowired
    DataSource dataSource;
    
    @Autowired
    PlatformTransactionManager transactionManager;
    
    
    List<UserVO>   list;
    
	@Before
	public void setUp() throws Exception {
		LOG.debug("===============");
		LOG.debug("setUp()");
		LOG.debug("context:"+context);
		LOG.debug("userService:"+userService);
		LOG.debug("userDao:"+userDao);
		LOG.debug("===============");
		//public UserVO(String uId, String name, String passwd, Level level, int login, int recommend, String email) {
		list = Arrays.asList(
				   new UserVO("physicskdh01","rlaehgud","Kim1","DoHyung1","1994/01/06","physicskdhm","010-9146-9869","asdasd","asdasd","sysdate",0,0,MakeHost.ENLIST,2) //BASIC(1)
				  ,new UserVO("physicskdh01","rlaehgud","Kim1","DoHyung1","1994/01/06","physicskdhm","010-9146-9869","asdasd","asdasd","sysdate",0,0,MakeHost.USER,1)
				  ,new UserVO("physicskdh02","rlaehgud","Kim2","DoHyung2","1994/01/07","physicskdhm","010-9146-9869","asdasd","asdasd","sysdate",0,0,MakeHost.HOST,3)
				  ,new UserVO("physicskdh03","rlaehgud","Kim3","DoHyung3","1994/01/08","physicskdhm","010-9146-9869","asdasd","asdasd","sysdate",0,0,MakeHost.USER,1)
				);
		
		
		assertNotNull(userDao);
		assertNotNull(userService);
		assertNotNull(context);
	}
	
	


	
	
	@Test
	@Ignore
	public void add() throws SQLException{
		//1. 전체 데이터 삭제
		//2. Level있는 데이터, Level이 Null데이터를 만들어
		//3. add
		//4. 데이터 조회
		//5. Level있는 데이터는 동일한 Level, Level이 Null인 경우는 basic
		
		//1. 
		userDao.deleteAll();
		
		//2.
		UserVO userHostState = list.get(4);//GOLD
		UserVO userWithOutLevel = list.get(0);//BASIC
		//userWithOutLevel.setLevel(null);//BASIC -> NULL
		
		//3.
		//userService.add(userWithLevel);
		assertEquals(1, userDao.getCount());
		
		userService.add(userWithOutLevel);
		assertEquals(2, userDao.getCount());
		
		//4.
//		UserVO  userWithLevelRead =userDao.doSelectOne(userWithLevel);
//		UserVO  userWithOutLevelRead =userDao.doSelectOne(userWithOutLevel);
//		
//		assertEquals(userWithLevelRead.getLevel(), userWithLevel.getLevel());
//		assertEquals(userWithOutLevelRead.getLevel(),Level.BASIC);
	}
	
	@Test
	//@Ignore
	public void makeHosts() throws Exception {
		LOG.debug("===============");
		LOG.debug("makeHosts()");
		LOG.debug("===============");	
		
		//1. 전체 데이터 삭제
		//2. list데이터 입력
		//3. 등업
		//4. 등업데이터 비교
		
		//1. 
		userDao.deleteAll();
		
		//2.
		for(UserVO vo  :list) {
			userDao.doInsert(vo);
		}
		
		assertEquals(5, userDao.getCount());
		try {
			//3.
			userService.makeHosts();
		}catch(Exception e) {
			LOG.debug("===============");
			LOG.debug("Exception:"+e.getMessage());
			LOG.debug("===============");
		}
		
		//4.
		//checkLevel(list.get(0), false);
		checkState(list.get(1), false);//USER, 호스트 되기 불가
		//checkLevel(list.get(2), false);
		//checkLevel(list.get(3), true);//SILVER 등업
		//checkLevel(list.get(4), false);
		
	}
	
	
	
	
	private void checkState(UserVO user, boolean enlisted) throws SQLException {
		UserVO upUser = userDao.doSelectOne(user);
		//LOG.debug(upUser.getLevel()+"="+expectedLevel);
		if(enlisted==true) {
			LOG.debug(upUser.getMakeHost()+"="+user.getMakeHost().canHost());
			assertEquals(upUser.getMakeHost(), user.getMakeHost().canHost());
		}else {
			assertEquals(upUser.getMakeHost(), user.getMakeHost());
		}
	}
	
	
	@After
	public void tearDown() throws Exception {
		LOG.debug("===============");
		LOG.debug("tearDown()");
		LOG.debug("===============");		
	}



}
