package com.bw.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.bw.entity.Order;

public class OrderDaoTest {
	
	
	
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
			// 使用sqlSession对象创建OrderDao的对象
			OrderDao orderDao = sqlSession.getMapper(OrderDao.class);
			// 调用方法查询
			List<Order> list = orderDao.getOrderList();
			for (Order order : list) {
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
	public void testGetOrderUser() {
		// 读取全局文件
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream("userMap.xml");
			// 创建SqlSessionFactory对象
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			// 创建SqlSession对象
			SqlSession sqlSession = sqlSessionFactory.openSession();
			// 使用sqlSession对象创建OrderDao的对象
			OrderDao orderDao = sqlSession.getMapper(OrderDao.class);
			// 调用方法查询
			Order order= orderDao.getOrderUser(3);
			System.out.println(order);
			System.out.println(order.getUser());
			// 关闭sqlSession
			sqlSession.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
		}
	}
	

}
