package top.abilities.util;

/**
 * Author: zhaohaoxin
 * Date: 2022-06-28-16:26
 */
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;

import java.util.Map;

public class MyHttpUtils {

    public static String put(String urlString, Map<String, Object> paramMap, Map<String,String> headers) throws UnirestException {
        JSONObject jsonObject = new JSONObject(paramMap);
        HttpResponse<String> response = Unirest.put(urlString).headers(headers)
                .body(jsonObject).asString();
        return response.getBody();
    }

}

