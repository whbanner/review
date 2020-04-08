import org.junit.Test;

public class TestString {
    /**
     * 1.String b="abc";
     * String c=new String("abc");
     * JVM在编译期间就会把字面量和符号引用 放到常量池中
     * 对应字符串 在编译是将abc放入产量池中，下一次遇到相同的字符串直接将引用指向他
     * 而new的对象是在堆中的 他不会去检测堆中有没有
     *
     * 2.字符串拼接时就相当于申请了个新的
     */
    @Test
    public void test1(){
        final char[] c1;
        c1= new char[20];
        c1[0]='a';
        c1[0]='b';
        System.out.println(c1[0]);
        String a="abc";
        String b="abc";
        a.intern();
        String c=new String("abc");
        String d=new String("abc");
        StringBuilder stringBuilder=new StringBuilder("abc");
        StringBuffer stringBuffer=new StringBuffer("abc");
//        StringBuilder stringBuilder2="abc"; 这样赋值编译就不通过
//        StringBuffer stringBuffer="abc";    这样赋值编译就不通过

//
//        System.out.println(a==b);
//        System.out.println(c.equals(d));
        String str1="ab";
        String str2="cd";
        String str3="abcd";
        String str4=str1+str2;
        String str5=new String("abcd");
        System.out.println(str4==str5);
        System.out.println(str1==str4);
        System.out.println(str4==str3);
    }
}
/**
 * ==
 * equals
 * 区别： 1.如果该类没有重写Object的equals方法 \
 * 则调用obj的方法 equals 就是== (比实际内存地址，是否相同)
 * @see java.lang.Object#equals(java.lang.Object)
 *
 *String 重写了equals的方法
 * @see java.lang.String#equals(java.lang.Object)
 * 先调用== 如果相等：直接返回true
 * 不等 ：一个一个比每个char是否相等
 */
