package com.bumble.utils;

public enum Environment {
    SERVER_URL("serverURL"),
    CONFIG_PATH("config_path"),
    DEVICE("device");
 
    private final String key;

    Environment(String key) {
        this.key = key;
    }

    public String getKey() {
        return this.key;
    }
}
