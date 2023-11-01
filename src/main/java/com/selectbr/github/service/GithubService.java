package com.selectbr.github.service;

import com.selectbr.github.config.GithubApiConfig;
import com.selectbr.github.dtos.GithubDTO;
import com.selectbr.github.exceptions.BadRequestException;
import com.selectbr.github.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class GithubService {

    @Autowired
    private GithubApiConfig githubApiConfig;

    @Autowired
    private RestTemplate restTemplate;

    public List<GithubDTO> getRepositoriesByUser(String username) {
        try {
            final String apiUrl = githubApiConfig.getGithubApiRepositoryUrl() + username + "/repos";

            if(username.equals(null) || username.isEmpty()){
                throw new BadRequestException("Username inválido.");
            }

            ResponseEntity<List<GithubDTO>> response = restTemplate.exchange(
                    apiUrl,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<GithubDTO>>() {});

            List<GithubDTO> githubDTOList = response.getBody();

            if(githubDTOList.isEmpty()){
                throw new NotFoundException(" O usuário é inexistente ou não possui repositórios públicos.");
            }
            return response.getBody();
        }catch (HttpClientErrorException.NotFound exception){
            throw new NotFoundException("O usuário é inexistente ou não possui repositórios públicos.");
        }catch (Exception exception){
            exception.printStackTrace();
            throw exception;
        }
    }
}
