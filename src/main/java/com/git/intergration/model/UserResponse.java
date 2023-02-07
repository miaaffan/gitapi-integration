package com.git.intergration.model;

import java.util.List;

public class UserResponse {

	private String user_name;

	private String display_name;

	private String avatar;

	private String geo_location;

	private String email;

	private String url;

	private String created_at;

	private List<RepoResponse> repos;

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getDisplay_name() {
		return display_name;
	}

	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getGeo_location() {
		return geo_location;
	}

	public void setGeo_location(String geo_location) {
		this.geo_location = geo_location;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public List<RepoResponse> getRepos() {
		return repos;
	}

	public void setRepos(List<RepoResponse> repos) {
		this.repos = repos;
	}

}
