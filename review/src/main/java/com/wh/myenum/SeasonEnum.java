package com.wh.myenum;

public enum SeasonEnum {

    SPRING("spring","春暖花开"),
    SUMMER("summer","酷日炎炎"),
    AUTUMN("autumn","秋高气爽"),
    WINTER("winter","白雪皑皑"); //最后一个要分号结尾，本质是调用下面的构造方法,枚举要写在开头

    private String season;
    private String describe;

    //枚举构造方法是私有的，别的地方new时可以看得出来
    SeasonEnum(String season, String describe) {
        this.season = season;
        this.describe = describe;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
