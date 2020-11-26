package com.domain.bot.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.domain.bot.service.ConsumeService;

@Service
public class ConsumeServiceImpl implements ConsumeService {

	@Override
	public List<String> executeBot(List<String> servers, List<String> stores) {
		List<String> resp = new ArrayList<String>();
		for (String store : stores) {
			String resultFirstServer = null;
			for (String server : servers) {
				RestTemplate restTemplate = new RestTemplate();
				HttpHeaders headers = new HttpHeaders();
				headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
				HttpEntity<String> entity = new HttpEntity<String>(headers);
				String result = restTemplate.exchange("http://" + server + ":8080/" + store, HttpMethod.GET, entity, String.class).getBody();
				if (resultFirstServer != null) resultFirstServer = result;
				else if (!result.equals(resultFirstServer)) {
					resp.add("Store: " + store + " is different with " + server);
					break;
				}
			}
		}
		return resp;
	}

}
