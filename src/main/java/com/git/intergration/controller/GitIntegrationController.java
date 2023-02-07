package com.git.intergration.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.git.intergration.model.UserResponse;
import com.git.intergration.service.IntegrationServiceImpl;

@RestController
@RequestMapping("/users")
public class GitIntegrationController {
	@Autowired
	private IntegrationServiceImpl integrationService;

	@GetMapping("/{userName}")
	@ResponseBody
	public Optional<UserResponse> getUserDetails(@PathVariable String userName)
			throws UnsupportedEncodingException, IOException {
		return integrationService.getUserDetails(userName);
	}

}