package com.lh.rpc.codec;

import com.alibaba.fastjson.JSON;

/**
 *
 */

public class JSONEncoder implements Encoder {

    public byte[] encode(Object obj) {
        return JSON.toJSONBytes(obj);
    }
}