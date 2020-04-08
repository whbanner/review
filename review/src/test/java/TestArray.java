import org.junit.Test;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *1. this就是调用者
 */
public class TestArray {
    @Test
    public void test1(){
        ArrayList<String> arrayList=new ArrayList();
        arrayList.add("x1");
        arrayList.add("x2");
        arrayList.add("x3");
        arrayList.add(1,"yy");

//        arrayList.add(arrayList);
//        sb.append(e == this ? "(this Collection)" : e)
//                  e就是遍历的元素 如果把 arraylist相等于 e=arraylist this就是调用者 也就是为arraylist 所以等号成立
        arrayList.toString();

        Iterator<String> itr =  arrayList.iterator();
        while (itr.hasNext()){
            String str=itr.next();
            if (str.equals("x2")){
                itr.remove();
            }

        }


        for (int i = 0; i <arrayList.size() ; i++) {
            System.out.println(arrayList.get(i));
        }

    }

    /**
     * arraylist 和linkedlist谁删除的快
     */
    @Test
    public void test2(){
        ArrayList arrayList = new ArrayList();
        LinkedList linkedList = new LinkedList();
        List list=new Vector();
        List list1=Collections.synchronizedList(arrayList);
        CopyOnWriteArrayList list2 = new CopyOnWriteArrayList();
        long start1 = System.currentTimeMillis();
        for (int i = 0; i <50000 ; i++) {
            arrayList.add(i);
        }
        System.out.println(System.currentTimeMillis()-start1);


        long start2 = System.currentTimeMillis();
        for (int i = 0; i <50000 ; i++) {
            linkedList.add(i);
        }
        System.out.println(System.currentTimeMillis()-start2);
    }

    /**
     * Linkedlist
     */
    @Test
    public void test3(){
        List<String> list=new LinkedList();
        list.add("xx");
        list.add("yy");
        list.add("zz");
        Iterator<String> iterator=list.iterator();
        while (iterator.hasNext()){
            String str =iterator.next();
            System.out.println(str);
            if(str.equals("yy"))
                list.remove("yy");

        }
        System.out.println(list);
        List list1=new LinkedList(list);
    }
}
