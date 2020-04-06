package com.dataos.client.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * CheckCalculResultVO
 *
 * @author libing
 * @date 2020/3/29
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CheckCalculResultVO implements Serializable {
    /** 实体id，例如公司部门等 **/
    private String companyId;
    /** 项目id **/
    private String proId;
    /** 校验id，tabale表中rid **/
    private String ruleId;
    /** 规则id **/
    private String checkId;
    /** 计算id **/
    private String calculId;
    /** 字段名称 **/
    private String columnName;
    /** 字段编码 **/
    private String columnCode;
    /** 计算结果-字符 **/
    private String resultCalculStr;
    /** 计算结果-数值 **/
    private Double resultCalculNum;
    /** 校验中异常值示例 **/
    private String resultExample;
    /** 检验的业务时间 **/
    private String bizzDate;
    /** 记录时间 **/
    private Date createDate;
    /** 耗时（毫秒） **/
    private Integer usetime;
    /** 校验结果，1，通过；0，未通过 **/
    private Integer resultCheck;
    /** 批次id，后后台随机生成 **/
    private String batchId;

}
