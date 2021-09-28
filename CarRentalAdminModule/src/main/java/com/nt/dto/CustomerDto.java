package com.nt.dto;

import java.io.Serializable;

import lombok.Data;
@Data
public class CustomerDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	private int permission;
	private int cid;
}
