# Activity Selection Problem

## Introduction

- The Activity Selection Problem is an optimization problem which deals with the selection of non-conflicting activities that needs to be executed by a single person or machine in a given time frame.

 - Each activity is marked by a start and finish time. Greedy technique is used for finding the solution since this is an optimization problem.

#### Problem Statement:

You are given n activities with their start and finish times. Select the maximum number of activities that can be performed by a single person, assuming that a person can only work on a single activity at a time.

> **Example:**
>
> Example 1 : Consider the following 3 activities sorted by finish time.
>
>     start[]  =  {10, 12, 20};
>     finish[] =  {20, 25, 30};
>
> A person can perform at most two activities. The maximum set of activities that can be executed is {0, 2}. 
>
>
> **Example 2 :**
>
> Consider the following 6 activities sorted by by finish time.
>
>     start[]  =  {1, 3, 0, 5, 8, 5};
>     finish[] =  {2, 4, 6, 7, 9, 9};
>
> A person can perform at most four activities. The maximum set of activities that can be executed is {0, 1, 3, 4}.


**Representation of Activity Selection Problem:**

> S = (A1 A2 A3 A4 A5 A6 A7 A8 A9 A10)
>
> Si = (1,2,3,4,7,8,9,9,11,12)
>
> fi = (3,5,4,7,10,9,11,13,12,14)

![Activity Selection Problem](/assets/activity-selection-problem.png)

![Activity Selection Problem2](/assets/activity-selection-problem2.png)

> The final Activity schedule is:
> 
> ![Activity Selection Problem3](/assets/activity-selection-problem3.png)


## Design and Implementation

Here is a full implementation of [Activity Selection Problem](https://github.com/tabassum-khan/Data-Structures-and-Algorithms/blob/master/greedyAlgo/ActivitySelecionProblem.java).






