class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int vertices = edges.length + 1;
        int[] parent = new int[vertices];
        int[] rank = new int[vertices];
        for (int i = 1; i < vertices; i++) {
            parent[i] = i;
        }
        int[] res = new int[2];
        for (int[] edge : edges) {
            union(edge[0], edge[1], parent, rank, res);
        }
        return res;
    }

    public void union(int start, int end, int[] parent, int[] rank, int[] res) {
        int startRoot = findParent(start, parent);
        int endRoot = findParent(end, parent);
        if (startRoot == endRoot) {
            res[0] = start;
            res[1] = end;
        }

        if (rank[startRoot] < rank[endRoot]) {
            parent[startRoot] = endRoot;
        } else if (rank[startRoot] > rank[endRoot]) {
            parent[endRoot] = startRoot;
        } else {
            parent[endRoot] = startRoot;
            rank[startRoot]++;
        }
    }

    public int findParent(int x, int[] parent) {
        if (parent[x] != x) {
            parent[x] = findParent(parent[x], parent);
        }
        return parent[x];
    }
}
