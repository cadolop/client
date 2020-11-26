package com.domain.bot.api;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.domain.bot.dto.RequestDto;
import com.domain.bot.service.ConsumeService;

@RestController
public class ConsumeController {

	private final ConsumeService consumeService;
	
	@Autowired
	public ConsumeController(ConsumeService consumeService) {
		this.consumeService = consumeService;
	}

	@RequestMapping(value = "/execute", method = RequestMethod.POST)
	public List<String> executeBot(@RequestBody RequestDto request) {
		return consumeService.executeBot(Arrays.asList(request.getServers().split(",")), Arrays.asList(request.getStores().split(",")));
	}

}
