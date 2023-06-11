package com.example.atipera.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record GithubRepositoryAndOwnerTO(@NotBlank
                                  @NotNull
                                  @JsonProperty("repository_name")
                                  String RepositoryName,

                                  @NotBlank
                                  @NotNull
                                  @JsonProperty("owner_login")
                                  String OwnerLogin) {
}
