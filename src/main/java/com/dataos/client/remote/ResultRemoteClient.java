package com.dataos.client.remote;

import com.dataos.client.check.CheckResult;
import com.dataos.client.vo.CheckCalculResultVO;
import com.dataos.client.vo.RuleResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * SendResultClient
 *
 * @author libing
 * @date 2020/3/29
 **/
@Service
public class ResultRemoteClient {

    @Autowired
    RestTemplate restTemplate;

    @Value("${remote.dq.server.url}")
    String url;

    public int sendRuleResult(List<CheckCalculResultVO> list, String checkDate){
        RuleResultVO resultDTO = RuleResultVO.builder().checkDate(checkDate).resultList(list).build();
        ResponseEntity<Integer> integerResponseEntity = restTemplate.postForEntity(url,resultDTO, Integer.class);
        return integerResponseEntity.getBody();
    }

    public static void main(String[] args) {

        String file = "d://dwd_meta_lineage_data_grade_df2.txt";
        CheckResult checkResult = new CheckResult();
        List<CheckCalculResultVO> list = checkResult.readCheckResult(file);
        for(CheckCalculResultVO vo : list){
            System.out.println(vo);
        }

        String url = "http://127.0.0.1:8056/data_quality/excuteRuleResult";
        RestTemplate restTemplate = new RestTemplate();
        RuleResultVO resultDTO = RuleResultVO.builder().checkDate("2020-03-06").resultList(list).build();
        ResponseEntity<Integer> integerResponseEntity = restTemplate.postForEntity(url, resultDTO, Integer.class);
        System.out.println(integerResponseEntity);
    }

}
