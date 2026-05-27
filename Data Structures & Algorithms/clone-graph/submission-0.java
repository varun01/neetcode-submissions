/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) {
            return node;
        }
        HashMap<Node, Node> oldNewMap = new HashMap<>();
        return dfs(node, oldNewMap);
    }

    public Node dfs(Node node, HashMap<Node, Node> map) {
        if(map.containsKey(node)) {
            return map.get(node);
        }
        
        Node newCopy = new Node(node.val);
        map.put(node, newCopy);
        for(Node n : node.neighbors) {
            newCopy.neighbors.add(dfs(n, map));
        }
        return newCopy;
    }
}