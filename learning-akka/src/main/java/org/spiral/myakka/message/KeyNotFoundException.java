package org.spiral.myakka.message;

import java.io.Serializable;

/**
 * 如果key不存在，返回该异常
 *
 * @author spiral
 * @date 2020/6/1
 * @copyright spiral
 * @since 1.0 Version
 */
public class KeyNotFoundException extends Exception implements Serializable {
    private final String key;

    public KeyNotFoundException(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
