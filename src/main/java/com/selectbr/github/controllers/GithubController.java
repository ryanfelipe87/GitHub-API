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
    @Operation(
            summary = "Busca de Repositórios por Username",
            description = "Endpoint para buscar os repositórios de um usuário do GitHub.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Requisição bem-sucedida. Retorna a lista de repositórios."),
            @ApiResponse(responseCode = "400", description = "Requisição inválida devido a validações pré-definidas."),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado para o username fornecido."),
            @ApiResponse(responseCode = "500", description = "Erro interno não identificado no servidor.")
    })
    public ResponseEntity<List<GithubDTO>> getRepositoriesByUser(@PathVariable String username) {
        return ResponseEntity.ok(githubService.getRepositoriesByUser(username));
    }
}
