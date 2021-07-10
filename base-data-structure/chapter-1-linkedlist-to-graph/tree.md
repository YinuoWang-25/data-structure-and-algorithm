# 1.2 Tree

## Basic Idea

Tree is a non-linear data structure, and we need to know **how to traverse**.

#### B**ase Case**

Usually refers to the `null ChildNode` below the lead node

#### Special Trees

1. Balanced binary tree
   1. n node -&gt; log\_2 \(n\) height
2. Complete binary tree
   1. must be balanced tree

## Problems

### Traverse

There are two ways to traverse a tree: **DFS** and **BFS**.

For DFS, we have **pre-order**, **in-order** and **post-order**

#### DFS

{% page-ref page="../../all-problems/tree/144.-binary-tree-preorder-traversal.md" %}

{% page-ref page="../../all-problems/tree/94.-binary-tree-inorder-traversal.md" %}

{% page-ref page="../../all-problems/tree/145.-binary-tree-postorder-traversal.md" %}

#### Find value in each layer

They are the same problem

{% page-ref page="../../all-problems/tree/199.-binary-tree-right-side-view.md" %}

{% page-ref page="../../all-problems/tree/513.-find-bottom-left-tree-value.md" %}

{% page-ref page="../../all-problems/tree/515.-find-largest-value-in-each-tree-row.md" %}

#### BFS

{% page-ref page="../../all-problems/tree/102.-binary-tree-level-order-traversal.md" %}

{% page-ref page="../../all-problems/tree/107.-binary-tree-level-order-traversal-ii.md" %}

{% page-ref page="../../all-problems/tree/429.-n-ary-tree-level-order-traversal.md" %}

{% page-ref page="../../all-problems/tree/103.-binary-tree-zigzag-level-order-traversal.md" %}

{% page-ref page="../../all-problems/tree/314.-binary-tree-vertical-order-traversal.md" %}

### Basic Problems

#### Check nodes two by two

{% page-ref page="../../all-problems/tree/100.-same-tree.md" %}

{% page-ref page="../../all-problems/tree/101.-symmetric-tree.md" %}

#### Calculate Depth

{% page-ref page="../../all-problems/tree/104.-maximum-depth-of-binary-tree.md" %}

{% page-ref page="../../all-problems/tree/559.-maximum-depth-of-n-ary-tree.md" %}

{% page-ref page="../../all-problems/tree/111.-minimum-depth-of-binary-tree.md" %}

#### Others

{% page-ref page="../../all-problems/tree/226.-invert-binary-tree.md" %}

{% page-ref page="../../all-problems/tree/110.-balanced-binary-tree.md" %}

{% page-ref page="../../all-problems/tree/617.-merge-two-binary-trees.md" %}

{% page-ref page="../../all-problems/tree/572.-subtree-of-another-tree.md" %}

{% page-ref page="../../all-problems/tree/404.-sum-of-left-leaves.md" %}

{% page-ref page="../../all-problems/tree/366.-find-leaves-of-binary-tree.md" %}

{% page-ref page="../../all-problems/tree/257.-binary-tree-paths.md" %}

{% page-ref page="../../all-problems/tree/129.-sum-root-to-leaf-numbers.md" %}

{% page-ref page="../../all-problems/tree/222.-count-complete-tree-nodes.md" %}

### LCA

{% page-ref page="../../all-problems/tree/236.-lowest-common-ancestor-of-a-binary-tree.md" %}

{% page-ref page="../../all-problems/tree/235.-lowest-common-ancestor-of-a-binary-search-tree.md" %}

### Path Sum

{% page-ref page="../../all-problems/tree/112.-path-sum.md" %}

{% page-ref page="../../all-problems/tree/113.-path-sum-ii.md" %}

{% page-ref page="../../all-problems/tree/437.-path-sum-iii.md" %}

{% page-ref page="../../all-problems/tree/666.-path-sum-iv.md" %}

{% page-ref page="../../all-problems/tree/124.-binary-tree-maximum-path-sum.md" %}

### Local and Global

#### General Ideas

**global 的最终的结果跟当前node所产生的最终结果有关，所以要在当下进行更新。但是当前node的返回值并不是global value，是另一一个辅助上层node进行计算的value**

**这类题的结果值通常与每一个node都有关系，不一定只从root出发**

**套路是跟左右子树的结果相加，但是返回值是跟某一边相加**

#### Example Problems

{% page-ref page="../../all-problems/tree/543.-diameter-of-binary-tree.md" %}

**返回值**是通过当前node的最长的边长

**当前层** 计算跟左右子树相加得到的最长path然后更新global

{% page-ref page="../../all-problems/tree/124.-binary-tree-maximum-path-sum.md" %}

**返回值**是以当前node为顶点的最大sum

**当前层** 计算跟左右子树相加得到的最大sum然后更新global

1. Binary Tree Longest Consecutive Sequence

**返回值**是以当前node为顶点的最长path

**当前层 是** 以当前node为顶点的最长path 并更新global

1. Binary Tree Longest Consecutive Sequence II

**返回值**是通过当前node的最长的边长

**当前层** 计算跟左右子树相加得到的最长path然后更新global

1. Largest BST Subtree
2. Count Univalue Subtrees

返回值是以当前node为root的tree是否是Univalue的

如果是的话global sum

* [98. Binary Tree Longest Consecutive Sequence](https://leetcode-cn.com/problems/binary-tree-longest-consecutive-sequence/)
* [549. Binary Tree Longest Consecutive Sequence II](https://leetcode-cn.com/problems/binary-tree-longest-consecutive-sequence-ii/)
* [687. Longest Univalue Path](https://leetcode-cn.com/problems/longest-univalue-path/)
* [543. Diameter of Binary Tree](https://leetcode-cn.com/problems/diameter-of-binary-tree/)

### BST 问题

**BST的问题一一般会利用BST的两个属性**

1. **根据定义， root.val 跟左右子树的关系**
2. **in-order是一个ascending array**

#### **定义属性**

{% page-ref page="../../all-problems/tree/98.-validate-binary-search-tree.md" %}

{% page-ref page="../../all-problems/tree/938.-range-sum-of-bst.md" %}



1. Closest Binary Search Tree Value

bst的特性可以帮助我们在找范围的时候删掉一般的解空间

#### Inorder属性

1. Binary Search Tree Iterator
2. Inorder Successor in BST

注意iterative写法

1. Kth Smallest Element in a BST
2. Find K Closest Elements
3. Closest Binary Search Tree Value II

这道题的重点在于，要找到一个解区间，这个解区间要离一个目标值最近，所以一定要以ascending或者descending的顺序来访问input

两种思路：

1. 维护一个list作为结果，遍历每一个element，然后去跟队头元素进行比较。注意要在res满的时候做出选择： 如果差值更大，可以返回结果，因为后边的只会更大。如果差值更小，做平行移动
2. 先去找到最近的点，然后中心开花。

prefer 思路：

1. array上方便做binary search所以prefer 解法2
2. tree 上用方法1比较方便。 tree上中心开花需要维护两个list， 相当于把tree分到两边， 利用inorder的思路进行正向和反向的比较，中心开花

Recover Binary Search Tree

### Serialize and Deserialize

1. Serialize and Deserialize Binary Tree

pre order 的顺序来进行转换

1. Serialize and Deserialize N-ary Tree

跟上一题的思路相似。又去背的是这个不用考虑node是null的情况，因为每次走到下一层的办法都是在children中找到node，所以一定会有值

### 数据结构之间的转换

Construct Binary Tree from Preorder and Inorder Traversal

Construct Binary Tree from Inorder and Postorder Traversal

Construct Binary Tree from Preorder and Postorder Traversal

Flatten Binary Tree to Linked List

Convert Binary Search Tree to Sorted Doubly Linked List

Convert Sorted Array to Binary Search Tree

Serialize and Deserialize BST

Serialize and Deserialize Binary Tree

Convert BST to Greater Tree

### 利用返回值

1. Delete Node in a BST
2. Delete Nodes And Return Forest
3. Binary Tree Cameras

Return 0 if it's a leaf.

Return 1 if it's a parent of a leaf, with a camera on this node.

Return 2 if it's covered, without a camera on this node.

For each node,

if it has a child, which is leaf \(node 0\), then it needs a camera.

if it has a child, which is the parent of a leaf \(node 1\), then it's covered.

If it needs a camera, then res++ and we return 1.

If it's covered, we return 2.

Otherwise, we return 0.

### 与Array

1. Convert Sorted Array to Binary Search Tree
2. Construct Binary Tree from Preorder and Inorder Traversal

重点在于如何算出左右子树的start和end坐标

index 是在inorder中root的位置

左子树中的node \# 是 index - inStart

左子树在preorder中的区间是 \[preStart +1, preStart + index - inStart \]

1. Construct Binary Tree from Inorder and Postorder Traversal

重点在于如何算出左右子树的start和end坐标

index 是在inorder中root的位置

左子树中的node \# 是 index - inStart

左子树在preorder中的区间是 \[ poststart, poststart + index - instart - 1\]

### Others

1. All Nodes Distance K in Binary Tree
2. Flatten Binary Tree to Linked List
3. Flatten a Multilevel Doubly Linked List
4. Graph Valid Tree
5. Verify Preorder Sequence in Binary Search Tree

维护一个单调递减stack，同时维护一个最小值，这个最小值是这个值的min bound

Binary Tree Upside Down

Verify Preorder Sequence in Binary Search Tree

Leaf-Similar Trees

Sum of Distances in Tree

Swim in Rising Water

Cracking the Safe

**Find Duplicate Subtrees**

* Populating Next Right Pointers in Each Node II
* Populating Next Right Pointers in Each Node

