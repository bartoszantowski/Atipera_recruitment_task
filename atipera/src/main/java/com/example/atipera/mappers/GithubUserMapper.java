package com.example.atipera.mappers;

import com.example.atipera.types.GithubRepositoryAndOwnerTO;
import com.example.atipera.types.GithubUserTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GithubUserMapper {

    public GithubRepositoryAndOwnerTO toGithubRepositoryAndOwnerTO(GithubUserTO githubUserTO) {
        if (githubUserTO == null) {
            return null;
        }

        return GithubRepositoryAndOwnerTO.builder()
                .RepositoryName(githubUserTO.name())
                .OwnerLogin(githubUserTO.githubRepositoryOwnerTO().login())
                .build();
    }
}
