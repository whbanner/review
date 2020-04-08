import org.junit.Test;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class TestHashMap {
    @Test
    public void test1(){
        HashMap map = new HashMap();
        ConcurrentHashMap map1=new ConcurrentHashMap();
        map.put("1","2");
        "110".hashCode(); //48656
        System.out.println((Integer.toBinaryString(48656)));
        System.out.println((Integer.toBinaryString(49)));
        "1".hashCode(); //49
//        System.out.println(Integer.toBinaryString());
        char[] value={1,1,0};
//        System.out.println(value.toString());
        int i=1;
        i<<=1;
        System.out.println(i+"==========");
    }
}
