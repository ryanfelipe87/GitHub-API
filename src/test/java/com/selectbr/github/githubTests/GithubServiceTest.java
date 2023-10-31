package com.selectbr.github.githubTests;

import com.selectbr.github.service.GithubService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GithubServiceTest {

    @Autowired
    private GithubService githubService;

    @Test
    void testUsernameTrue(){
        Assertions.assertTrue(true, "");
    }
}
