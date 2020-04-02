package com.tutorial.excel.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.tutorial.pojo.ExcelUserPo;

import java.util.List;

/**
 * @author jimmy
 * @date 2020/4/2 17:44
 */
public class ExcelUserListener extends AnalysisEventListener<ExcelUserPo> {
    List<ExcelUserPo> list = Lists.newArrayList();

    /**
     * 如果使用了spring,请使用这个构造方法。每次创建Listener的时候需要把spring管理的类传进来
     */
    public ExcelUserListener() {}

    /**
     * 这个每一条数据解析都会来调用
     * @param excelPo
     * @param analysisContext
     */
    @Override
    public void invoke(ExcelUserPo excelPo, AnalysisContext analysisContext) {
        System.out.println("解析到一条数据:"+JSON.toJSONString(excelPo));
        list.add(excelPo);
    }

    /**
     * 所有数据解析完成了 才会来调用
     * @param analysisContext
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        System.out.println(JSON.toJSONString(list.size()));
    }
}
