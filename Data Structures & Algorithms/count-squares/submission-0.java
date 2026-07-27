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
    
    public boolean onDiagonal(Point other) {
        if (Math.abs(other.x - this.x) == Math.abs(other.y - this.y) && !this.equals(other))
            return true;
        return false;
    }
}

class CountSquares {
    HashMap<Point, Integer> map;

    public CountSquares() {
        map = new HashMap<>();
    }
    
    public void add(int[] point) {
        Point p = new Point(point[0], point[1]);
        map.put(p, map.getOrDefault(p, 0) + 1);
    }
    
    public int count(int[] point) {
        Point p = new Point(point[0], point[1]);
        int res = 0;
        for (Map.Entry<Point, Integer> e : map.entrySet()) {
            if (p.onDiagonal(e.getKey())) {
                res += e.getValue() * map.getOrDefault(new Point(p.x, e.getKey().y), 0) * map.getOrDefault(new Point(e.getKey().x, p.y), 0);
            }
        }
        return res;
    }
}
