# OptimalBinarySearchTree

I used the Introduction to Algorithms (CLR) book for this project, which I highly recommend.

## Intro

Imagine that you own a roadside store.

There are items that you sell very frequently and items that you sell maybe not so frequently, and each of these items has a cost. As a business owner, you want to keep the most expensive frequently sold items near the front of the shop so customers can access them. Less expensive and frequently bought items should be in the back room for the occasional customer who needs to buy them. How do we achieve an optimal business model based on this problem in which you make the most profit?

## Structure and Performance

* Implemented an optimal binary search tree algorithm from scratch using dynammic programming.
* Tree supports successful and unsuccessful searches by using dummy nodes such that each dummy node represents the equivalence class {x | d_(n-1) < x < d_(n)}.
* Tabular method is used to record solutions to each optimal sub-strucure along the way to global optimum.
* Nodes in the OBST are classified by level depending on their key (value) and frequency of occurrence.
* Tree is generated using the root matrix and an algorithm which finds the optimal tree based on the optimal sub-structure path within the root matrix.
* Algorithm was run for increasingly larger sets of keys in which optimal trees were generated from.
* Performance of the key sets were charted by logarithmic calculation time over set size.
* Given that this is a O(n^3) algorithm, sets larger than 1000 keys were not able to generate OBST's due to time constraints.
* Even a set size of 1000 would generate a total number of operations on the order of up to 1e9 operations.
* Thus, this is an exponential algorithm; however, there are similar OBST tree implementations that can yield O(log n) time.

## Design

The approach that I took for this assignment was to create an OptimalBinarySearchTree class. Each time an object of this class is instantiated, an n size can be passed as a parameter. The tree takes this n size and initializes the p, q, cost, weight, and root arrays. There are n frequencies and n+1 dummy keys, and the program assignes a random probability for each one. Then, the sum of both arrays are found and added together. Finally, the program iterates thorugh both arrays again and divides the random number by the sum of both arrays. This is how random probabilities are created which all add up to 1. The p and q arrays are then given as parameters into the function that calculates the cost, weight, and root tables. Once the tables are calculated, they are printed and formatted to their own files using a BufferedWriter object.

The only part of this assignment that I wasn't able to complete is creating the OBST from the root array. I got really close but I ran out of time, which is strange, because I spent a few days or so on this assignment.

Overall, I think I learned quite a bit and I am satisifed that I was able to successfully calculate the cost, weight, and root arrays.

Given some more time, you can see where I wrote my own BinarySearchTree class. My goal was to calulate the nodes from the root table and then insert each one into the binary search tree. Then, I could have simply performed a preorder traversal and printed the entire tree out.
