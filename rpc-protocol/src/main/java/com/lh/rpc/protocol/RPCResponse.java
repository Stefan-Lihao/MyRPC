package com.lh.rpc.protocol;

/**
 * rpc响应
 */

public class RPCResponse {

    //服务的返回编码，成功返回1，失败返回0
    private int code = 0;

    private String message = "ok";  //返回信息
    private Object data;            //返回数据

}