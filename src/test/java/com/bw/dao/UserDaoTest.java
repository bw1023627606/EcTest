package com.bw.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.bw.entity.Order;
import com.bw.entity.QueryVo;
import com.bw.entity.User;

public class UserDaoTest {

	@Test
	public void testGetUserById() {
		// 读取全局文件
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream("userMap.xml");
			// 创建SqlSessionFactory对象
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			// 创建SqlSession对象
			SqlSession sqlSession = sqlSessionFactory.openSession();
			// 使用sqlSession对象创建UserDao的对象
			UserDao userDao = sqlSession.getMapper(UserDao.class);
			// 调用方法查询
			User user = userDao.getUserById(1);
			System.out.println(user);
			// 关闭sqlSession
			sqlSession.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
		}
	}
	
	@Test
	public void testGetUserByName() {
		// 读取全局文件
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream("userMap.xml");
			// 创建SqlSessionFactory对象
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			// 创建SqlSession对象
			SqlSession sqlSession = sqlSessionFactory.openSession();
			// 使用sqlSession对象创建UserDao的对象
			UserDao userDao = sqlSession.getMapper(UserDao.class);
			// 调用方法查询
			List<User> list = userDao.getUserByName("张");
			for (User user : list) {
				System.out.println(user);
			}
			// 关闭sqlSession
			sqlSession.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
		}
	}
	
	

	@Test
	public void testInsertUser() {
		// 读取全局文件
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream("userMap.xml");
			// 创建SqlSessionFactory对象
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			// 创建SqlSession对象
			SqlSession sqlSession = sqlSessionFactory.openSession();
			// 使用sqlSession对象创建UserDao的对象
			UserDao userDao = sqlSession.getMapper(UserDao.class);
			// 创建增加的对象
			User user = new User();
			user.setAddress("安德门");
			user.setBirthday(new Date());
			user.setSex("女");
			user.setUsername("潘银莲");
			// 调用方法查询
			userDao.insertUser(user);
			System.out.println(user);
			sqlSession.commit();
			// 关闭sqlSession
			sqlSession.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
		}

	}

	@Test
	public void testdeleteUser() {
		// 读取全局文件
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream("userMap.xml");
			// 创建SqlSessionFactory对象
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			// 创建SqlSession对象
			SqlSession sqlSession = sqlSessionFactory.openSession();
			// 使用sqlSession对象创建UserDao的对象
			UserDao userDao = sqlSession.getMapper(UserDao.class);
			
			// 调用方法查询
			userDao.deleteUser(29);
			sqlSession.commit();
			// 关闭sqlSession
			sqlSession.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
		}

	}
	
	
	@Test
	public void testUpdateUser() {
		// 读取全局文件
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream("userMap.xml");
			// 创建SqlSessionFactory对象
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			// 创建SqlSession对象
			SqlSession sqlSession = sqlSessionFactory.openSession();
			// 使用sqlSession对象创建UserDao的对象
			UserDao userDao = sqlSession.getMapper(UserDao.class);
			// 创建增加的对象
			User user = new User();
			user.setId(28);
			user.setAddress("安德门");
			user.setUsername("大银莲");
			// 调用方法查询
			userDao.updateUser(user);
			sqlSession.commit();
			// 关闭sqlSession
			sqlSession.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
		}
	}
	
	/* ========================================= */
	
	@Test
	public void testGetUserByQueryVo() {
		// 读取全局文件
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream("userMap.xml");
			// 创建SqlSessionFactory对象
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			// 创建SqlSession对象
			SqlSession sqlSession = sqlSessionFactory.openSession();
			// 使用sqlSession对象创建UserDao的对象
			UserDao userDao = sqlSession.getMapper(UserDao.class);
			//queryVo对象
			QueryVo qv = new QueryVo();
			User user1 = new User();
			user1.setUsername("张");
			qv.setUser(user1);
			// 调用方法查询
			List<User> list = userDao.getUserByQueryVo(qv);
			for (User user : list) {
				System.out.println(user);
			}
			// 关闭sqlSession
			sqlSession.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
		}
	}
	@Test
	public void testGetUserByIdFor() {
		// 读取全局文件
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream("userMap.xml");
			// 创建SqlSessionFactory对象
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			// 创建SqlSession对象
			SqlSession sqlSession = sqlSessionFactory.openSession();
			// 使用sqlSession对象创建UserDao的对象
			UserDao userDao = sqlSession.getMapper(UserDao.class);
			//queryVo对象
			QueryVo qv = new QueryVo();
			qv.setUids(Arrays.asList(1,20,25,26,29,30));
			// 调用方法查询
			List<User> list = userDao.getUserByIdFor(qv);
			for (User user : list) {
				System.out.println(user);
			}
			// 关闭sqlSession
			sqlSession.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
		}
	}
	@Test
	public void testGetUserCountByQueryVo() {
		// 读取全局文件
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream("userMap.xml");
			// 创建SqlSessionFactory对象
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			// 创建SqlSession对象
			SqlSession sqlSession = sqlSessionFactory.openSession();
			// 使用sqlSession对象创建UserDao的对象
			UserDao userDao = sqlSession.getMapper(UserDao.class);
			//queryVo对象
			QueryVo qv = new QueryVo();
			User user1 = new User();
			user1.setUsername("张");
			qv.setUser(user1);
			// 调用方法查询
			Integer count = userDao.getUserCount();
				System.out.println(count);
			// 关闭sqlSession
			sqlSession.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
		}
	}
	
	@Test
	public void testGetUserOrder() {
		// 读取全局文件
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream("userMap.xml");
			// 创建SqlSessionFactory对象
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			// 创建SqlSession对象
			SqlSession sqlSession = sqlSessionFactory.openSession();
			// 使用sqlSession对象创建UserDao的对象
			UserDao userDao = sqlSession.getMapper(UserDao.class);
			// 调用方法查询
			User user = userDao.getUserOrder(25);
			System.out.println(user);
			for (Order order : user.getOrders()) {
				System.out.println(order);
			}
			// 关闭sqlSession
			sqlSession.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
		}
	}
	
	
	@Test
	public void testGetUserOrderAll() {
		// 读取全局文件
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream("userMap.xml");
			// 创建SqlSessionFactory对象
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			// 创建SqlSession对象
			SqlSession sqlSession = sqlSessionFactory.openSession();
			// 使用sqlSession对象创建UserDao的对象
			UserDao userDao = sqlSession.getMapper(UserDao.class);
			// 调用方法查询
			List<User> users = userDao.getUserOrderAll();
			for (User user : users) {
				System.out.println(user);
				for (Order order : user.getOrders()) {
					System.out.println("        "+order);
				}
			}
			
			// 关闭sqlSession
			sqlSession.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
		}

	}
	
	
	
}
