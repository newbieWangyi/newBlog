package com.wy.newblog.entity.enums;

public enum Status {
    DELETED(-1, "已删除"),
    UNKNOWN(0, "未知"),
    NORMAL(1, "正常(有效)"),
    INVALID(2, "无效"),
    ;
    private final int code;
    private final String text;

    private Status(int code, String text) {
        this.code = code;
        this.text = text;
    }

    public int code() {
        return code;
    }

    public String text() {
        return text;
    }

    public static Status nameOf(String name) {
        try {
            return Status.valueOf(name);
        } catch(Exception e) {
        }

        return null;
    }

    public static Status codeOf(int code) {
        if (code < 0) {
            return Status.DELETED;
        }

        for (Status value : values()) {
            if (value.code == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid code: " + code);
    }
}