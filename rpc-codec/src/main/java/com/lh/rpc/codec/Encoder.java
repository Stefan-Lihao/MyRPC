package com.lh.rpc.codec;

/**
 *
 */

public interface Encoder {

    /**
     * encode covert class to binary array
     * @param obj object
     * @return
     */
    byte[] encode(Object obj);

}