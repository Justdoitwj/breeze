package com.app.breeze.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @ProjectName: breeze
 * @PackageName: com.app.breeze.domain.dto
 * @ClassName: UserDTO
 * @Description:
 * @author: wangjie
 * @date: 2019/12/20  20:37
 * @Copyright: 趣医网络技术服务有限公司 版权所有 Copyright (c) 2019
 */
@Data
public class UserDTO {

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
    //注解@JsonFormat主要是后台到前台的时间格式的转换
    //  注解@DataFormAT主要是前后到后台的时间格式的转换
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date modifiedTime;
    private String hospitalCode;
    private String isValide;
    private Integer gender;
    private String doctorCode;

    private String yxUser;
    private String yxToken;
}
