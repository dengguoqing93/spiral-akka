package org.spiral.myakka.message;

import java.io.Serializable;

/**
 * 如果key存在，返回value
 *
 * @author spiral
 * @date 2020/6/1
 * @copyright spiral
 * @since 1.0 Version
 */
public class GetRequest implements Serializable {
    private final String key;

    public GetRequest(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
