package com.wh.copy;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.RandomAccess;

public class TestCopy {

    /**
     *   "浅拷贝"
     * 鲁智深====20====倒拔垂杨柳
     * 鲁智深====20====倒拔垂杨柳
     * 鲁智深====20====不拔了
     * 鲁智深====20====不拔了
     *
     *  "深拷贝"
     *   让skiill也继承cloneable
     *   改写person的clone方法
     */
    @Test
    public void test1() throws CloneNotSupportedException {
        Skill skill = new Skill("倒拔垂杨柳");

        Person p1=new Person("鲁智深",20,skill);
        Person p2= (Person) p1.clone();
        System.out.println(p1);
        System.out.println(p2);
        skill.setName("不拔了");
        System.out.println(p1);
        System.out.println(p2);

    }

    @Test
    public void test2() throws CloneNotSupportedException {

        /**
         * 发现即使两个引用类都星了clone 但是变为数组，不可以直接简单用数组.clone ()
         */
        Skill skill = new Skill("倒拔垂杨柳");
        Skill skill1 = new Skill("豹子头");
        Person p1=new Person("鲁智深",20,skill);
        Person p11=new Person("林冲",22,skill1);
        Person pl[] = {p1,p11};
        Person pl1[]=pl.clone();
//        Person pl1[]={(Person) p1.clone(), (Person) p11.clone()};
        System.out.println(pl[0]);
        System.out.println(pl1[0]);
        skill.setName("不拔了");
        System.out.println(pl[0]);
        System.out.println(pl1[0]);

    }
    /**
     * 发现改了其中的skill  两个arraylist都会变，所有得出是浅拷贝
     */
    @Test
    public void test3(){
        ArrayList<Skill> arrayList = new ArrayList<>();
        arrayList.add(new Skill("豹子头"));
        arrayList.add(new Skill("浪里白条"));

        ArrayList<Skill> arrayList1 = (ArrayList<Skill>) arrayList.clone();
        selectRandom(arrayList);
        selectRandom(arrayList1);
        arrayList1.get(0).setName("禁军教头");
        selectRandom(arrayList);
        selectRandom(arrayList1);

    }

    /**
     *以序列化的方式实现深拷贝
     *
     */
    @Test
    public void test4() throws IOException, ClassNotFoundException {

        ArrayList<Skill> arrayList = new ArrayList<>();
        arrayList.add(new Skill("豹子头"));
        arrayList.add(new Skill("浪里白条"));
        selectRandom(arrayList);
        System.out.println();
        FileOutputStream fos=null;
        ObjectOutputStream oos=null;
        try {
            fos = new FileOutputStream("/home/wh/worksapce/review1/review/src/main/java/com/wh/copy/test4.obj");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(arrayList);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            fos.close();
            oos.close();
        }

        FileInputStream fis =null;
        ObjectInputStream ois = null;

        fis=new FileInputStream("/home/wh/worksapce/review1/review/src/main/java/com/wh/copy/test4.obj");
        ois=new ObjectInputStream(fis);
        ArrayList<Skill> arrayList1= (ArrayList<Skill>) ois.readObject();
        arrayList1.get(0).setName("不教了");
        selectRandom(arrayList);
        selectRandom(arrayList1);
        fis.close();
        ois.close();
    }

    public void selectRandom(ArrayList<Skill> arrayList){
        //熟悉一下，在这里硬编码，都知道是arraylist，肯定随机访问了。
        if(arrayList instanceof RandomAccess){
            //顺序访问
            for (Skill s:arrayList) {
                System.out.println(s);
            }
        }else {
            //随机访问
            for (int i = 0; i <arrayList.size() ; i++) {
                System.out.println(arrayList.get(i));
            }
        }
    }
}
