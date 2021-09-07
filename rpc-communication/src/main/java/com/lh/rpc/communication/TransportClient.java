package com.lh.rpc.communication;

import com.lh.rpc.protocol.Endpoint;
import java.io.InputStream;

/**
 *
 */

public interface TransportClient {

    /**
     * to connect endpoint
     * @param endpoint 端点
     */
    void connect(Endpoint endpoint);

    /**
     * WRITE DATA TO SERVER
     *
     * @param data   DATA
     * @param requestMethod TO judge whether it is get or put
     * @return  return data
     */
    InputStream write(InputStream data, RequestMethod requestMethod);

    /**
     * to close connect
     *
     */
    void close();

}