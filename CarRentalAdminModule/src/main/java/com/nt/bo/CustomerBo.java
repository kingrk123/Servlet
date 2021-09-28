package com.nt.bo;

import lombok.Data;

@Data
public class CustomerBo {
	private int permission;
	private int cid;
	public int getPermission() {
		return permission;
	}
	public void setPermission(int permission) {
		this.permission = permission;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	
	
	
}
