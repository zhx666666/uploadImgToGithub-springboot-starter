package top.abilities.config;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import top.abilities.util.UploadGitHubImgBed;

import javax.annotation.PostConstruct;

/**
 * Author: zhaohaoxin
 * Date: 2022-06-29-20:04
 */
@Configuration
@Slf4j
public class GitHubInitConfig {
    @Autowired
    private GithubImgConfig githubConfig;
    @SneakyThrows
    @PostConstruct
    public void init() {
        try {
            initGithubImages();
        } catch (Exception e) {
            throw new Throwable(e.getMessage());
        }
    }
    private void initGithubImages() throws Exception {
        if (githubConfig == null) {
            log.error("github-springboot-starter:github config is null");
            throw new Exception("github-springboot-starter:github config is null");
        }
        if (githubConfig.getAccessToken() == null) {
            log.error("github-springboot-starter:github:accessToken is null");
            throw new Exception("github-springboot-starter: github:accessToken is null");
        }
        if (githubConfig.getUrlCdn() == null) {
            log.error("github-springboot-starter:github:urlCdn is null");
            throw new Exception("github-springboot-starter: github:urlCdn is null");
        }
        if (githubConfig.getApi() == null) {
            log.error("github-springboot-starter:github:api is null");
            throw new Exception("github-springboot-starter: github:api is null");
        }
        if (githubConfig.getUrlCdn() == null) {
            log.error("github-springboot-starter:github:urlCdn is null");
            throw new Exception("github-springboot-starter: github:urlCdn is null");
        }
        if (githubConfig.getRepository() == null) {
            log.error("github-springboot-starter:github:repository is null");
            throw new Exception("github-springboot-starter: github:repository is null");
        }
        UploadGitHubImgBed.uploadGithubApi = githubConfig.getApi();
    }

    public static void main(String[] args) {
        System.exit(1);
        while (true) {
            System.out.println("aa");
        }
    }
}
