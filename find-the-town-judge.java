class Solution {
    public int findJudge(int N, int[][] trust) {
        int[] trustedByCount = new int[N+1];
        Arrays.fill(trustedByCount, 0);
        // Count number of people trusting the referenced person
        for(int[] entry: trust) {
            int trustPersonId = entry[1];
            trustedByCount[trustPersonId]++;
        }
        int supposedJudgeId = 0;
        // Find the person trusted by all remaining people, if multiple, return -1.
        for(int i=1; i<trustedByCount.length;i++) {
            if (trustedByCount[i] == N-1) {
                if (supposedJudgeId == 0) {
                    supposedJudgeId = i;
                } else {
                    return -1;
                }
            }
        }
        // if none found, return -1, else check if the supposed Judge trusts anyone else.
        // an entry of 0 id is allowed, if any other trusted person is found for the judge return -1.
        if (supposedJudgeId == 0) return -1;
        for(int[] entry: trust) {
            if (entry[0] == supposedJudgeId && entry[1] != 0) return -1;
        }
        return supposedJudgeId;
    }
}