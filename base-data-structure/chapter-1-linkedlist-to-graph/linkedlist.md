# 1.1 LinkedList

## Basic 

LinkedList contains **nodes** linked by **pointers**. It's a Linear data structure.

### Comparing with Array

There are **memory overhead**.

overhead: extra space in memory for sake of data structure maintenance

## Problem Solving

### Always two solutions

The **definition** for LinkedList is in **recursive** way. So there are _**always**_ `iterative` and `recursive` solutions for every LinkedList related problem.

### Principles

1. Never lose the control for **HEAD.**
2. Dereference only after checking NULL.

### Dummy node

We leverage dummy node in two scenarios:

1. the `head` of the LinkedList might be **changed**: deleted, or new head
2. We want to build a LinkedList from scratch \(initially zero nodes\)

### Edge \(Base\) case

Always `head == null`. Sometimes we also need to check whether `head.next == null`.

## Problems

### Add Number

#### General Idea

The key point is to iterate and merge two LinkedList/Array. 

Mix of array and list, but they both have the same idea

#### Example Problems

{% page-ref page="../../all-problems/linkedlist/2.-add-two-numbers.md" %}

{% page-ref page="../../all-problems/linkedlist/445.-add-two-numbers-ii.md" %}

{% page-ref page="../../all-problems/linkedlist/66.-plus-one.md" %}

{% page-ref page="../../all-problems/two-pointers/67.-add-binary.md" %}

This is not the same idea. It is slow fast pointers

{% page-ref page="../../all-problems/linkedlist/369.-plus-one-linked-list.md" %}

### Partition

#### General Idea

After splitting, we need to do **post-processing** to make sure no cycle generated.

#### Example Problems

{% page-ref page="../../all-problems/linkedlist/86.-partition-list.md" %}

{% page-ref page="../../all-problems/linkedlist/328.-odd-even-linked-list.md" %}

### Remove

#### General Idea

A mix of array and LinkedList. But we both use **fast and slow pointer**

> **Attention**: Always deal with Last node. in case: it link to useless node, or it generate cycle.

#### Example Problems

{% page-ref page="../../all-problems/linkedlist/203.-remove-linked-list-elements.md" %}

{% page-ref page="../../all-problems/two-pointers/27.-remove-element.md" %}

{% page-ref page="../../all-problems/linkedlist/83.-remove-duplicates-from-sorted-list.md" %}

{% page-ref page="../../all-problems/linkedlist/82.-remove-duplicates-from-sorted-list-ii.md" %}

{% page-ref page="../../all-problems/two-pointers/26.-remove-duplicates-from-sorted-array.md" %}

{% page-ref page="../../all-problems/two-pointers/80.-remove-duplicates-from-sorted-array-ii.md" %}

### Merge

#### General Idea

谁小移谁

#### Example Problems

{% page-ref page="../../all-problems/linkedlist/21.-merge-two-sorted-lists.md" %}

{% page-ref page="../../all-problems/linkedlist/23.-merge-k-sorted-lists.md" %}

### Sort

{% page-ref page="../../all-problems/linkedlist/147.-insertion-sort-list.md" %}

{% page-ref page="../../all-problems/linkedlist/148.-sort-list.md" %}

### Reverse LinkedList

#### General Idea

* **Five pointers**

**prev**: points to previous node of reversed segment

**cur**: the head of current group to be reversed

**tail**: points to next node of reversed segment

**last**: points to last node of reversed segment

**dummy**: points to dummy previous node. Need it bc the head might be changed

We conceptually need these five pointers, but sometimes no need to define them explicitly. For example, when finishing traverse, we can get **tail** naturally

* **Four steps**

1. Reach **prev** node
2. Reverse nodes in iterative or recursive way
   1. Put node between **prev** and **first** one by one
3. Connect **last** with **tail** : `last.next = tail`
4. Update pointers especially for **prev** and **cur**

#### Example Problems

{% page-ref page="../../all-problems/linkedlist/206.-reverse-linked-list.md" %}

{% page-ref page="../../all-problems/linkedlist/92.-reverse-linked-list-ii.md" %}

{% page-ref page="../../all-problems/linkedlist/24.-swap-nodes-in-pairs.md" %}

{% page-ref page="../../all-problems/linkedlist/25.-reverse-nodes-in-k-group.md" %}

### Finding Middle Node

#### **General Idea**

There are several ways to initialize slow and fast, as well as multiple end loop check. Following one is the easiest one for almost all problems:

`fast = head.next` `fast != null && fast.next != null`

#### Example Problems

{% page-ref page="../../all-problems/linkedlist/234.-palindrome-linked-list.md" %}

{% page-ref page="../../all-problems/two-pointers/143.-reorder-list.md" %}

{% page-ref page="../../all-problems/tree/109.-convert-sorted-list-to-binary-search-tree.md" %}

### Finding specific node

#### **General Idea**

1. fast从head开始走k步
2. slow从head开始，一直走到head为null
3. 如果是删除该节点，则需要找到前一个节点，slow从dummy开始走即可

#### Example Problems

{% page-ref page="../../all-problems/linkedlist/19.-remove-nth-node-from-end-of-list.md" %}

{% page-ref page="../../all-problems/linkedlist/61.-rotate-list.md" %}

### Others

{% page-ref page="../../all-problems/linkedlist/160.-intersection-of-two-linked-lists.md" %}

{% page-ref page="../../all-problems/linkedlist/141.-linked-list-cycle.md" %}

[138. Copy List with Random Pointer](https://www.notion.so/138-Copy-List-with-Random-Pointer-84dd8d039da54f5caf35299adb9ba3a4) 

