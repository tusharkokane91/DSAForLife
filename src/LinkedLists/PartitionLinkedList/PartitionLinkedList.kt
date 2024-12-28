package LinkedLists.PartitionLinkedList

// You should have a top level function called main

/**
 * The problem asks us to partition a singly linked list around a value 𝑥 x, such that:
 *
 * All nodes with values less than 𝑥 x appear before nodes with values greater than or equal to 𝑥 x. The relative order of nodes within each partition must be preserved. Approach We can solve this by creating two separate lists:
 *
 * Left Partition: Contains nodes with values less than 𝑥 x. Right Partition: Contains nodes with values greater than or equal to 𝑥 x. Finally, we combine these two lists to form the partitioned linked list.
 */

data class Node(var value: Int, var next: Node? = null)

fun main(args: Array<String>) {
    // Create the linked list: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1
    val head = Node(3, Node(5, Node(8, Node(5, Node(10, Node(2, Node(1)))))))

    println("Original linked list:")
    printLinkedList(head)

    val partitionValue = 5
    val partitionedHead = partition(head, partitionValue)

    println("Partitioned linked list around $partitionValue:")
    printLinkedList(partitionedHead)
}

fun partition(head: Node?, x: Int): Node? {
    if (head == null) return null

    val leftHead = Node(0)
    val rightHead = Node(0)
    var left = leftHead
    var right = rightHead
    var current = head

    while(current != null) {
        if (current.value < x) {
            left.next = current
            left = left.next!!
        } else {
            right.next = current
            right = right.next!!
        }

        current = current.next
    }

    right.next = null
    left.next = rightHead.next

    return leftHead.next
}

fun printLinkedList(head: Node?) {
    var current = head
    while(current != null) {
        print("${current.value} -> ")
        current = current.next
    }

    println("null")
}