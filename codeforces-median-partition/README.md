# C. Median Partition

## Problem
Given an array `a` with an odd length `n` consisting of positive integers, partition the sequence into the maximum number of subarrays with odd lengths and the same median.

## Approach

### Key Observation
For any valid partition where all subarrays share the same median `m`, we can prove `m` must equal the median of the entire array. Each subarray of odd length `2k+1` has at most `k` elements greater than `m` and at most `k` elements less than `m`. Summing over all subarrays gives `count(>m) <= (n-p)/2` and `count(<m) <= (n-p)/2`, which forces `m` to be the overall median.

### DP Solution
- Let `dp[i]` = maximum number of subarrays partitioning `a[1..i]`, all with median `m`.
- Transition: for each `i`, check all valid predecessors `j` (where `i-j` is odd) and subarray `a[j+1..i]` has median `m`.
- A subarray of length `L` has median `m` iff `count(>m) <= (L-1)/2` and `count(<m) <= (L-1)/2`.
- Use prefix sums for O(1) range queries.

### Complexity
- **Time:** O(n^2) per test case
- **Space:** O(n)

Fits within constraints since sum of n^2 <= 5000^2.
