class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<Node> q = new PriorityQueue<>((n1, n2) -> n1.distance - n2.distance);

        int m = 0;

        List<List<Node>> adjList = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int[] edge: times) {
            adjList.get(edge[0]).add(new Node(edge[2], edge[1]));
        }

        q.add(new Node(0, k));
        while(!q.isEmpty()) {
            Node node = q.poll();
            if(visited.contains(node.node)) {
                continue;
            }
            visited.add(node.node);
            m = Math.max(m, node.distance);

            for(Node neighbor : adjList.get(node.node)) {
                if(!visited.contains(neighbor.node)) {
                    q.add(new Node(node.distance + neighbor.distance, neighbor.node));
                }
            }
        }
        return visited.size() == n ? m : -1;
    }

    class Node {
        int distance;
        int node;
        Node(int distance, int node) {
            this.distance = distance;
            this.node = node;
        }
    }
}
