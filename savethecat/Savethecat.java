import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.awt.Point;
import java.util.*;

public class Savethecat {

    public static void main(String[] args) throws Exception {
        FileReader fileReader = new FileReader(args[0]);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<char[]> lines = new ArrayList<char[]>();
        String line = null;
        int N = 0;
        int M = 0;
        while ((line = bufferedReader.readLine()) != null) {
            if (N == 0) {
                M = (int) line.length();
            }
            lines.add(line.toCharArray());
            N++;
        }
        bufferedReader.close();
        // Telos diavasmata

        char[][] grid = lines.toArray(new char[lines.size()][]);

        // int[][] depth = new int[1000][1000];
        // Queue<Point> q = new LinkedList<>();
        // Queue<Point> stars = new LinkedList<>();

        // omoia me to level = dict()
        HashMap<Point, Integer> levelsHashMap = new HashMap<Point, Integer>();

        // to append stin python kanei sinxoneusi sto telos tin listas
        // omoia me to frontier
        LinkedList<Point> frontier = new LinkedList<Point>();

        Point cat = new Point(-1, -1);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == 'W') {
                    frontier.add(new Point(i, j));
                    levelsHashMap.put(new Point(i, j), 0);
                }
                if (grid[i][j] == 'A') {
                    cat = new Point(i, j);
                }
            }
        }

        LinkedList<Point> next = new LinkedList<Point>();
        int k = 1;

        while (!frontier.isEmpty()) {

            next.removeAll(next);

            while (!frontier.isEmpty()) {
                Point p = frontier.remove();
                int u = (int) p.getX();
                int v = (int) p.getY();

                // down
                if (u < N - 1) { // deutero point == 1
                    Point l = new Point(u + 1, v);
                    if (!levelsHashMap.containsKey(l) && (grid[u + 1][v] != 'X')) {
                        levelsHashMap.put(l, k);
                        next.add(l);
                    }
                }
                // left
                if (v > 0) {
                    Point m = new Point(u, v - 1);
                    if (!levelsHashMap.containsKey(m) && (grid[u][v - 1] != 'X')) {
                        levelsHashMap.put(m, k);
                        next.add(m);
                    }
                }
                // right
                if (v < M - 1) {
                    Point n = new Point(u, v + 1);
                    if (!levelsHashMap.containsKey(n) && (grid[u][v + 1] != 'X')) {
                        levelsHashMap.put(n, k);
                        next.add(n);
                    }
                }
                // up
                if (u > 0) {
                    Point o = new Point(u - 1, v);
                    if (!levelsHashMap.containsKey(o) && (grid[u - 1][v] != 'X')) {
                        levelsHashMap.put(o, k);
                        next.add(o);
                    }
                }
            }
            frontier.addAll(next);
            k++;
        }
        System.gc();
        // System.out.println(frontier);
        // System.out.println("~");
        // System.out.println(next);
        // System.out.println("~");
        // System.out.println(levelsHashMap);
        // System.out.println("~");

        // HashMap<Point,Integer> floodTime = new HashMap<Point,Integer>();

        // infinity == MIN_VALUE
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Point p = new Point(i, j);
                if (!levelsHashMap.containsKey(p) && grid[i][j] != 'X') {
                    levelsHashMap.put(p, Integer.MIN_VALUE);
                }
            }
        }
        System.gc();

        HashMap<Point, Integer> safeTime = new HashMap<Point, Integer>();
        HashMap<Point, Point> parent = new HashMap<Point, Point>();
        parent.put(cat, new Point(-1, -1));
        HashMap<Point, Integer> level = new HashMap<Point, Integer>();
        level.put(cat, 0);
        int maxTime = -1;
        Point Target = new Point(-1, -1);
        frontier.removeAll(frontier);
        frontier.add(cat);
        int i = 1;

        while (!frontier.isEmpty()) {
            next.removeAll(next);
            while (!frontier.isEmpty()) {
                Point p = frontier.remove();
                int u = (int) p.getX();
                int v = (int) p.getY();

                if (levelsHashMap.get(p) == Integer.MIN_VALUE) {
                    maxTime = Integer.MIN_VALUE;
                    Target = p;
                } else if (levelsHashMap.get(p) > maxTime + 1) {
                    maxTime = levelsHashMap.get(p) - 1;
                    Target = p;
                }
                Point Down = new Point(u + 1, v);
                Point Left = new Point(u, v - 1);
                Point Right = new Point(u, v + 1);
                Point Up = new Point(u - 1, v);

                if (!level.containsKey(Down) && Down.getX() < N && grid[(int) Down.getX()][(int) Down.getY()] != 'X'
                        && (levelsHashMap.get(Down) == Integer.MIN_VALUE || levelsHashMap.get(Down) > i)
                        && maxTime != Integer.MIN_VALUE) {
                    level.put(Down, i);
                    parent.put(Down, p);
                    next.add(Down);
                }
                if (!levelsHashMap.containsKey(Left) && Left.getY() >= 0
                        && grid[(int) Left.getX()][(int) Left.getY()] != 'X'
                        && (levelsHashMap.get(Left) == Integer.MIN_VALUE || levelsHashMap.get(Left) > i)) {
                    level.put(Left, i);
                    parent.put(Left, p);
                    next.add(Left);
                }
                if (!levelsHashMap.containsKey(Right) && Right.getY() < M
                        && grid[(int) Right.getX()][(int) Right.getY()] != 'X'
                        && (levelsHashMap.get(Right) == Integer.MIN_VALUE || levelsHashMap.get(Right) > i)
                        && maxTime != Integer.MIN_VALUE) {
                    level.put(Right, i);
                    parent.put(Right, p);
                    next.add(Right);
                }
                if (!levelsHashMap.containsKey(Up) && Up.getX() >= 0 && grid[(int) Up.getX()][(int) Up.getY()] != 'X'
                        && (levelsHashMap.get(Up) == Integer.MIN_VALUE || levelsHashMap.get(Up) > i)) {
                    level.put(Up, i);
                    parent.put(Up, p);
                    next.add(Up);
                }

            }
            frontier.addAll(next);
            k++;
        }
        if (maxTime == Integer.MIN_VALUE)
            System.out.println("infinity");
        else
            System.out.println(maxTime);

        Point tr = new Point(-1, -1);

        if (Target == cat)
            System.out.println("stay");
        else {
            String ans = " ";
            while (parent.get(Target) != tr) {
                if (parent.get(Target).getX() == Target.getX() - 1) {
                    ans = 'D' + ans;
                    Target = parent.get(Target);
                }
                else if (parent.get(Target).getY() == Target.getY() + 1) {
                    ans = 'U' + ans;
                    Target = parent.get(Target);
                }
                else if (parent.get(Target).getY() == Target.getY() - 1) {
                    ans = 'R' + ans;
                    Target = parent.get(Target);
                }
                else if (parent.get(Target).getX() == Target.getX() + 1) {
                    ans = 'U' + ans;
                    Target = parent.get(Target);
                }

            }

            System.out.println(ans);

        }

    }

}