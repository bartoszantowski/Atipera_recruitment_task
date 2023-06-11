package com.example.atipera.controller;

import com.example.atipera.mappers.GithubUserMapper;
import com.example.atipera.service.impl.GithubUserServiceImpl;
import com.example.atipera.exception.api.NotAcceptableException;
import com.example.atipera.types.GithubRepositoryAndOwnerTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/githubUserRepos")
@RequiredArgsConstructor
class GithubUserController {

    private final GithubUserServiceImpl githubUserServiceImpl;
    private final GithubUserMapper githubUserMapper;

    @GetMapping("/{userName}")
    public List<GithubRepositoryAndOwnerTO> getAllRepositoriesByUserName(@PathVariable("userName") String userName,
                                                                         @RequestHeader("Accept") String acceptHeader) {

        if (acceptHeader.equals("application/xml"))
            throw new NotAcceptableException();

        return githubUserServiceImpl.getAllRepositoriesByUserName(userName, acceptHeader)
                .stream()
                .filter(githubUserTO -> !githubUserTO.fork())
                .map(githubUserMapper::toGithubRepositoryAndOwnerTO)
                .toList();
    }
}
