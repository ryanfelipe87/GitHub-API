package com.selectbr.github.controllers;

import com.selectbr.github.dtos.GithubDTO;
import com.selectbr.github.service.GithubService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/github")
public class GithubController {

    private GithubService githubService;

    public GithubController(GithubService githubService) {
        this.githubService = githubService;
    }

    @GetMapping("{username}")
    public ResponseEntity<List<GithubDTO>> findUserRepository(@PathVariable String username){
        return ResponseEntity.ok(githubService.searchUserRepositories(username));
    }
}
