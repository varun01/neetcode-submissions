class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int[] edge : prerequisites) {
            adjacencyList.get(edge[0]).add(edge[1]);
        }

        int[] state = new int[numCourses];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0) {
                if (dfs(i, state, adjacencyList, stack)) {
                    return new int[0];
                }
            }
        }
        int[] arr = new int[stack.size()];
        int i = 0;
        while(!stack.isEmpty()) {
            arr[i++] = stack.pollLast();
        }
        return arr;
    }

    public boolean dfs(int node, int[] state, List<List<Integer>> adjacencyList, Deque<Integer> stack) {
        state[node] = 1;
        for (int neighbor : adjacencyList.get(node)) {
            if (state[neighbor] == 1) {
                return true;
            }
            if (state[neighbor] == 0) {
                if (dfs(neighbor, state, adjacencyList, stack)) {
                    return true;
                }
            }
        }

        state[node] = 2;
        stack.push(node);
        return false;
    }
}
