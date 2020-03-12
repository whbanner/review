package com.wh.dataStruct1.linkedlist;


import java.util.LinkedList;

/**
 * @Author hui wang
 * @since 2020 3.11
 * 单链表实现
 **/
public class SimpleList {
    private Node head;
    private int len=0;
    /**
     * 增
     * @param name
     * @return
     */
    public int add(String name){
        Node node = new Node(name);
        if (head==null){
            head=node;
        }else {
            Node temp=head;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=node;
        }
        return 1;
    }

    /**
     *
     * @param index
     * @return
     */
    public int delete(int index){
            checklenth(index);
            if (index==0){
                head=head.next;
                return 1;
            }
            Node prev=null;
            Node rear=head;
            while (index>0){
                index--;
                //得到index节点前一节点
                prev=rear;
                rear=rear.next;
            }
            if (rear.next!=null){
                //得到index节点后一节点
                rear=rear.next;
                //index节点前面指针指向后面节点
                prev.next=rear;
            }else {
                //如果index节点 是最后节点
                prev.next=null;
            }

        return 1;
    }

    public int update(int index,String name){
            checklenth(index);
            Node temp=head;
            while (index>0){
                index--;
                temp=temp.next;
            }
            temp.name=name;

        return 1;
    }

    public Node get(int index){
        checklenth(index);
        Node temp=head;
        while (index>0){
            temp=temp.next;
            index--;
        }
        return temp;
    }
    /**
     * 得到链表长度
     * @return
     * @throws Exception
     */
    public int length()  {
        if (head!=null){
            len=1;
            Node temp=head;
            while (temp.next!=null){
                temp=temp.next;
                len++;
            }
            return len;
        }else {
            throw new IndexOutOfBoundsException("index of list");
        }
    }

    public void checklenth(int index){
        int len=length();
        if (index<0|index>len-1){
            try {
                throw new Exception("index of");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String tolist(){
        int len=length();
        String str="";
        Node temp=head;
        if (len>=1){
            str=temp.name;
        }
        while (temp.next!=null){
            temp = temp.next;
            str=str+" "+temp.name;
        }
        return str;
    }

    public static void main(String[] args) {
        SimpleList list = new SimpleList();
        list.add("x1");
        list.add("x2");
        list.add("x3");
        LinkedList<Integer> list1 =new LinkedList<>();
        list1.size();
        list1.add(1);
        list1.add(128);
        list1.get(1);
        list1.size();
        Integer i = 128;
        Integer ii=128;
        Integer a1=123;
        Integer aa=123;
        System.out.println(i==ii);
        System.out.println(a1==aa);

//        System.out.println(list.get(1).name);
////        list.get(1);
//        System.out.println(list.length());
//        System.out.println(list.tolist());
    }
}

