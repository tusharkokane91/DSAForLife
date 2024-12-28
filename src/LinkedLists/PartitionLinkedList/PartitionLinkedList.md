The problem asks us to partition a singly linked list around a value
𝑥
x, such that:

All nodes with values less than
𝑥
x appear before nodes with values greater than or equal to
𝑥
x.
The relative order of nodes within each partition must be preserved.
Approach
We can solve this by creating two separate lists:

Left Partition: Contains nodes with values less than
𝑥
x.
Right Partition: Contains nodes with values greater than or equal to
𝑥
x.
Finally, we combine these two lists to form the partitioned linked list.

Steps:
Create two dummy nodes, leftHead and rightHead, to serve as the heads of the two partitions.
Traverse the input list:
If a node's value is less than
𝑥
x, add it to the left partition.
Otherwise, add it to the right partition.
After traversal, connect the two partitions.
Ensure the end of the right partition points to null.
Time and Space Complexity
Time Complexity:
𝑂
(
𝑛
)
O(n), where
𝑛
n is the number of nodes in the linked list. We traverse the list once.
Space Complexity:
𝑂
(
1
)
O(1), since we do not use extra space apart from pointers for partitioning.


Edge Cases
Empty List:
If the input list is empty, return null.
All Nodes <
𝑥
x:
The right partition will be empty, and the result will be the same as the input list.
All Nodes >=
𝑥
x:
The left partition will be empty, and the result will be the same as the input list.
This solution ensures the partitioning is done efficiently with
𝑂
(
1
)
O(1) space and preserves the relative order of nodes within each partition.