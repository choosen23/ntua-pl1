import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.awt.Point;
import java.awt.geom.Point2D;
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
        HashMap<Point, Point> levelsHashMap = new HashMap<Point, Point>();

        // to append stin python kanei sinxoneusi sto telos tin listas
        // omoia me to frontier
        LinkedList<Point> frontier = new LinkedList<Point>();

        Point cat = new Point(-1, -1);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == 'W') {
                    frontier.add(new Point(i, j));
                    levelsHashMap.put(new Point(i, j), new Point(0,0));
                }
                if (grid[i][j] == 'A') {
                    cat = new Point(i, j);
                }
            }
        }


        
        LinkedList<Point> next = new LinkedList<Point>();

        int k = 1;
        // System.out.println(frontier);

        while (!frontier.isEmpty()) {

            next.removeAll(next);
            
            // System.out.println(frontier);
            while (!frontier.isEmpty()) {
                Point p = frontier.remove();
                int u = (int) p.getX();
                int v = (int) p.getY();
                Point ff = new Point(k,0);
                // System.out.println(p);
                System.out.println("vgike");
                System.out.println(p);
                System.out.println("menei");
                System.out.println(frontier);
                // down
                if (u < N - 1) { //deutero point == 1 
                    p.setLocation(u + 1, v);
                    ff.setLocation(k, 1);
                    System.out.println("down");
                    System.out.println(p);
                    System.out.println("-");
                    if (!levelsHashMap.containsKey(p) && (grid[u + 1][v] != 'X')) {
                        levelsHashMap.put(p, ff);
                        next.add(p);
                    }
                }
                // left
                if (v > 0) { //deutero point == 2
                    p.setLocation(u, v - 1);
                    ff.setLocation(k, 2);
                    System.out.println("left");
                    System.out.println(p);
                    System.out.println("-");
                    if (!levelsHashMap.containsKey(p) && (grid[u][v - 1] != 'X')) {
                        System.out.println("pireleft");
                        System.out.println(u);
                        System.out.println(v);
                        levelsHashMap.put(p, ff);
                        next.add(p);
                    }
                }
                System.out.println(next);
                // right
                if (v < M - 1) { //deutero point == 3
                    p.setLocation(u, v + 1);
                    ff.setLocation(k, 3);
                    System.out.println("right");
                    System.out.println(p);
                    System.out.println("-");
                    if (!levelsHashMap.containsKey(p) && (grid[u][v + 1] != 'X')) {
                        System.out.println("pireright");
                        System.out.println(u);
                        System.out.println(v+1);
                        levelsHashMap.put(p, ff);
                        next.add(p);
                    }
                }
                System.out.println(next);
                // up
                if (u > 0) { //deutero point == 4
                    p.setLocation(u - 1, v);
                    ff.setLocation(k, 4);
                    System.out.println("up");
                    System.out.println(p);
                    System.out.println("-");
                    if (!levelsHashMap.containsKey(p) && (grid[u - 1][v] != 'X')) {
                        levelsHashMap.put(p, ff);
                        next.add(p);
                    }
                }

            }

            frontier.addAll(next);
            System.out.println("uparxei");
            System.out.println(frontier);

            System.out.println("uparxei");
            System.out.println(levelsHashMap);
            k++;
        }

        // print grid
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }

    }

}