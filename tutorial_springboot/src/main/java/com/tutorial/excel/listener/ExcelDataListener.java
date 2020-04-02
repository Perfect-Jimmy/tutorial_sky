package com.tutorial.excel.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.exception.ExcelDataConvertException;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.tutorial.pojo.ExcelPo;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

/**
 * @author jimmy
 * @date 2020/4/2 17:44
 */
@Slf4j
public class ExcelDataListener extends AnalysisEventListener<ExcelPo> {
    List<ExcelPo> list = Lists.newArrayList();

    /**
     * 如果使用了spring,请使用这个构造方法。每次创建Listener的时候需要把spring管理的类传进来
     */
    public ExcelDataListener() {}

    /**
     * 这个每一条数据解析都会来调用
     * @param excelPo
     * @param analysisContext
     */
    @Override
    public void invoke(ExcelPo excelPo, AnalysisContext analysisContext) {
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

    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        System.out.println("解析到一条头数据:{}"+JSON.toJSONString(headMap));
    }

    @Override
    public void onException(Exception exception, AnalysisContext context) {
        // LOGGER.error("解析失败，但是继续解析下一行:{}", exception.getMessage());
        // 如果是某一个单元格的转换异常 能获取到具体行号
        // 如果要获取头的信息 配合invokeHeadMap使用
        if (exception instanceof ExcelDataConvertException) {
            ExcelDataConvertException excelDataConvertException = (ExcelDataConvertException)exception;
            log.info("第{}行，第{}列解析异常", excelDataConvertException.getRowIndex(),
                    excelDataConvertException.getColumnIndex());
        }
    }
}
