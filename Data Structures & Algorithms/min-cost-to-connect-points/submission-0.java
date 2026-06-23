class Solution {
    public int minCostConnectPoints(int[][] points) {
        Set<String> visited = new HashSet<>();
        int[] initialPoint = points[0];
        String xyCoord = "%s,%s";
        String initPoint = String.format(xyCoord, initialPoint[0], initialPoint[1]);
        PriorityQueue<Pair> q = new PriorityQueue<>((p1, p2) -> p1.distance - p2.distance);
        q.offer(new Pair(0, initPoint));
        int minCost = 0;
        while(!q.isEmpty()) {
            Pair p = q.poll();
            if(visited.size() == points.length) {
                return minCost;
            }
            if(visited.contains(p.xyCoord)) {
                continue;
            }
            minCost += p.distance;
            visited.add(p.xyCoord);
            String[] arr = p.xyCoord.split(",");
            int x1 = Integer.parseInt(arr[0]);
            int y1 = Integer.parseInt(arr[1]);
            for(int[] point : points) {
                if(!visited.contains(String.format(xyCoord, point[0],point[1]))) {
                    q.add(new Pair(Math.abs(x1 - point[0]) + Math.abs(y1 - point[1]), String.format(xyCoord, point[0], point[1])));
                }
            }
        }
        return minCost;
    }

    class Pair {
        int distance;
        String xyCoord;

        Pair(int distance, String xyCoord) {
            this.distance = distance;
            this.xyCoord = xyCoord;
        }
    }
}
