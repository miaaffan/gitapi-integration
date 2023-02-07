package com.git.intergration.api;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.git.intergration.constants.GitIntegrationConstants;
import com.git.intergration.model.RepoResponse;
import com.git.intergration.model.UsersDto;

import reactor.core.publisher.Mono;

@Service
public class GitApiService {

	private final WebClient webClient;

	@Value("${git.user.url}")
	private String userUrl;

	@Value("${git.repos.url}")
	private String reposUrl;

	public GitApiService(WebClient.Builder webClientBuilder) {
		this.webClient = webClientBuilder.baseUrl("https://api.github.com")
				.defaultHeader(HttpHeaders.USER_AGENT, "WebClient")
				.defaultHeader(HttpHeaders.CONTENT_TYPE, "application/json").build();
	}

	public UsersDto callUsersApi(String userName) {
		return webClient.get().uri(userUrl, userName).retrieve()
				.onStatus(HttpStatus::is4xxClientError, error -> Mono.error(new RuntimeException("API not found")))
				.onStatus(HttpStatus::is5xxServerError,
						error -> Mono.error(new RuntimeException("Server is not responding")))
				.bodyToMono(UsersDto.class).block();
	}

	@SuppressWarnings("unchecked")
	public List<RepoResponse> callReposApi(String userName) {
		List<LinkedHashMap<String, String>> repos = webClient.get().uri(reposUrl, userName).retrieve()
				.onStatus(HttpStatus::is4xxClientError, error -> Mono.error(new RuntimeException("API not found")))
				.onStatus(HttpStatus::is5xxServerError,
						error -> Mono.error(new RuntimeException("Server is not responding")))
				.bodyToMono(List.class).block();

		List<RepoResponse> repoResList = new ArrayList<RepoResponse>();
		for (LinkedHashMap<String, String> repo : repos) {
			RepoResponse rep = new RepoResponse();
			rep.setName(repo.get(GitIntegrationConstants.NAME));
			rep.setUrl(repo.get(GitIntegrationConstants.HTML_URL));
			repoResList.add(rep);
		}
		return repoResList;
	}

}