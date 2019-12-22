package com.app.breeze.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @ProjectName: breeze
 * @PackageName: com.app.breeze.domain.entity
 * @ClassName: ControlUser
 * @Description:
 * @author: wangjie
 * @date: 2019/12/20  20:37
 * @Copyright: 趣医网络技术服务有限公司 版权所有 Copyright (c) 2019
 */
@Data
//@AllArgsConstructor
//@NoArgsConstructor // 生成一个无参数的构造方法
@Alias("ControlUser")
public class ControlUser implements Serializable {
    private Integer id;
    private String name;
    private String account;
    private String passWord;
    private String userMark;
    private String phone;
    private Integer creator;
    //格式化时间格式数据信息
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    private Integer modifiedPerson;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date modifiedTime;
    private String hospitalCode;
    private String isValide;
    private Integer gender;
    private String doctorCode;

    private String yxUser;
    private String yxToken;
}
