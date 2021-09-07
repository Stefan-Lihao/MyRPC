package com.lh.rpc.communication;

/**
 *
 */


public interface TransportServer {

    /**
     * 初始化，设置servlet
     *
     * @param port 端口
     * @param handler 处理请求的方法
     */
    void init(int port, RequestHandler handler);

    /**
     * 建立服务通信
     */
    void start();

    /**
     * 停止通信服务
     */
    void stop();
}
