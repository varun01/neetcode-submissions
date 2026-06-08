class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Node>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] flight : flights) {
            adjList.get(flight[0]).add(new Node(flight[1], flight[2], 0));
        }
        PriorityQueue<Node> q = new PriorityQueue<>((n1, n2) -> n1.distance - n2.distance);
        q.add(new Node(src, 0, 0));
        int[] minStops = new int[n];
        Arrays.fill(minStops, Integer.MAX_VALUE);
        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node.stops >= minStops[node.city]) {
                continue;
            }
            minStops[node.city] = Math.min(minStops[node.city], node.stops);
            if (node.city == dst) {
                return node.distance;
            }
            for (Node neighbor : adjList.get(node.city)) {
                if (node.stops <= k) {
                    q.add(new Node(neighbor.city, neighbor.distance + node.distance, node.stops + 1));
                }
            }
        }
        return -1;
    }

    class Node {

        int city;
        int distance;
        int stops;

        Node(int city, int distance, int stops) {
            this.city = city;
            this.distance = distance;
            this.stops = stops;
        }

    }
}
