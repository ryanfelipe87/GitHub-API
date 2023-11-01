package com.selectbr.github.controllers;

import com.selectbr.github.dtos.GithubDTO;
import com.selectbr.github.service.GithubService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/github")
@Tag(name = "Github API")
public class GithubController {

    private GithubService githubService;

    public GithubController(GithubService githubService) {
        this.githubService = githubService;
    }

    @GetMapping("{username}")
    @Operation(summary = "Realiza busca dos repositórios pelo username")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso."),
            @ApiResponse(responseCode = "400", description = "Retorna quando houver uma validação pré-definida."),
            @ApiResponse(responseCode = "404", description = "Retorna quando o recurso não for encontrado."),
            @ApiResponse(responseCode = "500", description = "Retorna quando houver um erro não identificado.")
    })
    public ResponseEntity<List<GithubDTO>> getRepositoriesByUser(@PathVariable String username){
        return ResponseEntity.ok(githubService.getRepositoriesByUser(username));
    }
}
