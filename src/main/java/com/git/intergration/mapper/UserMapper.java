package com.git.intergration.mapper;

import java.util.List;

import com.git.intergration.model.RepoResponse;
import com.git.intergration.model.UserResponse;
import com.git.intergration.model.UsersDto;
import com.git.intergration.utils.Utils;

public class UserMapper {
	
	public static UserResponse mapToResponse(UsersDto user, List<RepoResponse> reposResponse) {
		UserResponse userResponse = new UserResponse();
		userResponse.setUser_name(user.getLogin());
		userResponse.setDisplay_name(user.getName());
		userResponse.setAvatar(user.getAvatar_url());
		userResponse.setGeo_location(user.getLocation());
		userResponse.setEmail(user.getEmail());
		userResponse.setUrl(user.getUrl());
		userResponse.setCreated_at(Utils.convertToNewFormat(user.getCreated_at().toString()));
		userResponse.setRepos(reposResponse);
		return userResponse;
	}
	

}
