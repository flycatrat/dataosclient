package com.dataos.client.check;

import com.dataos.client.vo.CheckCalculResultVO;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import com.google.common.collect.Lists;

/**  
 * Copyright © 砥特信息科技有限公司. All rights reserved.
 *
 * @Title: CheckResult.java
 * @Prject: dataos
 * @Package: com.dataos.dq.check
 * @Description: TODO
 * @author: yangguowen  
 * @date: Jul 7, 2019 10:36:06 AM
 * @version: V1.0  
 */
@Slf4j
@Service
public class CheckResult {
	private final static Logger logger = LoggerFactory.getLogger(CheckResult.class);
	
	/**
	 * 读取文件并组合为结果对象
	 * @param fileName 校验结果文件
	 * @return
	 */
    public  List<CheckCalculResultVO> readCheckResult(String fileName) {
        List<CheckCalculResultVO> list = Lists.newArrayList();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)))) {
            /** 读取字段列 **/
            String []colLine = reader.readLine().split("\t");
            /** 读取值 **/
            String []valueLine = reader.readLine().split("\t");
			Map<String, String> reMap = Maps.newHashMap();
            for (int i = 0; i < colLine.length; i++) {
				reMap.put(colLine[i], valueLine[i]);
			}
            this.getListResult(list, reMap);
        } catch (IOException e) {
            e.printStackTrace();
            logger.info(e.getMessage(),e);
        }
        return list;
    }
	
    /**
     * 根据map内容组合结果对象
     * @param list
     * @param recoder
     * @throws Exception
     */
    private void getListResult(List<CheckCalculResultVO> list, Map<String, String> recoder ) {
    	Iterator<Map.Entry<String, String>> entries = recoder.entrySet().iterator();
    	while (entries.hasNext()) {
    	    Map.Entry<String, String> entry = entries.next();
    	    log.info("Key = {}, Value = {}", entry.getKey(), entry.getValue());
    	    String col = entry.getKey();
    	    String value = entry.getValue();
			/** 获取字段本身带有的编码 **/
			String [] tmpCode = col.toLowerCase().split("_t1t_");

			CheckCalculResultVO calculResultDTO = CheckCalculResultVO.builder().companyId(tmpCode[1])
					.proId(tmpCode[2])
					.ruleId(tmpCode[3])
					.checkId(tmpCode[4])
					.calculId(tmpCode[5])
					.columnName(tmpCode[7])
					.columnCode(entry.getKey())
					.resultCalculStr(value)
					.createDate(new Date()).build();

    			list.add(calculResultDTO);
    	}
    }
}
