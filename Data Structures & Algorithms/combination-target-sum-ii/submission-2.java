class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        return backtrack(candidates, 0, target);
    }

    public List<List<Integer>> backtrack(int[] candidates, int current, int target) {
        if (target < 0) {
            List<List<Integer>> res = new ArrayList<>();
            return res;
        }
        if (current == candidates.length) {
            List<List<Integer>> res = new ArrayList<>();
            if (target == 0) res.add(new ArrayList<>());
            return res;
        }
        if (current == candidates.length - 1) {
            List<List<Integer>> res = new ArrayList<>();
            if (target == 0) {
                res.add(new ArrayList<>());
            } else if (candidates[current] == target) {
                res.add(new ArrayList<>(Arrays.asList(candidates[current])));
            }
            return res;
        }

        List<List<Integer>> res = new ArrayList<>();
        for (List<Integer> l : backtrack(candidates, current+1, target - candidates[current])) {
            l.add(candidates[current]);
            res.add(l);
        }

        int nCurrent = current;
        while (nCurrent < candidates.length && candidates[nCurrent] == candidates[current])
            nCurrent++;

        for (List<Integer> l : backtrack(candidates, nCurrent, target)) {
            res.add(l);
        }

        return res;
    }
}
