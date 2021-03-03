package edu.rkissinger;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class Main {

  public static void main(String[] args) throws IOException {
    new OptimalBinarySearchTree(10);
    new OptimalBinarySearchTree(50);
    new OptimalBinarySearchTree(100);
    new OptimalBinarySearchTree(500);
    new OptimalBinarySearchTree(1000);
    new OptimalBinarySearchTree(5000);

    // It would take an amazing amount of time to calculate this...
    // OptimalBinarySearchTree obj4 = new OptimalBinarySearchTree(10000);
    // OptimalBinarySearchTree obj5 = new OptimalBinarySearchTree(100000);
  }
}
