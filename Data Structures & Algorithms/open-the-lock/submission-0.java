class Solution {
    public int openLock(String[] deadends, String target) {
        List<String> deadendList = List.of(deadends);
        if (deadendList.contains("0000")) {
            return -1;
        }
        Set<String> set = new HashSet<>(Arrays.asList(deadends));

        Deque<Pair> queue = new LinkedList<>();
        queue.offerLast(new Pair("0000", 0));
        while (!queue.isEmpty()) {
            Pair p = queue.pollFirst();
            if(p.lock.equals(target)) {
                return p.count;
            }
            for (String s : buildLocks(p.lock)) {
                if(!set.contains(s)) {
                    set.add(s);
                    queue.offerLast(new Pair(s, p.count + 1));
                }
            }
        }
        return -1;
    }

    public String[] buildLocks(String lock) {
        List<String> strArr = new ArrayList<>();
        char[] arr = null;
        for (int i = 0; i < lock.length(); i++) {
            arr = lock.toCharArray();
            int digit = Character.getNumericValue(arr[i]);
            digit = (digit + 1) % 10;
            arr[i] = Character.forDigit(digit, 10);
            strArr.add(String.valueOf(arr));
            arr = lock.toCharArray();
            digit = Character.getNumericValue(arr[i]);
            digit = (digit -1 + 10) % 10;
            arr[i] = Character.forDigit(digit, 10);
            strArr.add(String.valueOf(arr));
        }
        return strArr.toArray(new String[0]);
    }

    class Pair {

        String lock;
        int count;

        Pair(String lock, int count) {
            this.lock = lock;
            this.count = count;
        }

    }
}