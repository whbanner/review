package com.wh.myenum;

import org.junit.Test;

public class TestSeasonEnum {
    @Test
    public void test1(){
       SeasonEnum spring=SeasonEnum.SPRING;
        System.out.println(spring);
        System.out.println(spring.getSeason()+"==="+spring.getDescribe());

    }
    @Test
    public void test2(){
        SeasonEnum autumn=SeasonEnum.AUTUMN;
        judge(autumn); //没加break， winter也出来了 哈哈。
    }

    public void judge(SeasonEnum seasonEnum){
        switch (seasonEnum){
            case SPRING:
                System.out.println("spring is coming");
                break;
            case SUMMER:
                System.out.println("summer is coming");
                break;
            case AUTUMN:
                System.out.println("autumn is coming");
                break;
            case WINTER:
                System.out.println("winter is coming");
                break;
        }
    }
}
