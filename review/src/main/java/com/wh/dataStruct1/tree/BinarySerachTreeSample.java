package com.wh.dataStruct1.tree;

import org.junit.Test;

public class BinarySerachTreeSample {
    Node root;

    public void insert(int data) {
        if (root == null) {
            root = new Node(data);
            return;
        }
        Node p = root;
        while (p != null) {
            if (data > p.data) { //大于进入右子树
                if (p.right == null) {
                    p.right = new Node(data);
                    return;
                }
                p = p.right;
            } else {  //小于等于进入左子树
                if (p.left == null) {
                    p.left = new Node(data);
                    return;
                }
                p = p.left;
            }
        }
    }

    public Node get(int data) {

        Node p = root;

        while (p != null) {
            if (data > p.data) {
                p = p.right;
            } else if (data < p.data) {
                p = p.left;
            } else {
                return p;
            }
        }
        return null;
    }
    public void delete(int data){
        Node pp=null;//记录p的父节点
        Node p=root;
        //先找到要删除节点
        while (p!=null && p.data!=data){
            if (data>p.data) p=p.right;
            else p=p.left;
        }
        //因为出来条件是不等于null和找到节点，先筛选一次
        if (p==null) return;

        //后面执行步骤是找到数据了

        //要删除节点有两个子节点
        if (p.left!=null&&p.right!=null){
            //查找右子树中最小值，拿来替换被删节点
            Node minpp=p;//minp的父节点
            Node minp=p.right;
            //找到最小值
            while (minp.left!=null) {
                minpp=minp;
                minp=minp.left;
            }
            //赋值给被删除节点
            p.data=minp.data;
            pp=minpp;
            p=minp;
        }

        //之后去删除minp这个节点 或者从上面过来只有一个子节点的节点（包括根节点）
        Node child;//p的节点
        if (p.left!=null) child=p.left;
        else if (p.right!=null) child=p.right;
        else child=null;

        if (pp==null) p=child; //删除根节点
        else if (pp.left==p) pp.left=child;
        else pp.right=child;
    }

    public Node findMin(){
        if (root==null){
            return null;
        }
        Node p=root;
        while (p.left!=null){
            p = p.left;
        }
        return p;
    }
    public Node findMax(){
        if(root==null){
            return null;
        }
        Node p=root;
        while (p.right!=null){
            p = p.right;
        }
        return p;
    }

    @Test
    public void test() {
        Node node = new Node(1);
        root = node;
        Node temp = root;
        temp.data = 111;
        System.out.println(root.data);
    }
}

