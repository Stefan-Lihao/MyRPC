package com.lh.rpc.communication;

import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 */


public interface RequestHandler {

    /**
     * 处理请求
     * @param in 输入请求
     * @param out 输出结果
     */
    void handler(InputStream in, OutputStream out);

}
