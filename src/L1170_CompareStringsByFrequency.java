// 1170. Compare Strings by Frequency of the Smallest Character

/*
1. we need to build a helper function to calculate f(s)

2. We have a bucket array, where  bucket[i] means how many words whose f(s) is i

3. Then we do pre-sum thing to bucket, which means that bucket[i] means how many words whose f(s) <= i

3. for every query, we calculate f(query) firstly, and then we would get number of words
whose f > f(query), so we can get by bucket[bucket.length - 1] - bucket[f(query)]

 */

public class L1170_CompareStringsByFrequency {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] fCount = new int[11];
        for (String word : words) fCount[getFCount(word)]++;

        for (int i = 1; i < fCount.length; i++) {
            fCount[i] += fCount[i - 1];
        }

        int[] res = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int count = getFCount(queries[i]);
            res[i] = fCount[fCount.length - 1] - fCount[count];
        }

        return res;
    }

    // get the frequency of smallest character
    private int getFCount(String word) {
        int[] count = new int[26];
        for (int i = 0; i < word.length(); i++) {
            count[word.charAt(i) - 'a']++;
        }
        for (int value : count) {
            if (value != 0) {
                return value;
            }
        }
        return 0;
    }
}
