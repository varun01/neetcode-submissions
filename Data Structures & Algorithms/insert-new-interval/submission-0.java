class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] temp = new int[intervals.length + 1][2];
        int index = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (newInterval[1] < intervals[i][0]) {
                temp[index][0] = newInterval[0];
                temp[index++][1] = newInterval[1];
                for (int j = i; j < intervals.length; j++) {
                    temp[index][0] = intervals[j][0];
                    temp[index++][1] = intervals[j][1];
                }
                int[][] res = new int[index][2];
                System.arraycopy(temp, 0, res, 0, index);
                return res;
            } else if (newInterval[0] > intervals[i][1]) {
                temp[index][0] = intervals[i][0];
                temp[index++][1] = intervals[i][1];
            } else {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }

        temp[index][0] = newInterval[0];
        temp[index++][1] = newInterval[1];
        int[][] res = new int[index][2];
        System.arraycopy(temp, 0, res, 0, index);
        return res;
    }
}
