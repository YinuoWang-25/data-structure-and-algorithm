# Module 3 PriorityQueue

### ListNode PriorityQueue

{% tabs %}
{% tab title="GoLang" %}
```go
package priorityqueue

import (
	"algorithms-in-go/src/problems/base"
)

type ListNode base.ListNode

type PriorityQueue []*ListNode

func (pq PriorityQueue) Len() int { return len(pq) }

func (pq PriorityQueue) Less(i, j int) bool {
	return pq[i].Val < pq[j].Val
}

func (pq PriorityQueue) Swap(i, j int) {
	pq[i], pq[j] = pq[j], pq[i]
}

func (pq *PriorityQueue) Push(x interface{}) {
	node := x.(*ListNode)
	*pq = append(*pq, node)
}

func (pq *PriorityQueue) Pop() interface{} {
	old := *pq
	lastNode := old[len(*pq)-1]
	*pq = old[:len(*pq)-1]
	return lastNode
}
```
{% endtab %}
{% endtabs %}

