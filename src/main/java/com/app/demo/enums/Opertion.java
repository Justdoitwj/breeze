package com.app.demo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @ProjectName: breeze
 * @PackageName: com.app.demo.enums
 * @ClassName: Opertion
 * @Description:
 * @author: wangjie
 * @date: 2020/1/5  16:12
 * @Copyright: 趣医网络技术服务有限公司 版权所有 Copyright (c) 2020
 */
@Getter
@AllArgsConstructor
public enum Opertion {

    PLUS("+") {
        @Override
        double apply(double x, double y) {
            return x + y;
        }
    },
    MIN("-") {
        @Override
        double apply(double x, double y) {
            return x - y;
        }
    },
    TIMES("*") {
        @Override
        double apply(double x, double y) {
            return x * y;
        }
    },
    DIVIDE("/") {
        @Override
        double apply(double x, double y) {
            return x / y;
        }
    };

    private final String symbol;

    @Override
    public java.lang.String toString() {
        return symbol;
    }

    abstract double apply(double x, double y);
}
