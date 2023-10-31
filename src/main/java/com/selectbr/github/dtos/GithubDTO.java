package com.selectbr.github.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public record GithubDTO(
        String name,
        String description,
        @JsonProperty("html_url") String htmlUrl,
        @JsonProperty("created_at") LocalDateTime createdAt
) {
}
