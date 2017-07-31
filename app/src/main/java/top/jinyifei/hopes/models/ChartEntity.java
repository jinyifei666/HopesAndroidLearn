package top.jinyifei.hopes.models;

/**
 * author: jinyifei
 * time:  Created on 2017/7/28 18:47
 * email：jyf@whu.edu.cn
 * function：
 */
public class ChartEntity {
    private String xLabel;
    private Float yValue;

    public ChartEntity(String xLabel, Float yValue) {
        this.xLabel = xLabel;
        this.yValue = yValue;
    }

    public String getxLabel() {
        return xLabel;
    }

    public void setxLabel(String xLabel) {
        this.xLabel = xLabel;
    }

    public ChartEntity(Float yValue) {
        this.yValue = yValue;
    }

    public Float getyValue() {
        return yValue;
    }

    public void setyValue(Float yValue) {
        this.yValue = yValue;
    }
}
