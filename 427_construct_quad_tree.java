// https://leetcode.com/problems/construct-quad-tree/
// Runtime 1 ms Beats 71.9%
// Memory 42.6 MB Beats 56.51%

/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;


    public Node() {
        this(false, false);
    }

    public Node(boolean val, boolean isLeaf) {
        this(val, isLeaf, null, null, null, null);
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

class Solution {
    public Node construct(int[][] grid) {
        return helper(grid, 0, grid[0].length-1, 0, grid.length-1);
    }

    Node helper(int[][] grid, int x0, int x1, int y0, int y1) {
        if (x0 == x1 && y0 == y1) {
            return new Node(grid[y0][x0]==1, true); // specific val & leaf
        }

        Node tl = helper(grid, x0, (x0+x1)/2, y0, (y0+y1)/2);
        Node tr = helper(grid, (x0+x1+1)/2, x1, y0, (y0+y1)/2);
        Node bl = helper(grid, x0, (x0+x1)/2, (y0+y1+1)/2, y1);
        Node br = helper(grid, (x0+x1+1)/2, x1, (y0+y1+1)/2, y1);

        if (tl.isLeaf && tr.isLeaf && bl.isLeaf && br.isLeaf
                && tl.val == tr.val && tl.val == bl.val && tl.val == br.val) {
            return new Node(tl.val, true);
        }

        return new Node(false, false, tl, tr, bl, br);
    }
}
