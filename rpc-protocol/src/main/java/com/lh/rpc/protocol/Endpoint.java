package com.lh.rpc.protocol;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *端点描述
 */

@Data
@AllArgsConstructor
public class Endpoint {

    //主机域名
    private String host;
    //主机端口
    private Integer port;
}