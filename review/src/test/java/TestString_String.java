import org.junit.Test;

import java.util.StringJoiner;

public class TestString_String {

    /**
     *    //用javap -c 命令发现了
     *         用两个变量,
     *         或者一个遍历+字符串
     *         进行拼接时
     *         底层就是调用StringBuilder 每次拼接底层会new个
     *         "ab" +"cd" 没有
     */
    @Test
    public void test1(){

        String str= "ab";
        String str2="cd";
        String str3="ab"+"cd";
        String str5="abcd";
        System.out.println(str3==str5);
        String str4=str+str2;
        System.out.println(str3==str4);
//        StringJoiner  底层也是stringbuilder

    }
    @Test
    public void test2(){

        String str1="ab";
        String str2="cd";
//        long start=System.currentTimeMillis();
//        for (int i = 0; i <50 ; i++) {
//            str1+=str1;  //ava.lang.OutOfMemoryError: Java heap space
//
//        }
//        long end1=System.currentTimeMillis();
//        System.out.println(end1-start+"\t毫秒");


        StringBuilder sb=new StringBuilder("ab");
        long start2=System.currentTimeMillis();
        for (int i = 0; i <5000 ; i++) {
            sb.append(str1);
        }
        long end2=System.currentTimeMillis();
        System.out.println(end2-start2+"\t毫秒");


    }
}
