package com.andre.furn.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Andre Wang
 * @version 1.0
 * Msg: 后端程序返回给前端的json数据的Msg对象=》本质就是数据规则
 */
public class Msg {

    //状态码 200-成功 400-失败
    private int code;
    //信息-说明
    private String msg;

    //返回给客户端/浏览器的数据-Map集合，not sure how much info, use Map to cover
    private Map<String, Object> extend =
            new HashMap<>();

    //编写几个常用的方法-封装好msg
    //返回success对应的msg
    public static Msg success() {
        Msg msg = new Msg();
        msg.setCode(200);
        msg.setMsg("success");
        return msg;
    }

    //返回fail对应的msg
    public static Msg fail() {
        Msg msg = new Msg();
        msg.setCode(400);
        msg.setMsg("fail");
        return msg;
    }

    //给返回的msg设置数据-不难应该可以看懂
    public Msg add(String key, Object value) {
        extend.put(key, value);
        return this;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }
}
