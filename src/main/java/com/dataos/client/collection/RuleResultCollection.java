package com.dataos.client.collection;

import com.dataos.client.biz.RuleResultBiz;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * RuleResultCollection
 *
 * @author libing
 * @date 2020/3/29
 **/
@Slf4j
@RestController
public class RuleResultCollection {

    @Autowired
    RuleResultBiz ruleResultBiz;

    @GetMapping("/ruleResult/excute")
    public int ruleResultExcute(@RequestParam String file,@RequestParam String checkDate) {
        log.debug("file={} checkDate={}",file, checkDate);
        try{
            return ruleResultBiz.ruleResultExcute(file, checkDate);
        }catch (Exception e) {
            e.printStackTrace();
            log.error("ruleResultExcute ----->>>>> {}",e.getMessage());
            return -1;
        }
    }

}
