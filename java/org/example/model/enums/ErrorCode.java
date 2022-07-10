package org.example.model.enums;

public enum ErrorCode {

    REQUEST_INVALID("9000", "參數異常")

    ;

    private String code;
    private String msg;

    ErrorCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
