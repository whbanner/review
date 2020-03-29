package com.wh.dataStruct1.tree;

import org.junit.Test;

public class BinarySerachTreeSample {
    Node root;

    public int insert(int data) {
        Node node = new Node(data);
        if (root == null) {
            root = node;
        } else {
            Node temp =root;

            //判断有是否进右字树比较
            while (data >= temp.data) {
                //如果右节点还有 继续
                if (temp.right != null) {
                    //得到右节点
                    temp = temp.right;
                }else {
                    //如果右节点没有了 插入并返回
                    temp.right=node;
                    return 1;
                }
            }
            //比右节点小 进入左子树
//            while (data.)
            temp.left=node;

            return 1;
        }
        return 1;
    }
    @Test
    public void test(){
        Node node=new Node(1);
        root=node;
        Node temp=root;
        temp.data=111;
        System.out.println(root.data);
    }
}

