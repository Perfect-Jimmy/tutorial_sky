package com.tutorial.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author jimmy
 * @date 2020/4/2 17:33
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ExcelPo {
    /**
     * value: 表头名称
     * index: 列的号, 0表示第一列
     */
    @ExcelProperty(value = "人员姓名", index = 0)
    private String userName;

    @ExcelProperty(value = "身份证件号码", index = 1)
    private String cardId;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    @Override
    public String toString() {
        return "ExcelPo{" +
                "userName='" + userName + '\'' +
                ", cardId='" + cardId + '\'' +
                '}';
    }
}
