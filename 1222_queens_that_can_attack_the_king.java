// https://leetcode.com/problems/queens-that-can-attack-the-king/
// Runtime 0 ms Beats 100%
// Memory 42.6 MB Beats 81.76%

class Solution {
    final int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}, {-1,-1}, {-1,1}, {1,1}, {1,-1}};

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> result = new ArrayList();

        for (int[] dir : dirs) {
            List<Integer> q = checkDir(dir, queens, king);
            if (q != null) result.add(q);
        }

        return result;
    }

    private List<Integer> checkDir(int[] dir, int[][] queens, int[] king) {
        int x = king[0] + dir[0];
        int y = king[1] + dir[1];

        while (x >= 0 && x < 8 && y >= 0 && y < 8) {
            // could sort queens and binary search but there's only 64 max
            for (int[] queen : queens)
                if (queen[0] == x && queen[1] == y)
                    return List.of(queen[0], queen[1]);
            x += dir[0]; y += dir[1];
        }

        return null;
    }
}
