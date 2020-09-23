package todo;

public class QueueReconstructionHeight {
    // 406. Queue Reconstruction by Height
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> { return o1[0] != o2[0] ? o2[0] - o1[0] : o1[1] - o2[1]; });
        List<int[]> res = new LinkedList<>();
        for(int[] cur : people){
            res.add(cur[1],cur);
        }
        return res.toArray(new int[people.length][]);
    }
}
