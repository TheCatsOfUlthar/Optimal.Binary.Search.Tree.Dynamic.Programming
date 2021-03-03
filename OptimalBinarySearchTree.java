package edu.rkissinger;

import java.io.*;
import java.util.LinkedList;
import java.util.Random;

class OptimalBinarySearchTree {

  private int[] keys;
  private double[] p;
  private double[] q;

  private double[][] weight;
  private double[][] cost;
  private int[][] root;

  private static int[] dataPoints = new int[5];
  private LinkedList linkedList = new LinkedList();

  private int n;

  OptimalBinarySearchTree(int n) throws IOException {

    this.n = n;
    BinarySearchTree binarySearchTree = new BinarySearchTree();
    this.keys = new int[n + 1];
    this.weight = new double[n + 2][n + 1];
    this.cost = new double[n + 2][n + 1];
    this.root = new int[n + 1][n + 1];

    this.p = new double[n + 1];
    this.q = new double[n + 1];

    // TESTING
    // this.p = new double[] {0.0, 0.15, 0.10, .05, .10, .20};
    // this.q = new double[] {.05, .10, .05, .05, .05, .10};

    // keys = addKeysToIntArray(keys);

    addProbsToFloatArray(p, q);

    long startTime = System.currentTimeMillis();
    calculateWeightCostRootArrays();
    long endTime = System.currentTimeMillis();
    long duration = (endTime - startTime);
    System.out.println(duration);

    // printArrays(weight);
    // printArrays(cost);
    // printArrays(root);
    // printArrays(p);
    // printArrays(q);
    storeArraysInFiles();
  }

  private void calculateWeightCostRootArrays() {
    for (int i = 1; i <= n + 1; i++) {
      cost[i][i - 1] = q[i - 1];
      weight[i][i - 1] = q[i - 1];
    }
    for (int l = 1; l <= n; l++) {
      for (int i = 1; i <= n - l + 1; i++) {
        int j = i + l - 1;
        cost[i][j] = Double.POSITIVE_INFINITY;
        weight[i][j] = weight[i][j - 1] + p[j] + q[j];
        for (int r = i; r <= j; r++) {
          double t = cost[i][r - 1] + cost[r + 1][j] + weight[i][j];
          if (t < cost[i][j]) {
            cost[i][j] = t;
            root[i][j] = r;
          }
        }
      }
    }
  }

  private int[] addKeysToIntArray(int[] keys) {
    // Sequentially adds n keys
    for (int i = 0; i < keys.length; i++) {
      keys[i] = i;
    }
    return keys;
  }

  private void divideElementsInFloatArraysByTheirSum(double[] array, double[] dummy) {
    double sum = getSumOfRandomFloats(array, dummy);
    for (int i = 0; i < array.length; i++) {
      array[i] = (array[i] / sum);
    }
    for (int i = 0; i < dummy.length; i++) {
      dummy[i] = (dummy[i] / sum);
    }
    this.p = array;
    this.q = dummy;
  }

  private void addProbsToFloatArray(double[] probs, double[] dummy) {
    // Creates n random floats. Normal prob
    Random rand1 = new Random();
    for (int j = 0; j < probs.length; j++) {
      if (j == 0) {
        probs[j] = 0;
      } else {
        probs[j] = rand1.nextDouble();
      }
    }
    for (int j = 0; j < dummy.length; j++) {
      dummy[j] = rand1.nextDouble();
    }
    divideElementsInFloatArraysByTheirSum(probs, dummy);
  }

  private float getSumOfRandomFloats(double[] array, double[] dummy) {
    float count = 0;
    for (double v : array) {
      count += v;
    }
    for (double v : dummy) {
      count += v;
    }
    return count;
  }

  private void printArrays(double[][] array) {
    for (double[] doubles : array) {
      for (int j = 0; j < array.length - 1; j++) {
        System.out.print(String.format("%.05f", doubles[j]) + " ");
      }
      System.out.println();
    }
    System.out.println("\n");
  }

  private void printArrays(int[][] array) {
    for (int[] ints : array) {
      for (int j = 0; j < array.length; j++) {
        System.out.print(ints[j] + " ");
      }
      System.out.println();
    }
    System.out.println("\n");
  }

  private void printArrays(double[] array) {
    for (double v : array) {
      System.out.print(String.format("%.05f", v) + " ");
    }
    System.out.println();
  }

  private void storeArraysInFiles() throws IOException {
    File file1 = new File(n + ".weight.txt");
    Writer writer1 = new FileWriter(file1.getAbsoluteFile());
    try (BufferedWriter bufferedWriter = new BufferedWriter(writer1)) {
      for (int i = 1; i < this.weight.length; i++) {
        for (int j = 0; j < this.weight.length - 1; j++) {
          bufferedWriter.write(String.format("%.03f", weight[i][j]) + "\t");
        }
        bufferedWriter.write("\n");
      }
    } catch (IOException e) {
      System.out.println();
    }

    File file2 = new File(n + ".cost.txt");
    Writer writer2 = new FileWriter(file2.getAbsoluteFile());
    try (BufferedWriter bufferedWriter = new BufferedWriter(writer2)) {
      for (int i = 1; i < this.cost.length; i++) {
        for (int j = 0; j < this.cost.length - 1; j++) {
          bufferedWriter.write(String.format("%.03f", cost[i][j]) + "\t");
        }
        bufferedWriter.write("\n");
      }
    } catch (IOException e) {
      System.out.println();
    }

    File file3 = new File(n + ".root.txt");
    Writer writer3 = new FileWriter(file3.getAbsoluteFile());
    try (BufferedWriter bufferedWriter = new BufferedWriter(writer3)) {
      for (int i = 1; i < this.root.length; i++) {
        for (int j = 0; j < this.root.length; j++) {
          bufferedWriter.write(String.format("%d", root[i][j]) + "\t");
        }
        bufferedWriter.write("\n");
      }
    } catch (IOException e) {
      System.out.println();
    }
  }
}
