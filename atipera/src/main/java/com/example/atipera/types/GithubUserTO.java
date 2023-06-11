package com.example.atipera.types;

import com.example.atipera.types.GithubRepositoryOwnerTO;
import com.fasterxml.jackson.annotation.JsonProperty;

public record GithubUserTO(@JsonProperty("name")
                             String name,
                           @JsonProperty("fork")
                             boolean fork,
                           @JsonProperty("owner")
                             GithubRepositoryOwnerTO githubRepositoryOwnerTO) {
}
