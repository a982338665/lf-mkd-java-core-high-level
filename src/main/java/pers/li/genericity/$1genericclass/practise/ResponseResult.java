package pers.li.genericity.$1genericclass.practise;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 通用数据响应
 */
public class ResponseResult<T> {

    private T data;

    private String msg;

    private int code;

    public ResponseResult(T data, String msg, int code) {
        this.data = data;
        this.msg = msg;
        this.code = code;
    }

    public ResponseResult(T data) {
        this.code = 200;
        this.data = data;
    }
    public ResponseResult() {
        this.code = 200;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static void main(String[] args) throws JsonProcessingException {
        ResponseResult<String> stringResponseResult = new ResponseResult<>();
        System.err.println(new ObjectMapper().writeValueAsString(stringResponseResult));
    }
}
