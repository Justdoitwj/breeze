package com.app.demo.enums;

import lombok.Getter;

/**
 * @ProjectName: breeze
 * @PackageName: com.app.demo.enums
 * @ClassName: PayrollDay
 * @Description:
 * @author: wangjie
 * @date: 2020/1/5  16:12
 * @Copyright: 趣医网络技术服务有限公司 版权所有 Copyright (c) 2020
 */
@Getter
public enum PayrollDay {
    MONDAY(PayType.WEEKDAY),
    TUESDAY(PayType.WEEKDAY),
    WEDNESDAY(PayType.WEEKDAY),
    THURSDAY(PayType.WEEKDAY),
    FRIDAY(PayType.WEEKDAY),
    SATURDAY(PayType.WEEKEND),
    SUNDAY(PayType.WEEKEND);

    private final PayType payType;

    PayrollDay(PayType payType) {
        this.payType = payType;
    }

    double pay(double hoursWorked, double payRate) {
        return payType.pay(hoursWorked, payRate);
    }

    /**
     * 策略枚举
     */
    private enum PayType {
        WEEKDAY {
            @Override
            double overtimePay(double hours, double payRate) {
                return hours<=HOURS_PRE_SHIFT?0:(HOURS_PRE_SHIFT-hours)*payRate/2;
            }
        },
        WEEKEND {
            @Override
            double overtimePay(double hours, double payRate) {
                return hours*payRate/2;
            }
        };
        /**
         * 每天正常工作时长
         */
        private static final int HOURS_PRE_SHIFT = 8;

        abstract double overtimePay(double hours, double payRate);

        /**
         * 实际支付工资（1.加班工资2.正常上班工资）
         *
         * @param hoursWorked
         * @param payRate
         * @return
         */
        double pay(double hoursWorked, double payRate) {
            double basePay = hoursWorked * payRate;
            return basePay + overtimePay(hoursWorked, payRate);
        }
    }

}
