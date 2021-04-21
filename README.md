# OptimalBinarySearchTree

## Performance

The performance of the Optimal Binary Search Tree algorithm is O(n^3).

This may not be evident at first; however, once the size of n increases to 10,000 or so, the amount of time it would take to compute the OBST would become extremely large. Given my current computer setup, I was only able to run up to n=5000. 5000^3 = 1.25E+11 which is not very close to the time it took my program which was 248,738 milliseconds. The reason for this is because O(n^3) is the worst-case time complexity, so it may not have taken my computer worst case time.

In fact, the time taken for my program to run for 5000 keys was only 0.0002% the amount of time needed if 5000 ran for O(n^2). Perhaps there is something that is not not right with my program. Overall, one can still see how fast the values grow if the spreadsheet that I attached in this repository is looked at.

## Design

The approach that I took for this assignment was to create an OptimalBinarySearchTree class. Each time an object of this class is instantiated, an n size can be passed as a parameter. The tree takes this n size and initializes the p, q, cost, weight, and root arrays. There are n frequencies and n+1 dummy keys, and the program assignes a random probability for each one. Then, the sum of both arrays are found and added together. Finally, the program iterates thorugh both arrays again and divides the random number by the sum of both arrays. This is how random probabilities are created which all add up to 1. The p and q arrays are then given as parameters into the function that calculates the cost, weight, and root tables. Once the tables are calculated, they are printed and formatted to their own files using a BufferedWriter object.

The only part of this assignment that I wasn't able to complete is creating the OBST from the root array. I got really close but I ran out of time, which is strange, because I spent a few days or so on this assignment.

Overall, I think I learned quite a bit and I am satisifed that I was able to successfully calculate the cost, weight, and root arrays.

Given some more time, you can see where I wrote my own BinarySearchTree class. My goal was to calulate the nodes from the root table and then insert each one into the binary search tree. Then, I could have simply performed a preorder traversal and printed the entire tree out.
