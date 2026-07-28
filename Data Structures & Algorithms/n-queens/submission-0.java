class Point {
    int x;
    int y;
    public Point(int x, int y) {this.x = x; this.y = y;}

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point p = (Point) o;
        return x == p.x && y == p.y;
    }

    public int hashCode() {return Objects.hash(x, y);}
    public String toString() {return "[" + x + ", " + y + "]";}
}

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        for (HashSet<Point> s : backtrack(n, new HashSet<Point>(), 0)) {
            List<String> board = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String row = "";
                for (int j = 0; j < n; j++) {
                    if (s.contains(new Point(i, j))) row += "Q";
                    else row += ".";
                }
                board.add(row);
            }
            res.add(board);
        }
        return res;
    }

    public List<HashSet<Point>> backtrack(int n, HashSet<Point> cur, int startI) {
        //System.out.println(cur.size());
        if (!isBoardValid(n, cur)) {
            List<HashSet<Point>> res = new ArrayList<>();
            return res;
        }
        if (cur.size() == n) {
            List<HashSet<Point>> res = new ArrayList<>();
            res.add(new HashSet<>(cur));
            return res;
        }

        List<HashSet<Point>> res = new ArrayList<>();
        HashSet<Point> current = new HashSet<>(cur);

        for (int i = startI; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (current.contains(new Point(i, j))) continue;

                current.add(new Point(i, j));
                for (HashSet<Point> s : backtrack(n, current, i)) {
                    if (isBoardValid(n, s)) {
                        res.add(s);
                    }
                }
                current.remove(new Point(i, j));
            }
        }
        return res;
    }

    public boolean isBoardValid(int n, HashSet<Point> current) {
        for (Point p1 : current) {
            for (Point p2 : current) {
                if (p1.equals(p2)) continue;

                if (p1.x == p2.x) return false;
                if (p1.y == p2.y) return false;
                if (Math.abs(p1.x - p2.x) == Math.abs(p1.y - p2.y)) return false;
            }
        }
        //for (Point p : current) System.out.print(p + " ");
        //System.out.println();
        return true;
    }
}
