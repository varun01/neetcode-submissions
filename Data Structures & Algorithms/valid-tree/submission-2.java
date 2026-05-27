class Solution {
    public boolean validTree(int n, int[][] edges) {
        int[] parent = new int[n];
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        boolean flag = true;
        for(int[] edge :edges) {
            flag = unionFind(edge[0], edge[1], parent, rank);
            if(!flag) {
                return false;
            }
        }
        for(int i =0 ;i < n ; i++ ) {
            parent[i] = findParent(parent[i], parent);
        }
        Set<Integer> set = new HashSet<>();
        for (int i : parent) {
            set.add(i);
        }
        return set.size() > 1 ? false : true;
    }

    public boolean unionFind(int x, int y, int[] parent, int[] rank) {
        int xRoot = findParent(x, parent);
        int yRoot = findParent(y, parent);

        if (xRoot == yRoot) {
            return false;
        }

        if (rank[xRoot] < rank[yRoot]) {
            parent[xRoot] = yRoot;
        } else if (rank[xRoot] > rank[yRoot]) {
            parent[yRoot] = xRoot;
        } else {
            parent[yRoot] = xRoot;
            rank[xRoot]++;
        }
        return true;
    }

    public int findParent(int x, int[] parent) {
        if (parent[x] != x) {
            parent[x] = findParent(parent[x], parent);
        }
        return parent[x];
    }
}
