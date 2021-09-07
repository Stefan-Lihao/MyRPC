package com.lh.rpc.codec;
/**
 *
 */


public interface Decoder {

    /**
     * make binary array return to object
     * @param bytes wait to return
     * @param clazz init class
     * @param <T> leixing
     * @return T
     */
    <T> T decode(byte[] bytes,Class<T> clazz);

}
