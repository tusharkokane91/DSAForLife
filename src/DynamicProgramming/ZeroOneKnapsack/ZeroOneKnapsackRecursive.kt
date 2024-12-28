package DynamicProgramming.ZeroOneKnapsack

/**
 * Time complexity
 *  - Since we have a choice to include or exclude each element, the recursive solution explores all the possible
 *  subsets of items.
 *  - That leads to time complexity of (2^n). This is exponential.
 *
 * Space complexity
 *  - O(n) due to call stack used in recursion.
 */
fun knapsackRecursive(weights: IntArray, values: IntArray, capacity: Int, n: Int): Int {
    // Base case -> no items left or no capacity left in the knapsack
    if (n == 0 || capacity == 0) return 0

    // If the weight of the item is greater than the remaining capacity, we have to exclude it
    if (weights[n-1] > capacity) {
        return knapsackRecursive(weights, values, capacity, n-1)
    }

    /*
      Now, we have two choices. Either to include the current element values[n-1] or to exclude it.
        - For include, we do current value + recursive call with decreased capacity and decreased n.
        - For exclude, we do recursive call with decreased n.

      At the end, we return the max of include and exclude.
     */
    val include = values[n-1] + knapsackRecursive(weights, values, capacity-weights[n-1], n-1)
    val exclude = knapsackRecursive(weights, values, capacity, n-1)

    return maxOf(include, exclude)
}

fun main() {
    val weights = intArrayOf(1, 2, 3, 4)
    val values = intArrayOf(10, 20, 30, 40)
    val capacity = 5
    val n = weights.size

    println("Maximum value: ${knapsackRecursive(weights, values, capacity, n)}") // Output: 50
}
