package com.dataos.client.biz;

import com.dataos.client.check.CheckResult;
import com.dataos.client.remote.ResultRemoteClient;
import com.dataos.client.vo.CheckCalculResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * RuleResultBiz
 *
 * @author libing
 * @date 2020/4/6
 **/
@Service
public class RuleResultBiz {

    @Autowired
    private CheckResult checkResult;
    @Autowired
    private ResultRemoteClient resultRemoteClient;

    public int ruleResultExcute(String file, String checkDate){
        List<CheckCalculResultVO> list = checkResult.readCheckResult(file);
        return resultRemoteClient.sendRuleResult(list, checkDate);
    }

}
