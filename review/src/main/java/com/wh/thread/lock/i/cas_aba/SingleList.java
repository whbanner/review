package com.wh.thread.lock.i.cas_aba;

import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;

public class SingleList<String> {
    AtomicInteger atomicInteger= new AtomicInteger(10);
    Node head=null;

    /**
     * 插入节点
     * @param value
     */
    public void insert(String value){
        Node newNode = new Node(value);
        if(head==null){
            head=newNode;
        }
        Node temp = head;
        while(temp.next!=null) {
            //遍历找到最后一个节点
            temp=temp.next;
        }
        temp.next=newNode;

    }

    /**
     * @param index
     * @return 想要的节点
     */
    public Node getNode(int index){
        Node temp = head;
        for (int i=0;i<index-1;i++){
            temp=temp.next;
        }
        return temp;
    }

    public boolean delete(int index){
        if(index <0){
            return false;
        }
        return false;
    }


/**
 * Node节点
 */
@Data
public class Node<String>{
    private String value;
    private Node next;
    public Node(String value){
        this.value=value;
        next=null;
    }
}
}
