package top.abilities.enuma;

/**
 * Author: zhaohaoxin
 * Date: 2022-06-28-15:43
 */
public enum ErrorEnum {
    IMAGE_NOT_FOUND(1001,"文件不能为空!"),
    IMAGE_TO_GITHUB(1002,"文件上传github失败!");
    private Integer code;
    private String errorMessage;

    ErrorEnum(Integer code, String errorMessage) {
        this.code = code;
        this.errorMessage = errorMessage;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
