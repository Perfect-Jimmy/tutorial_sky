package com.tutoeial.excel.test;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.google.common.collect.Lists;
import com.tutorial.excel.listener.ExcelDataListener;
import com.tutorial.excel.listener.ExcelUserListener;
import com.tutorial.pojo.ExcelPo;
import com.tutorial.pojo.ExcelUserPo;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://github.com/alibaba/easyexcel
 * https://segmentfault.com/a/1190000020759658?utm_source=tag-newest
 * @author jimmy
 * @date 2020/4/2 17:50
 */
public class ExcelTest {

    private static final String fileName = "/Users/zhoucheng/Downloads/背调导入测试数据.xlsx";
    private static final String fileWriteName = "/Users/zhoucheng/Downloads/excelTest.xlsx";
    /**
     * 简单读取
     */
    @Test
    public void simpleRead() {
        // 写法1：
       // String fileName = "/Users/zhoucheng/Downloads/背调导入测试数据.xlsx";
        // 这里 需要指定读用哪个class去读，默认读取第一个sheet 文件流会自动关闭
        EasyExcel.read(fileName, ExcelPo.class, new ExcelDataListener()).sheet().doRead();

        // 写法2：
        //fileName = "demo.xlsx";
        ExcelReader excelReader = EasyExcel.read(fileName, ExcelPo.class, new ExcelDataListener()).build();
        ReadSheet readSheet = EasyExcel.readSheet(0).build();
       // excelReader.read(readSheet);
        // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
        //excelReader.finish();
    }

    /**
     * 读取全部sheet
     * 读取指定sheet
     */
    @Test
    public void simpleReadAll() {
        EasyExcel.read(fileName, ExcelPo.class, new ExcelDataListener()).doReadAll();
        //sheet从0开始
        EasyExcel.read(fileName, ExcelPo.class, new ExcelDataListener()).sheet().doRead();
    }

    /**
     * 读取部分sheet
     */
    @Test
    public void readSomeSheet(){
        ExcelReader excelReader = EasyExcel.read(fileName).build();
        // 这里为了简单 所以注册了 同样的head 和Listener 自己使用功能必须不同的Listener
        // readSheet参数设置读取sheet的序号
        ReadSheet readSheet1 =
                EasyExcel.readSheet(0).head(ExcelPo.class).registerReadListener(new ExcelDataListener()).build();
        ReadSheet readSheet2 =
                EasyExcel.readSheet(2).head(ExcelUserPo.class).registerReadListener(new ExcelUserListener()).build();
        // 这里注意 一定要把sheet1 sheet2 一起传进去，不然有个问题就是03版的excel 会读取多次，浪费性能
        excelReader.read(readSheet1, readSheet2);
        // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
        excelReader.finish();
    }

    /**
     * 读取表头数据
     */
    @Test
    public void readHead(){
        EasyExcel.read(fileName, ExcelPo.class, new ExcelDataListener()).sheet().doRead();
    }

   //----------------------------------
    static List<ExcelPo> list = Lists.newArrayList();
    static {
        list.add(new ExcelPo("jack","123"));
        list.add(new ExcelPo("jack2","1233"));
        list.add(new ExcelPo("jack3","1234"));
        list.add(new ExcelPo("jack4","1234"));
    }
    /**
     * 简单写入
     */
    @Test
    public void simpleWrite(){
        // 写法1
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(fileWriteName, ExcelPo.class).sheet("写入方法一").doWrite(list);

        // 写法2，方法二需要手动关闭流
        // 这里 需要指定写用哪个class去写
      //  ExcelWriter excelWriter = EasyExcel.write(fileName, DemoData.class).build();
       // WriteSheet writeSheet = EasyExcel.writerSheet("写入方法二").build();
       // excelWriter.write(data(), writeSheet);
        /// 千万别忘记finish 会帮忙关闭流
       // excelWriter.finish();
    }

    /**
     * 导出指定列
     */
    @Test
    public void simpleWrite1(){
        Set<String> excludeColumnFiledNames = new HashSet<String>();
        excludeColumnFiledNames.add("userName");
       // EasyExcel.write(fileWriteName, ExcelPo.class).excludeColumnFiledNames(excludeColumnFiledNames).sheet("剔除列").doWrite(list);

        Set<String> includeColumnFiledNames = new HashSet<String>();
        includeColumnFiledNames.add("userName");
      //  EasyExcel.write(fileWriteName, ExcelPo.class).includeColumnFiledNames(includeColumnFiledNames).sheet("指定列").doWrite(list);

    }

}
