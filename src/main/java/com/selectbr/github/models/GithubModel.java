package com.selectbr.github.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GithubModel {
    private String name;
    private String fullName;
    private String description;
}
