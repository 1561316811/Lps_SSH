package com.lps.service.test;

import static org.junit.Assert.assertEquals;

import org.hibernate.Session;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lps.dao.AdminDAO;
import com.lps.dao.impl.AdminDAOImpl;
import com.lps.model.Admin;
import com.lps.service.impl.AdminServiceImpl;

public class AdminServiceImplTest {
	
	static ClassPathXmlApplicationContext ctx ;
	static AdminServiceImpl as ;
	
	
	@BeforeClass
	public static void before(){
		ctx = new ClassPathXmlApplicationContext(new String[]{
				"classpath:config/applicationContext.xml",
		});
		as = ctx.getBean("adminServiceImpl", AdminServiceImpl.class);
	}
	
	@AfterClass
	public static void after(){
		ctx.destroy();
	}

	public static void main(String[] args) {
		new AdminServiceImplTest().testAdd();
	}
	
	@Test
	public void testAdd() {
		for(int i = 0; i < 23; i ++){
			as.save(new Admin("小芳" + i ,"0002", new java.sql.Timestamp(System.currentTimeMillis())));
		}
	}
	
	@Test
	public void testSession(){
		AdminDAOImpl adi = (AdminDAOImpl)as.getAdminDao();
		assertEquals(AdminDAOImpl.class, as.getAdminDao().getClass());
		Session session = adi.getHibernateTemplate().getSessionFactory().getCurrentSession();
		//System.out.println(session);
		//System.out.println(session.createQuery("from Admin").list().size());	
//		as.save(new Admin("小键","0002", new java.sql.Timestamp(System.currentTimeMillis())));
	}
	
	@Test
	public void testFindPageByLimit() {
		assertEquals(24, as.findByPage(1).getAllCount());
		assertEquals(10, as.findByPage(1).getList().size());
		assertEquals("小海2", as.findByPage(1).getList().get(0).getUserName());
	}
	
	@Test
	public void testGetById(){
		Admin admin = as.findById(1);
		System.out.println(admin.getRegisterTime());
		System.out.println(new java.sql.Timestamp(System.currentTimeMillis()));
//		Assert.assertEquals("小芳", admin.getUserName());
	}
	
	@Test
	public void testGetByName(){
		Admin admin = as.getByUserName("小明");
		Assert.assertEquals(new Integer(4), admin.getId());
	}
	
	@Test
	public void testDel(){
		Admin admin = new Admin();
		 admin = as.findById(3);
		as.delete(admin);
	}
	
	@Test
	public void testExists(){
		Admin admin = new Admin();
		admin.setId(1);
		Assert.assertEquals(false, as.isExists(admin));;
	}
	
	@Test
	public void testFindByProperty(){
		Assert.assertEquals("小芳", as.findByProperty(AdminDAOImpl.USER_NAME, "小芳0").get(0).getUserName());
	}
	
	@Test
	public void testFindAll(){
		Assert.assertNotEquals(0, as.findAll());
	}
	
	@Test
	public void testFindAllCount(){
		Assert.assertEquals(as.findAll().size(), as.findAllCount());
	}
}
