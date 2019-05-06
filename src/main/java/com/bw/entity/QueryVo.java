package com.bw.entity;

import java.util.List;

/**
 * 包装的pojo
 * @author bw
 *
 */
public class QueryVo {
	
	private User user;
	private List<Integer> uids;
	
	public List<Integer> getUids() {
		return uids;
	}

	public void setUids(List<Integer> uids) {
		this.uids = uids;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
