package com.example.atipera.service.impl;

import com.example.atipera.service.GithubUserService;
import com.example.atipera.exception.api.BusinessException;
import com.example.atipera.exception.api.UserNotFoundException;

import com.example.atipera.types.GithubUserTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class GithubUserServiceImpl implements GithubUserService {

    public static final String HTTPS_API_GITHUB_COM_USERS_S_REPOS = "https://api.github.com/users/%s/repos";
    private final RestTemplate restTemplate;

    @Override
    public List<GithubUserTO> getAllRepositoriesByUserName(String userName, String acceptHeader) {

        ResponseEntity<GithubUserTO[]> response = getResponseEntity(userName, acceptHeader);

        List<GithubUserTO> githubUserTOs = Arrays.asList(response.getBody());

        return githubUserTOs;
    }

    private ResponseEntity<GithubUserTO[]> getResponseEntity(String userName, String acceptHeader) {
        ResponseEntity<GithubUserTO[]> exchange;
        try {
            exchange = restTemplate.getForEntity(
                    String.format(HTTPS_API_GITHUB_COM_USERS_S_REPOS, userName),
                    GithubUserTO[].class
            );
        } catch (HttpClientErrorException e) {
            if (acceptHeader.equals("application/json") && e.getStatusCode().equals(HttpStatus.NOT_FOUND))
                throw new UserNotFoundException(userName);
            else
                throw new BusinessException();
        }

        return exchange;
    }
}
