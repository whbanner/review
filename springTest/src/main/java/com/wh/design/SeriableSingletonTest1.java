package com.wh.design;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SeriableSingletonTest1{

    public static void main(String[] args) {
        SeriableSingletonTest s1 = null;
        SeriableSingletonTest s2 = SeriableSingletonTest.getInstance();

        FileOutputStream fos = null;

        try {
            fos=new FileOutputStream("SeriableSingletonTest.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(s2);
            oos.flush();
            oos.close();

            FileInputStream fis = new FileInputStream("SeriableSingletonTest.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            s1 = (SeriableSingletonTest) ois.readObject();
            ois.close();


            System.out.println(s1);
            System.out.println(s2);
            System.out.println(s1==s2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}