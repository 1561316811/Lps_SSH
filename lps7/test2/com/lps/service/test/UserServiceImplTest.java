package com.lps.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

import java.sql.Date;
import java.sql.Timestamp;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lps.model.Admin;
import com.lps.model.User;
import com.lps.service.impl.UserServiceImpl;

public class UserServiceImplTest {
	
	static ClassPathXmlApplicationContext ctx ;
	static UserServiceImpl as ;
	
	
	@AfterClass
	public static void after(){
		ctx.destroy();
	}
	
	@BeforeClass
	public static void before(){
		ctx = new ClassPathXmlApplicationContext(new String[]{
				"classpath:config/applicationContext.xml",
		});
		as = ctx.getBean("userServiceImpl", UserServiceImpl.class);
	}


	@Test
	public void testDelele() {
		as.delete(as.findById(1));
	}

	@Test
	public void testFindAll() {
		as.findAll();
	}

	@Test
	public void testFindAllCount() {
		assertEquals(2, as.findAllCount());
	}

	@Test
	public void testFindByAddress() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByAnswer() {
		assertEquals("ÄãÊÇË­", as.findByAnswer("cyl").get(0).getQuestion());
	}

	@Test
	public void testFindByAvatar() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByEmail() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByIdInt() {
//		System.out.println(as.findById(3));
		assertNotEquals(null, as.findById(1));
	}

	@Test
	public void testFindByIdInteger() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByPassword() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByProperty() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByQuestion() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByTelephonePhone() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByWorkId() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsExists() {
		User u = new User();
		u.setId(1);
		assertNotEquals(false, as.isExists(u));
		u.setId(3);
		assertNotEquals(true, as.isExists(u));
//		fail("Not yet implemented");
	}

	@Test
	public void testSave() {
		for(int i = 0; i < 23; i ++){
			as.save(new User("0002" + i, "0002", "ÄãÊÇË­", "cyl", new Timestamp(System.currentTimeMillis())));
		}
//		User u = new User("0002", "0002", "ÄãÊÇË­", "cyl", new Timestamp(System.currentTimeMillis()));
//		as.save(u);
	}
	
	@Test
	public void testFindPageByLimit() {
		assertEquals(24, as.findByPage(1).getAllCount());
		assertEquals(10, as.findByPage(1).getList().size());
		assertEquals("0002", as.findByPage(1).getList().get(0).getUserName());
	}

}
