package com.example.atipera.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public record GithubRepositoryOwnerTO(@JsonProperty("login")
                                      String login ) {
}
