package com.bw.dao;

import java.util.List;

import com.bw.entity.Order;

public interface OrderDao {
	/**
	 * 获取订单列表
	 * @return
	 */
	List<Order> getOrderList();
}
