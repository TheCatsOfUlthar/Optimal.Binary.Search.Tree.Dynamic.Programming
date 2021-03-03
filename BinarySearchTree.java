package edu.rkissinger;

class BinarySearchTree {

  private static Node root;
  private static final int COUNT = 5;

  public static Node getRoot() {
    return root;
  }

  public static void setRoot(Node root) {
    BinarySearchTree.root = root;
  }

  static class Node {
    int key;
    Node left, right;

    Node(int item) {
      key = item;
      left = right = null;
    }

    public int getKey() {
      return key;
    }

    public void setKey(int key) {
      this.key = key;
    }

    Node getLeft() {
      return left;
    }

    public void setLeft(Node left) {
      this.left = left;
    }

    public Node getRight() {
      return right;
    }

    public void setRight(Node right) {
      this.right = right;
    }
  }

  BinarySearchTree() {
    root = null;
  }

  void insert(int key) {
    root = insertRec(root, key);
  }

  private Node insertRec(Node root, int key) {

    if (root == null) {
      root = new Node(key);
      return root;
    }

    if (key < root.key) {
      root.left = insertRec(root.left, key);
    } else if (key > root.key) {
      root.right = insertRec(root.right, key);
    }
    return root;
  }

  void inorder() {
    inorderRec(root);
  }

  private void inorderRec(Node root) {
    if (root != null) {
      inorderRec(root.left);
      System.out.println(root.key);
      inorderRec(root.right);
    }
  }

  // Function to print binary tree in 2D
  // It does reverse inorder traversal
  private static void print2DUtil(Node root, int space) {
    // Base case
    if (root == null) return;

    // Increase distance between levels
    space += COUNT;

    // Process right child first
    print2DUtil(root.right, space);

    // Print current node after space
    // count
    System.out.print("");
    for (int i = COUNT; i < space; i++) System.out.print(" ");
    System.out.print(root.key + "\n");

    // Process left child
    print2DUtil(root.left, space);
  }

  // Wrapper over print2DUtil()
  static void print2D(Node root) {
    // Pass initial space count as 0
    print2DUtil(root, 0);
  }
}
