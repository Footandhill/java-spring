package com.wms.untils;

import lombok.Data;

@Data
public class MyResult {

    private int code;       //编码 200/400
    private String msg;     //成功、失败
    private Long total;     //总记录数
    private Object data;    //数据

    public static MyResult fail(){
        return result(400,"失败",0L,"null");
    }
    public static MyResult suc(){
        return result(200,"成功",0L,"null");
    }
    public static MyResult suc(Object data){
        return result(200,"成功",0L,data);
    }
    public static MyResult suc(Object data,Long total){
        return result(200,"成功",total,"null");
    }

    private static MyResult result(int code,String msg,Long total,Object data){
        MyResult res = new MyResult();
        res.setCode(code);
        res.setMsg(msg);
        res.setTotal(total);
        res.setData(data);
        return res;
    }

}
