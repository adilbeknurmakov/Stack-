/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

import csci152.adt.Set;

/**
 *
 * @author Адильбек,  Tawit adeka
 * @param <T>
 */
public class BSTSet<T extends Comparable> implements Set<T> {
    private TreeNode<T> root;
    private int size;

    public BSTSet(){
        root = null;
        size = 0;
    }
    @Override
    public void add(T value) {
        
        //System.out.println("as");
        if(size == 0){
            size ++;
            root = new TreeNode<T>(value);
            //System.out.println(root.getValue());
        }
        else{
            size ++;
            TreeNode<T> cur = root;
            //System.out.println(cur.getValue());
            while(true){
                if(value.compareTo(cur.getValue()) < 0){
                    if(cur.getLeft() == null){
                        cur.setLeft(new TreeNode(value));
                        break;
                    }
                    else{
                        cur = cur.getLeft();
                    }
                }
                else if(value.compareTo(cur.getValue()) > 0){
                    if(cur.getRight() == null){
                        cur.setRight(new TreeNode(value));
                        break;
                    }
                    else{
                        cur = cur.getRight();
                    }
                }
                else {size--;break;}
            }
        }
    }

    @Override
    public boolean contains(T value) {
        if(size == 0) return false;
        TreeNode<T> cur = root;
        while(true){
            if(value.compareTo(cur.getValue()) < 0){
                if(cur.getLeft() == null){
                    return false;
                }
                else{
                    cur = cur.getLeft();
                }
            }
            else if(value.compareTo(cur.getValue()) > 0){
                if(cur.getRight() == null){
                    return false;
                }
                else{
                    cur = cur.getRight();
                }
            }
            else return true;
        }
    }
    
    private void switchChild(TreeNode<T> parent, TreeNode<T> oldChild, TreeNode<T> newChild){
        if(parent == null) {
            root = newChild;
            return;
        }
        if(parent.getLeft() == oldChild){
            parent.setLeft(newChild);
        }
        else{
            parent.setRight(newChild);
        }
    }
    
    private T cutSmallestNode(TreeNode<T> parent, TreeNode<T> node){
        if(node.getLeft() != null){
            return cutSmallestNode(node, node.getLeft());
        }
        
        switchChild(parent, node, node.getRight());
        
        return node.getValue();        
    }
    
    private int numOfChildren(TreeNode<T> node){
        int num = 0;
        if(node.getRight() != null)num++;
        if(node.getLeft() != null)num++;
        return num;
    }
    
    private boolean removeHelper(TreeNode<T> parent, TreeNode<T> node, T value){
        if(node == null){return false;}
        
        if(value.compareTo(node.getValue()) < 0)
            return removeHelper(node, node.getLeft(), value);
        else if(value.compareTo(node.getValue()) > 0)
            return removeHelper(node, node.getRight(), value);
        
        int childs = numOfChildren(node);
        
        if(childs == 0){
            switchChild(parent, node, null);
        }
        else if(childs == 1){
            switchChild(parent, node, (node.getLeft() != null)? node.getLeft() : node.getRight());
        }
        else{
            node.setValue(cutSmallestNode(node, node.getRight()));
        }
        size--;
        return true;
    }
    
    @Override
    public boolean remove(T value) {
        return removeHelper(null, root, value);
    }

    @Override
    public T removeAny() throws Exception {
        if(size == 0){throw new Exception("Netu nicherta!");}
        T res = root.getValue();
        remove(res);
        return res;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        size = 0;
        root = null;
    }
    
    String toStringHelper(TreeNode<T> node){
        if(node == null){
            return "";
        }
        return toStringHelper(node.getLeft()) + " " + node.getValue() + " " + toStringHelper(node.getRight());
    }
    
    @Override
    public String toString(){
        return toStringHelper(root);
    }
    
}
