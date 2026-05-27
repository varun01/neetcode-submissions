class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, Set<Character>> box = new HashMap<>();
        HashMap<Integer, Set<Character>> rows = new HashMap<>();
        HashMap<Integer, Set<Character>> cols = new HashMap<>();

        for (int i = 0; i < 9; i++) {
            rows.put(i, new HashSet<>());
            cols.put(i, new HashSet<>());
            box.put(i, new HashSet<>());
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    continue;

                char num = board[i][j];
                int boxId = (i / 3) * 3 + j / 3;
                if (rows.get(i).contains(num)
                        || cols.get(j).contains(num)
                        || box.get(boxId).contains(num)) {
                    return false;
                }
                rows.get(i).add(num);
                cols.get(j).add(num);
                box.get(boxId).add(num);

            }
        }
        return true;
    }
}
