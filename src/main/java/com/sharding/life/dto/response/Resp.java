package com.sharding.life.dto.response;

import lombok.Data;

/**
 * @author huapeng.huang
 * @version V1.0
 * @since 2021-08-13 22:55
 */
@Data
public class Resp {

    private Integer code;
    private String message;
    private Object value;

    public static Resp success(Object value) {
        Resp resp = new Resp();
        resp.setCode(1);
        resp.setMessage(null);
        resp.setValue(value);
        return resp;
    }

    public static Resp failure(String message) {
        Resp resp = new Resp();
        resp.setCode(0);
        resp.setMessage(message);
        resp.setValue(null);
        return resp;
    }
}
