package com.sys.models;

public class Role {
	private static final long UIDSerialVersion = 1L;
	private String authority;
	
	public Role() {
		
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public String toString() {
		return "Role [authority=" + authority + "]";
	}
	
	

}
