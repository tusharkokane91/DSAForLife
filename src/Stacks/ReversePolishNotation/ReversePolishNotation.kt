package Stacks.ReversePolishNotation

fun evalRPN(tokens: Array<String>): Int {

    val stack = mutableListOf<Int>()

    for (token in tokens) {
        when (token) {
            "+" -> {
                val n2 = stack.removeLast()
                val n1 = stack.removeLast()
                stack.add(n1+n2)
            }
            "-" -> {
                val n2 = stack.removeLast()
                val n1 = stack.removeLast()
                stack.add(n1-n2)
            }
            "*" -> {
                val n2 = stack.removeLast()
                val n1 = stack.removeLast()
                stack.add(n1*n2)
            }
            "/" -> {
                val n2 = stack.removeLast()
                val n1 = stack.removeLast()
                stack.add(n1/n2)
            }
            else -> {
                stack.add(token.toInt())
            }
        }
    }

    return stack.removeLast()
}

fun main() {
    // Test cases
    println(evalRPN(arrayOf("2", "1", "+", "3", "*")))  // Output: 9
    println(evalRPN(arrayOf("4", "13", "5", "/", "+"))) // Output: 6
    println(evalRPN(arrayOf("10", "6", "9", "3", "/", "*", "+", "11", "-"))) // Output: 17
}
