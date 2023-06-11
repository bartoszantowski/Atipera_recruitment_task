package com.example.atipera.service;

import com.example.atipera.types.GithubUserTO;

import java.util.List;

/**
 * API interface for performing operations on github users
 */
public interface GithubUserService {

    /**
     * Get all repositories (which are not forks) from the given user's Github account
     *
     * @param userName
     * @param acceptHeader
     * @return list of repositories
     */
    List<GithubUserTO> getAllRepositoriesByUserName(String userName, String acceptHeader);
}
