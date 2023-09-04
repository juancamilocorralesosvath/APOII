package model;

public class TreeNode {
    private Integer key;
    private TreeNode right;
    private TreeNode left;

    public TreeNode(Integer key){
        this.key = key;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public String toString(){
        return this.key+"";
    }
}
