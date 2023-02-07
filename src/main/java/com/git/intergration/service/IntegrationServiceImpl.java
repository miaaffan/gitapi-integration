package com.git.intergration.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.git.intergration.api.GitApiService;
import com.git.intergration.mapper.UserMapper;
import com.git.intergration.model.RepoResponse;
import com.git.intergration.model.UserResponse;
import com.git.intergration.model.UsersDto;

@Service
public class IntegrationServiceImpl {

	private static final Logger log = LoggerFactory.getLogger(IntegrationServiceImpl.class);

	@Autowired
	GitApiService gitApiService;

	@Cacheable("users")
	public Optional<UserResponse> getUserDetails(String userName) {
		log.info("Fetching user detais");
		UsersDto userResponse = gitApiService.callUsersApi(userName);
		List<RepoResponse> reposResponse = gitApiService.callReposApi(userName);
		return Optional.of(UserMapper.mapToResponse(userResponse, reposResponse));
	}

}