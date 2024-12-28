package Stacks.ValidParentheses

fun validParentheses(s: String): Boolean {
    val stack = mutableListOf<Char>()
    if (s.isEmpty()) return true

    for (char in s) {
        when (char) {
            '(', '{', '[' -> stack.add(char)
            ')' -> {
                if (stack.removeLast() != '(') return false
            }
            '}' -> {
                if (stack.removeLast() != '{') return false
            }
            ']' -> {
                if (stack.removeLast() != '[') return false
            }
        }
    }

    return stack.isEmpty()
}

fun main() {
    // Test cases
    println(validParentheses(""))          // Expected: true (empty string should be valid)
    println(validParentheses("()"))        // Expected: true
    println(validParentheses("()[]{}"))    // Expected: true
    println(validParentheses("(]"))        // Expected: false
    println(validParentheses("([)]"))      // Expected: false
    println(validParentheses("{[]}"))      // Expected: true
    println(validParentheses("{[()]}"))    // Expected: true
    println(validParentheses("((()))"))    // Expected: true
    println(validParentheses("({[}])"))    // Expected: false
    println(validParentheses("[{()}]({}[)]")) // Expected: false
    println(validParentheses("([]){}"))    // Expected: true
    println(validParentheses("(({{}}))"))  // Expected: true
    println(validParentheses("({[]})"))    // Expected: true
    println(validParentheses("(([]){})"))  // Expected: true
    println(validParentheses("([)]"))      // Expected: false
    println(validParentheses("({[}])"))    // Expected: false
    println(validParentheses("({([)]})"))  // Expected: false
    println(validParentheses("({[()]})"))  // Expected: true
}

// Expected outputs:
// true
// true
// true
// false
// false
// true
// true
// true
// false
// false
// true
// true
// true
// true
// false
// false
// false
// true
