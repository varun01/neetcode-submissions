class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int[] edge : prerequisites) {
            adjacencyList.get(edge[0]).add(edge[1]);
        }

        int[] state = new int[numCourses];
        //        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0) {
                if (dfs(i, state, adjacencyList)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean dfs(int node, int[] state, List<List<Integer>> adjacencyList) {
        state[node] = 1;
        for (int neighbor : adjacencyList.get(node)) {
            if (state[neighbor] == 1) {
                return true;
            }
            if (state[neighbor] == 0) {
                if (dfs(neighbor, state, adjacencyList)) {
                    return true;
                }
            }
        }

        state[node] = 2;
        //        stack.push(node);
        return false;
    }
}
