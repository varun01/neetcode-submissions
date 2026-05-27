class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            union(edge[0], edge[1], parent, rank);
        }

        Set<Integer> set = new HashSet<>();
        for (int p : parent) {
            set.add(findRoot(p, parent));
        }
        return set.size();
    }

    public void union(int x, int y, int[] parent, int[] rank) {
        int rootX = findRoot(x, parent);
        int rootY = findRoot(y, parent);
        if (rootY == rootX) {
            return;
        }

        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
    }

    public int findRoot(int node, int[] parent) {
        if (parent[node] != node) {
            parent[node] = findRoot(parent[node], parent);
        }
        return parent[node];
    }
}
