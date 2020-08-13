# Job Sequencing Problem

## Introduction

- In job sequencing problem the objective is to find the sequence of jobs,which is completed within their deadlines and give maximum profit.
- If a set of n jobs are given which are associated with deadlines and profit is earned and a job is completed by its deadline. 
- These jobs need to be ordered in such a way that there is maximum profit.

#### Problem Statement:

Given an array of jobs where every job has a deadline and associated profit if the job is finished before the deadline. It is also given that every job takes single unit of time, so the minimum possible deadline for any job is 1. How to maximize total profit if only one job can be scheduled at a time.

**Lets take one example:**

![Job Sequencing](/assets/job_sequencing.png)

**Solution:**
> A simple solution is to generate all subsets of given set of jobs and check individual subset for feasibility of jobs in that subset. 
>
> Keep track of maximum profit among all feasible subsets. The time complexity of this solution is exponential.
>
> We can also solve this problem using greedy method which is more optimal than simple solution.So lets solve this problem via greedy method.

![Job Sequencing Problem2](/assets/job_sequencing2.png)

**To solve the job sequencing problem via greedy method follow this steps:**

1. Sort all jobs in decreasing order of profit.
2. Initialize the result sequence as first job in sorted jobs.
3. Do following for remaining n-1 jobs.
4. If the current job can fit in the current result sequence without missing the deadline, add current job to the result. Else ignore the current job.


## Design and Implementation

Here is a full implementation of [Job Sequencing Problem](https://github.com/tabassum-khan/Data-Structures-and-Algorithms/blob/master/greedyAlgo/JobSequencing.java).





