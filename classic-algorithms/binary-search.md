# Binary Search

### General Ideas

注意binary search的前提条件是有序

是什么： binary search

为什么：每次删掉不必要搜索的range

本质：1. 不断减小搜索空间 2. 确保return value在剩余的搜索空间里

前提条件： 需要搜索的array等是逻辑有序的，注意不一定是升序或者降序

做题的trick：考虑1. 无重复 （防止死循环） 2. 无遗漏 （不要多删除搜索空间）3. 判断如何移动左右指针时考虑当前元素是否应该被删除

_**会导致死循环的原因： 当只剩两个元素时，在某种条件下有left = mid**_

两类写法：

1. 搜索到最后

a. binary search

b. search in 2D matrix

d. Smallest element that is larger than target element

1. 搜索一个range出来做post-processing

a. Closest Element to Target

b. First target

c. Last Target

d. Smallest element that is larger than target element

e. Closest k elements \(两种solution\)

1. 纯binary search 思想

K-th smallest element in two sorted arrays

总结，找相等或者找不等都可以用classic写法，找first 或者last还是用range方法好

### 三种写法

binary search的基础写法中\*\*， 结束循环后，low表示第一个大于的元素，high表示最后一个小于的元素\*\*

**binary的另一种写法是：循环条件为 left &lt; right, 注意这种情况的变动一定不可以是 left = mid， 不然会造成死循环。适用于right也可能是答案的情况**

**如果left 可能是答案，则在计算 mid的时候使用 mid = right - \(right - left\) / 2;**

## Problems

### Basic

{% page-ref page="../all-problems/binary-search/35.-search-insert-position.md" %}

{% page-ref page="../all-problems/374.-guess-number-higher-or-lower.md" %}

{% page-ref page="../all-problems/binary-search/34.-find-first-and-last-position-of-element-in-sorted-array.md" %}

{% page-ref page="../all-problems/binary-search/69.-sqrt-x.md" %}

{% page-ref page="../all-problems/binary-search/367.-valid-perfect-square.md" %}

{% page-ref page="../all-problems/binary-search/74.-search-a-2d-matrix.md" %}

{% page-ref page="../all-problems/binary-search/240.-search-a-2d-matrix-ii.md" %}

{% page-ref page="../all-problems/binary-search/162.-find-peak-element.md" %}

{% page-ref page="../all-problems/1060.-missing-element-in-sorted-array.md" %}



1. H-Index II
2. Number of Matching Subsequences

如果是判断一个string是否是另一个string的subsequence， 可以直接two pointer check，但是如果是很多个string就要考虑用二分法进行优化

1. Count Complete Tree Nodes
2. Random Pick with Weight
3. Heaters
4. Median of Two Sorted Arrays

### In Rotate array

1. Search in Rotated Sorted Array
2. Search in Rotated Sorted Array II
3. Find Minimum in Rotated Sorted Array
4. Find Minimum in Rotated Sorted Array II

### 用value做二分法的边界

1. Longest Increasing Subsequence

这道题主要综合了binary search 和 bucket sort的思路。

创建一个和原数组长度相同的数组，这个数组相当于是buckets，每个bucket中的元素的物理意义是 长度为i的LIS的最小结尾的元素是多少。

对于每一个checking的元素，二分法找到buckets中第一个大于它的数字进行替换。

1. Russian Doll Envelopes

对长进行排序后，找以宽为元素的LIS

1. Kth Smallest Element in a Sorted Matrix
2. Find the Duplicate Number
3. Split Array Largest Sum

这三道题都用 binary search 的第二种写法

1. Find K-th Smallest Pair Distance

