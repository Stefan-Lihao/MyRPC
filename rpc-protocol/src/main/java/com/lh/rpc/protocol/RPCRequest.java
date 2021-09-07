package com.lh.rpc.protocol;

import lombok.Data;

/**
 * rpc请求
 */

@Data
public class RPCRequest {

    private ServiceDescriptor serviceDescriptor;
    private Object[] paramter;

}