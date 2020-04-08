package com.wh.dataStruct1.tree;

import java.util.ArrayList;
import java.util.List;

public class FullBinaryTree {
    private  static List<Node> list=null;
    public  void createTree(int[] data){
        //判断data是否未空
        checkDataEmpty(data);
        int len=data.length;
        //先将数组转为对应的节点，放入list中
        list=new ArrayList<>(len);
        for (int i = 0; i <len ; i++) {

            list.add(new Node(data[i]));
        }

        //为什么是len/2-1 10个节点 实际需要添加左右孩子的只有，1,2,4,8  4+1个
        int halfIndex=len/2-1;
        for (int indexParent = 0; indexParent <halfIndex ; indexParent++) {
            Node IndexParentNode=list.get(indexParent);
            //左孩子
            IndexParentNode.left=list.get(2*indexParent+1);
            //右孩子
            IndexParentNode.right=list.get(2*indexParent+2);
        }
        //最后一个节点单独拿出来处理  为什么左孩子不判断
        Node lastNode=list.get(halfIndex);
        lastNode.left=list.get(2*halfIndex+1);
        //判断他有没有右孩子
        if (len % 2 == 1)
            lastNode.right=list.get(2*halfIndex+2);

    }

    /**
     * 前序遍历 递归实现
     * @param node
     */
    public  void preOrderTraverse(Node node){
        //递归出口
        if (node==null){
           return;
        }
        System.out.print(node.data+"\t");
        preOrderTraverse(node.left);
        preOrderTraverse(node.right);
    }

    /**
     * 中序遍历
     * @param node
     */
    public  void inOrderTraverse(Node node){
//        (node.left!=null){
//            node=node.left;
//        }
//        System.out.print(node.data+"\t");
//        inOrderTraverse(node.left);
//        preOrderTraverse(node.right);

    }

    public  boolean checkDataEmpty(int[] data){
        if (data.length!=0){
            return true;
        }else throw new IllegalArgumentException("传入元素为空");

    }

    public static void main(String[] args) {
        FullBinaryTree fullBinaryTree = new FullBinaryTree();
        int[] data={1,2,3,4,5,6,7,8,9};
        fullBinaryTree.createTree(data);
        Node root=list.get(0);
        System.out.println("前序遍历");
        fullBinaryTree.preOrderTraverse(root);
    }
}
