package com.dataos.client.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * RuleResultVO
 *
 * @author libing
 * @date 2020/3/29
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RuleResultVO implements Serializable {
    String checkDate;
    List<CheckCalculResultVO> resultList;

}
