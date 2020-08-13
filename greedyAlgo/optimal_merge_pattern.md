# Optimal File Merge Pattern

## Introduction

- Optimal merge pattern is a pattern that relates to the merging of two or more sorted files in a single sorted file. This type of merging can be done by the two-way merging method.
- If we have two sorted files containing n and m records respectively then they could be merged together, to obtain one sorted file in time O (n+m).
- The formula of external merging cost is:
> [Optimal merge pattern formula](/assets/optimal-merge-pattern.webp)
> 
> Where, f (i) represents the number of records in each file and d (i) represents the depth.

**Example:**

> Given 3 files with size 2, 3, 4 units.Find optimal way to combine these files
> 
>     Input: n = 3, size = {2, 3, 4}
>     Output: 14
>
> Explanation: There are different ways to combine these files:
>
> **Method 1: Optimal method**
> 
> ![Optimal file merge](/assets/optimal-merge-pattern1.jpg)
>
> **Method 2:**
> 
> ![Optimal file merge](/assets/optimal-merge-pattern2.jpg)
>
> **Method 3:**
> 
> ![Optimal file merge](/assets/optimal-merge-pattern3.jpg)
>
>
> **Example 2:**
> 
>     Input: n = 6, size = {2, 3, 4, 5, 6, 7}
>     Output: 68
>
> Explanation: Optimal way to combine these files
> 
> ![Optimal file merge](/assets/optimal-merge-pattern4.jpg)


#### Problem Statement:

Given n number of sorted files, the task is to find the minimum computations done to reach Optimal Merge Pattern.

**Solution:**
###### Node represents a file with a given size also given nodes are greater than 2

> 1. Add all the nodes in a priority queue (Min Heap).{node.weight = file size}
> 
> 2. Initialize count = 0 // variable to store file computations.
> 
> 3. Repeat while (size of priority Queue is greater than 1)
>
>     - create a new node 
>     - new node = pq.poll().weight+pq.poll().weight;
>     //  (pq denotes priority queue, remove 1st smallest and 2nd smallest element and add their weights to get a new node)
>     - count += node.weight
>     - add this new node to priority queue;
>
> 4. count is the final answer


## Design and Implementation

Here is a full implementation of [Optimal Merge Pattern](https://github.com/tabassum-khan/Data-Structures-and-Algorithms/blob/master/greedyAlgo/OptimalMergePattern.java).




