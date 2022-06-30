package top.abilities.util;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: zhaohaoxin
 * Date: 2022-06-28-17:45
 */
public class UploadGitHubImgBed {
    public static String uploadGithubApi;
    public static String createUploadFileUrl(String o){
        return uploadGithubApi+o;
    }

    public static Map<String, Object> getUploadBodyMap(byte[] bytes) {
        Map map = new HashMap();
        map.put("message","file upload");
        map.put("branch","master");
        map.put("content", Base64.getEncoder().encodeToString(bytes));
        return map;
    }

}
