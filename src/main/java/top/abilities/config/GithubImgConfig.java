package top.abilities.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Author: zhaohaoxin
 * Date: 2022-06-28-18:13
 */
@Component
@Data
@ConfigurationProperties(prefix = "github")
public class GithubImgConfig {
    private String username;//github用户信息
    private String repository;//github仓库
    private String accessToken;//github生成的token;
    private String urlCdn;//下载地址-加速器
    private String api;//上传地址
    private Boolean isCdnDownload=true;//上传地址

}