# Two Pointers

### General Ideas

two pointer一般分为在两个input中进行比较和在一个string/array 中进行比较

### Problems

### 同向指针

#### 快慢指针

{% page-ref page="../all-problems/two-pointers/75.-sort-colors.md" %}

{% page-ref page="../all-problems/two-pointers/283.-move-zeroes.md" %}

{% page-ref page="../all-problems/two-pointers/58.-length-of-last-word.md" %}



1. Read N Characters Given Read4

是下一道题的副产品

1. Read N Characters Given Read4 II - Call multiple times
2. Sentence Screen Fitting
3. Reverse Words in a String
4. Reverse Words in a String II
5. Shortest Way to Form String

#### 逐个比较

{% page-ref page="../all-problems/two-pointers/88.-merge-sorted-array.md" %}



1. Intersection of Two Arrays II

谁小移谁的思想

1. Compare Version Numbers

需要注意post-compare的比较，即如果元素长度不同

1. Shortest Word Distance

每次找到word1或者word2时都跟上一次找到的另一个word相比较

1. Shortest Word Distance II

把所有的位置都列出来，逐个比较

1. Shortest Word Distance III

这道题比较tricky，跟 I 思路相同，但是因为这两个元素可能相同，所以我们只保存一个prev 指针指向前一个找到的元素。当找到新元素时，我们check前一个元素的值：

word1 same as word 2: 可以做比较

word 1 不同于 word2， prev指向的word跟当前word不同，可以比较

#### Group元素再做操作

**跑到满足比较条件的位置，比较并作出判断**

1. Swap Adjacent in LR String
2. Is Subsequence
3. Valid Word Abbreviation
4. Assign Cookies
5. Expressive Words

不满足的条件：

两组之间没有expresss关系但是长度不一样

可能存在express关系但是expressive的长度较短

1. Backspace String Compare

group终止的条件： 当年character不是”\#” 并且没有累计的\#了

循环继续的条件： i &gt;= 0 && j &gt;= 0 && S.charAt\(i\) == T.charAt\(j\)

1. Count and Say
2. Number of Segments in a String
3. Minimum Deletion Cost to Avoid Repeating Letters

Add series

1. Add Binary
2. Add Strings

#### 其他

1. Implement strStr\(\)

### 相向指针

{% page-ref page="../all-problems/two-pointers/344.-reverse-string.md" %}

{% page-ref page="../all-problems/two-pointers/345.-reverse-vowels-of-a-string.md" %}

三步反转法

{% page-ref page="../all-problems/125.-valid-palindrome.md" %}

{% page-ref page="../all-problems/189.-rotate-array.md" %}

{% page-ref page="../all-problems/246.-strobogrammatic-number.md" %}



1. Sort Transformed Array

