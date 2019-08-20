import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.*; 

import java.util.HashMap;

public class Savethecat {

  public static void main (String[] args) throws Exception {
	  FileReader fileReader = new FileReader(args[0]);
      BufferedReader bufferedReader = new BufferedReader(fileReader);
      List<char []> lines = new ArrayList<char []>();
      String line = null;
      int N = 0;
      int M = 0;
      while ((line = bufferedReader.readLine()) != null) {
          if (N == 0) {
        	  M = (int)line.length();
          }
    	  lines.add(line.toCharArray());
          N++;
      }
      bufferedReader.close();
      //Telos diavasmata

      char[][] grid = lines.toArray(new char[lines.size()][]);
      
    //   int[][] depth = new int[1000][1000];      
    //   Queue<Point> q = new LinkedList<>();
    //   Queue<Point> stars = new LinkedList<>();


      //omoia me to level = dict()
      HashMap<Point, Integer> levelsHashMap = new HashMap<Point, Integer>();

      //to append stin python kanei sinxoneusi sto telos tin listas
      //omoia me to frontier
      ArrayList<Point> frontier = new ArrayList<Point>();


      Point cat = new Point(-1, -1);

      for (int i = 0; i < N; i++) {
    	  for (int j = 0; j < M; j++) {
    		  if (grid[i][j] == 'W') {
                  frontier.add(new Point(i, j));
                  levelsHashMap.put(new Point( i, j), 0);
              } 
              if (grid[i][j] == 'A') {
                  cat = new Point(i ,j);
              }
    	  }
      }


      
      HashMap<Point, Integer> floodTime= new HashMap<Point, Integer>();
      ArrayList<Point> next = new ArrayList<Point>();
      
      
      int k = 1;
    //   System.out.println(frontier);
   
      for (int i=0; i < frontier.size(); i++ ) {

        Point p = new Point();
        p = frontier.get(i);
        int u = (int)p.getX();
        int v = (int)p.getY();
       // System.out.println(p);


        //down
        if (u < N-1) {
            p.setLocation(u+1,v);
            if (  !levelsHashMap.containsKey(p) && (grid[u+1][v] != 'X') ) {
                levelsHashMap.put(p,k);
                next.add(p);
            }
        }
        //left
        if (v > 0) {
            p.setLocation(u,v-1);
            if (  !levelsHashMap.containsKey(p) && (grid[u][v-1] != 'X') ) {
                levelsHashMap.put(p, k);
                next.add(p);
            }
        }
        //right
        if (v < M-1) {
            p.setLocation(u,v+1);
            if (  !levelsHashMap.containsKey(p) && (grid[u][v+1] != 'X') ) {
                levelsHashMap.put(p,k);
                next.add(p);
            }
        }
        //up
        if (u > 0) {
            p.setLocation(u-1,v);
            if ( !levelsHashMap.containsKey(p) && (grid[u-1][v] != 'X') ) {
                levelsHashMap.put(p,k);
                next.add(p);
            }
        }

        System.out.println(next);

        for(int j=0; j<next.size(); j++) {
            Point tmp = new Point();
            tmp = next.get(j);
            frontier.add(tmp);
        }
        k++;
      }

     
      System.out.println('x');
      System.out.println(levelsHashMap);
      System.out.println('x');

      
 
    floodTime = (HashMap<Point, Integer>)levelsHashMap.clone();
    
    System.out.println('x');
    System.out.println(floodTime);




















      

          // print grid
      for (int i = 0; i < N; i++) {
    	  for (int j = 0; j < M; j++) {
    	  System.out.print(grid[i][j]);
    	  }
    	  System.out.println();
      }







  }



}