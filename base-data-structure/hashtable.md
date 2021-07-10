# Module 4 HashTable

## General Ideas

### Set

主要作用是check存不存在

### Map

主要作用是group跟key有关的value

注意当set或者map的作用是counter的时候，可以考虑用数组代替

## Problems

### Map Basis

Group Anagrams

HashMap 的基本用法。 同一个key用来统一一些values

1. Group Shifted Strings

跟上一道题思路相同

1. Logger Rate Limiter
2. Design Hit Counter
3. Keyboard Row
4. Word Pattern

用map的映射关系来判断存在性

1. Unique Word Abbreviation

用map的映射关系来判断存在性

1. Isomorphic Strings
2. Image Overlap
3. Hand of Straights

先统计每个数字的频率，然后从小到大，验证每个数字为首位是否可以组成hands

1. Minimum Area Rectangle
2. Longest String Chain
3. Number of Ways Where Square of Number Is Equal to Product of Two Numbers
4. Verifying an Alien Dictionary

### Contains Duplicate

{% page-ref page="../all-problems/hashset/217.-contains-duplicate.md" %}

{% page-ref page="../all-problems/hashset/219.-contains-duplicate-ii.md" %}



1. Contains Duplicate III

### Intersection of Two Arrays

1. Intersection of Two Arrays

解法1: 可以用Set 存储说有出现过的element，做对比

解法2 ： sort以后进行双指针

1. Intersection of Two Arrays II

解法1: 用HashMap 保存每个数字出现的次数，然后进行对比

解法2: sort后用双指针的思想

### Set Basis

1. Ransom Note

统计个数，所以可以用数组代替

1. First Unique Character in a String

这道题是set的基本用法，可以用一个set来存储所有unique character。

可以用数组代替

1. Longest Palindrome

跟上道题相似，set里面存储所有出现次数为odd的 character

1. Repeated DNA Sequences

统计个数问题

解法一： 用map统计每个substring的出现个数，然后check出现不止一次的加入结果中

解法二： 用两个set，一个用来保存所有出现过的string，另一个用来保存重复出现过的string，也就是结果集合

