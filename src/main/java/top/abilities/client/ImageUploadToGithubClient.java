package top.abilities.client;

/**
 * Author: zhaohaoxin
 * Date: 2022-06-28-15:39
 */

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import top.abilities.config.GithubImgConfig;
import top.abilities.enuma.ErrorEnum;
import top.abilities.exception.ErrorException;
import top.abilities.util.MyHttpUtils;
import top.abilities.util.UploadGitHubImgBed;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class ImageUploadToGithubClient {
    @Autowired
    private GithubImgConfig config;

    public String uploadImg(MultipartFile multipartFile) throws Exception {
        String originalFilename = multipartFile.getOriginalFilename();
        String newFilename = System.currentTimeMillis()+originalFilename.substring(originalFilename.lastIndexOf("."));
        if(originalFilename == null){
            throw new ErrorException(ErrorEnum.IMAGE_NOT_FOUND);
        }
        String targetURL = UploadGitHubImgBed.createUploadFileUrl(newFilename);
        log.info("目标url："+targetURL);
        //请求体封装
        Map<String, Object> uploadBodyMap = UploadGitHubImgBed.getUploadBodyMap(multipartFile.getBytes());
        Map<String, String> header = new HashMap<>();
        // Github生成的token 参考GitHub API https://docs.github.com/cn/rest/reference/repos#create-or-update-file-contents
        header.put("Authorization", "token "+config.getAccessToken());
        header.put("Accept", "application/vnd.github.v3+json");
        header.put("Content-Type", "application/json");
        //发送Put请求，这里只能用PUT请求
        String jsonStr = MyHttpUtils.put(targetURL, uploadBodyMap, header);

        //解析响应JSON字符串
        //System.out.println(JSONResult);
        JSONObject jsonObj = JSONUtil.parseObj(jsonStr);
        //请求失败
        if(jsonObj == null || jsonObj.getObj("commit") == null){
            throw new ErrorException(ErrorEnum.IMAGE_TO_GITHUB);
        }
        JSONObject content = JSONUtil.parseObj(jsonObj.getObj("content"));
        String downloadUrl = (String)content.getObj("download_url");
        log.info("上传到GitHub图床的地址："+downloadUrl);
        //请求成功：返回下载地址
        return config.getIsCdnDownload()?config.getUrlCdn()+newFilename:downloadUrl;
    }
}


