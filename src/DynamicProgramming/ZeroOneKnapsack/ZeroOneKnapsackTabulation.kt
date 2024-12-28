package DynamicProgramming.ZeroOneKnapsack

/**
 * Time complexity
 *  - The table is of size n * Capacity. We need to fill the entire table.
 *  - So the time complexity comes to be O(n * Capacity).
 *
 * Space complexity
 *  - O(n * Capacity) for the table.
 */
fun knapsackTabulation(weights: IntArray, values: IntArray, capacity: Int): Int {
    val n = weights.size
    val dp = Array(n+1) { IntArray(capacity+1) { 0 } }

    for (index in 1..n) {
        for (currentCapacity in 1..capacity) {
            val currentWeight = weights[index-1]
            val currentValue = values[index-1]

            /*
              Remember that the index of dp is running +1 faster than that of indices of weights and values. So, for item
              dp[index][capacity], we are essentially referring to the elements weights[index-1] and values[index-1].
             */
            if (currentWeight <= currentCapacity) {
                /*
                  If the weight at the current index is less than or equal to the current capacity, we have a choice to make.
                  Either include the current value or exclude the current value.
                 */
                dp[index][currentCapacity] = maxOf(
                    currentValue + dp[index-1][currentCapacity - currentWeight],
                    dp[index-1][currentCapacity]
                )


            } else {
                // Exclude the current item if weight at the current index is greater than the current capacity.
                dp[index][currentCapacity] = dp[index-1][currentCapacity]
            }
        }
    }

    return dp[n][capacity]
}

fun main() {
    val weights = intArrayOf(1, 2, 3, 4)
    val values = intArrayOf(10, 20, 30, 40)
    val capacity = 5

    println("Maximum value: ${knapsackTabulation(weights, values, capacity)}") // Output: 50
}
