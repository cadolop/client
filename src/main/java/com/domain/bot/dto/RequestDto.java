package com.domain.bot.dto;

import java.io.Serializable;

public class RequestDto implements Serializable {

	private static final long serialVersionUID = -2536594499368710966L;
	
	private String servers;
	private String stores;

	public String getServers() {
		return servers;
	}
	public void setServers(String servers) {
		this.servers = servers;
	}
	public String getStores() {
		return stores;
	}
	public void setStores(String stores) {
		this.stores = stores;
	}

}
