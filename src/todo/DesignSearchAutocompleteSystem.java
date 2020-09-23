package todo;

import java.util.*;
public class DesignSearchAutocompleteSystem {

    // 642. Design Search Autocomplete System
    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        int times = 0;
    }

    class Pair {
        String str;
        int times;
        public Pair(String str, int times) {
            this.str = str;
            this.times = times;
        }
    }

    String prefix;
    TrieNode root;
    TrieNode curSearchNode;

    public DesignSearchAutocompleteSystem(String[] sentences, int[] times) {
        prefix = "";
        root = new TrieNode();
        curSearchNode = root;
        for(int i = 0; i < sentences.length; i++) {
            addSentence(sentences[i], times[i]);
        }
    }

    public void addSentence(String word, int count) {
        TrieNode cur = root;
        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if(!cur.children.containsKey(c))
                cur.children.put(c, new TrieNode());
            cur = cur.children.get(c);
        }
        cur.times += count;
    }

    public List<String> input(char c) {
        List<String> list = new ArrayList<>();
        if(c == '#') {
            addSentence(prefix, 1);
            prefix = "";
            curSearchNode = root;
            return list;
        }

        List<Pair> pairList = new ArrayList<>();
        prefix += c;
        if (curSearchNode != null)
            curSearchNode = curSearchNode.children.get(c);

        dfs(curSearchNode, pairList, prefix);

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->(a.times!=b.times?a.times-b.times:b.str.compareTo(a.str)));
        for(Pair p: pairList) {
            pq.offer(p);
            if(pq.size()>3)
                pq.poll();
        }
        while (!pq.isEmpty()) {
            list.add(pq.poll().str);
        }

        Collections.reverse(list);
        return list;
    }

    public void dfs(TrieNode cur, List<Pair> pairList, String prefix)
    {
        if (cur == null) return;
        if (cur.times > 0) {
            pairList.add(new Pair(prefix, cur.times));
        }

        for (char c:cur.children.keySet()) {
            dfs(cur.children.get(c), pairList, prefix+c);
        }
    }
}
