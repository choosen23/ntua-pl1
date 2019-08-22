import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.*;



public static class Grid {
    public int deathTIme = -1;
    public int catTime = -1;
    public char symbol;
    public String seq;
    public boolean visited = false;
    public boolean catVisited = false;


    public Grid(int dt, int ct, char s, String seq, boolean v, boolean cv) {
        this.deathTIme = dt;
        this.catTime = ct;
        this.symbol = s;
        this.seq = seq;
        this.visited = v;
        this.catVisited = cv;
    }
}

public class cell {
    public int row;
    public int column;
    public int time;

    public cell(int r, int c, int t) {
        this.row = r;
        this.column = c;
        this.time = t;
    }
}



public class test {

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
      Queue<cell> q = new LinkedList<>();
      Queue<cell> cat = new LinkedList<>();
      Queue<cell> solutions = new LinkedList<>();
      

      int maxTime = 0;

    //   while(q.size)





























                // print grid
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                    System.out.print(grid[i][j]);
                    }
                    System.out.println();
                }
          
    }
}