class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> emailToIndex = new HashMap<>();
        Map<Integer, String> indexToName = new HashMap<>();
        int index = 0;
        for (int i = 0; i < accounts.size(); i++) {
            List<String> account = accounts.get(i);
            indexToName.put(index, account.get(0));
            for (int j = 1; j < account.size(); j++) {
                if (!emailToIndex.containsKey(account.get(j))) {
                    emailToIndex.put(account.get(j), index++);
                }
            }
        }
        int[] parent = new int[emailToIndex.size()];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        int[] rank = new int[parent.length];
        for (List<String> acc : accounts) {
            if (acc.size() <= 2) {
                unionFind(emailToIndex.get(acc.get(1)), emailToIndex.get(acc.get(1)), parent, rank);
            } else {
                for (int i = 2; i < acc.size(); i++) {
                    unionFind(emailToIndex.get(acc.get(1)), emailToIndex.get(acc.get(i)), parent, rank);
                }
            }
        }

        Map<Integer, List<String>> map = new HashMap<>();
        emailToIndex.forEach((k, v) -> {
            int root = findParent(v, parent);
            if (map.containsKey(root)) {
                map.get(root).add(k);
            } else {
                map.put(root, new ArrayList<>(List.of(k)));
            }
        });

        List<List<String>> result = new ArrayList<>();
        map.forEach((k, emails) -> {
            Collections.sort(emails);
            emails.add(0, indexToName.get(k));
            result.add(emails);
        });
        return result;
    }

    public void unionFind(int x, int y, int[] parent, int[] rank) {
        int rootX = findParent(x, parent);
        int rootY = findParent(y, parent);
        if (rootY == rootX) {
            return;
        }

        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootY] < rank[rootX]) {
            parent[rootY] = rootX;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
    }

    public int findParent(int x, int[] parent) {
        if (parent[x] != x) {
            parent[x] = findParent(parent[x], parent);
        }
        return parent[x];
    }
}