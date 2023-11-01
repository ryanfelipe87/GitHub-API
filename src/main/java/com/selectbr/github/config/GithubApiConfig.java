package com.selectbr.github.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GithubApiConfig {

    @Value("${github.api.repository.url}")
    private String githubApiRepositoryUrl;

    public String getGithubApiRepositoryUrl(){
        return githubApiRepositoryUrl;
    }
}
