package com.wh.dataStruct1.linkedlist;

import org.junit.Test;

/**
 * Autor hui wang
 * 2020-3-13
 */
public class DoubleList {
    Node head;
    int len=0;

    /**
     * 双向链表可向前向后实现插入
     * "p"向前，“r”相后
     * @param str
     * @param name
     */
    public int add(String str,String name){
        Node node= new Node(name);
        if (head==null){
            head=node;
            return 1;
        }

        if (str=="p"){
            node.rear=head;
            head.prev=node;
            head=node;
        }else if(str=="r"){
            Node temp = head;
            while (temp.rear!=null){
                temp=temp.rear;
            }
            temp.rear=node;
            node.prev=temp;
        }
        return 1;
    }

    /**
     * 删除节点
     * @param index
     * @return 被删除 返1;
     */
    public int delete(int index){
        checkIndex(index);
        if (index==0){
            if (head.rear!=null){
                head=head.rear;
                head.prev=null;
            }else {
                head=null;
            }
            return 1;
        }
        Node p1=null;
        Node p2=head;
        while (index>0){
            index--;
            //得到被删节点前一对象
           p1=p2;
           //得到被删节点
           p2=p2.rear;
        }
        if (p2.rear!=null){
            //得到被删节点后节点
            p2=p2.rear;
            p1.rear=p2;
            p2.prev=p1;

        }else {
            p1.rear=null;
        }
        return 1;
    }

    /**
     * 更改所需节点data
     * @param index
     * @param str
     * @return
     */
    public int update(int index,String str){
        Node temp= head;
        while(index>0){
            index--;
            //得到需要该的节点
            temp=temp.rear;
        }
        temp.name=str;
        return 1;
    }

    /**
     * 得到index节点
     * @param index
     * @return
     */
    public Node get(int index){
        Node temp=head;
        while (index>0){
            index--;
            //得到index节点
            temp=temp.rear;
        }
        return temp;
    }
    public String tolist(){
        Node temp=head;
        String str="";
        while (temp.rear!=null){
            str=str+"  "+temp.name;
           temp=temp.rear;
        }
        str=str+"  "+temp.name;
        return str;

    }
    public void checkIndex(int index){
        if (index<0|index>length()-1){
            throw new IndexOutOfBoundsException("链表越界");
        }
    }

    public int length(){
        if (head==null){
            return 0;
        }else {
            len=1;
            Node temp=head;
            while (temp.rear!=null){
                temp=temp.rear;
                len++;
            }

            return len;
        }
    }

   @Test
    public void fun1(){
        DoubleList list= new DoubleList();
        list.add("p","x0");
        list.add("p","x1");
        list.add("r","x2");
//       System.out.println(list.get(0).name);
       list.delete(0);
       list.delete(0);
       list.add("p","x1");
       list.add("p","x0");
       list.add("r","x3");
       System.out.println(list.tolist()+"=="+list.length());
   }

}
