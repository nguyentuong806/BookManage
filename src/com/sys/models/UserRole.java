package com.sys.models;

public class UserRole {
	private static final long UIDSerialVersion = 1L;
	private int userId;
	private int roleId;
	
	public UserRole() {
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "UserRole [userId=" + userId + ", roleId=" + roleId + "]";
	}
	
}
