package com.app.breeze.comm.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public enum StatusCode {
    SUCCESS("000000", "SUCCESS"),
    FAIL("999999", "FAIL");
    private String code;
    private String displayName;
    private static final BiMap<String, StatusCode> map = HashBiMap.create();
    private static final BiMap<StatusCode, String> inverseMap = map.inverse();

    private StatusCode(String code, String displayName) {
        this.code = code;
        this.displayName = displayName;
    }

    @JsonCreator
    public static StatusCode forValue(String code) {
        return (StatusCode)map.get(code);
    }

    @JsonValue
    public String toValue() {
        return this.code;
    }

    public String getCode() {
        return this.code;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    static {
        StatusCode[] var0 = values();
        int var1 = var0.length;

        for(int var2 = 0; var2 < var1; ++var2) {
            StatusCode statusCode = var0[var2];
            map.put(statusCode.code, statusCode);
        }

    }
}
