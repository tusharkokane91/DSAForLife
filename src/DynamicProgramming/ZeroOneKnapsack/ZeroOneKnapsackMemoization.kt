package DynamicProgramming.ZeroOneKnapsack

/**
 * Time complexity
 *  - Since the size of memoization table is n * capacity(W), and each item of that table is to be processed,
 *  the time complexity comes off to be O(n*W).
 *
 * Space complexity
 *  - Memoization table O(n*W)
 *  - Recursive stack O(n)
 *
 *  Total space complexity is O((n*W)+n)
 */
fun knapsackMemo(weights: IntArray, values: IntArray, capacity: Int, n: Int, memo: Array<IntArray>): Int {
    // Base case -> no items left or no capacity left in the knapsack
    if (n == 0 || capacity == 0) return 0

    /*
      If the result is already computed and is present in memo, that is, memo[n][capacity] != -1, return it. So even
      if there is a recursive call, there is no computation that has already been done being repeated.

      This brings down the time complexity of this approach to linear compared to that of recursive approach which is exponential.
     */
    if (memo[n][capacity] != -1) return memo[n][capacity]

    // If the weight of the item is greater than the remaining capacity, we have to exclude it
    if (weights[n-1] > capacity) {
        memo[n][capacity] = knapsackRecursive(weights, values, capacity, n-1)
    }

    /*
      Now, we have two choices. Either to include the current element values[n-1] or to exclude it.
        - For include, we do current value + recursive call with decreased capacity and decreased n.
        - For exclude, we do recursive call with decreased n.

      At the end, we return the max of include and exclude.
     */
    val include = values[n-1] + knapsackRecursive(weights, values, capacity-weights[n-1], n-1)
    val exclude = knapsackRecursive(weights, values, capacity, n-1)
    memo[n][capacity] = maxOf(include, exclude)

    return memo[n][capacity]
}

fun main() {
    val weights = intArrayOf(1, 2, 3, 4)
    val values = intArrayOf(10, 20, 30, 40)
    val capacity = 5
    val n = weights.size

    // Initialize memoization table with -1
    val memo = Array(n + 1) { IntArray(capacity + 1) { -1 } }

    println("Maximum value: ${knapsackMemo(weights, values, capacity, n, memo)}") // Output: 50
}
