package org.spiral.myakka.message;

import java.io.Serializable;

/**
 * 消息体
 *
 * @author spiral
 * @date 2020/6/1
 * @copyright spiral
 * @since 1.0 Version
 */
public class SetRequest implements Serializable {
    private final String key;
    private final Object value;


    public SetRequest(String key, Object value) {
        this.key = key;
        this.value = value;
    }


    public String getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }
}
