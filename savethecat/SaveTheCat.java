import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.awt.Point;
import java.awt.geom.Point2D;




public class Grid {
    int death_time=-1;
    int cat_time=-1;
    char symbol;
    string seq;
    bool visited=false;
    bool cat_visit=false;
}




public class SaveTheCat {

  public static void main (String[] args) throws Exception {
    //Diavasmata  
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
      //End diavasmata
      char[][] grid = lines.toArray(new char[lines.size()][]);
     
      Queue<Point> q = new LinkedList<>();
      Queue<Point> cat = new LinkedList<>();
      Queue<
     

      for (int i = 0; i < N; i++) {
    	  for (int j = 0; j < M; j++) {
    		  if (grid[i][j] == '+' || grid[i][j] == '-' ) {
    			  q.add(new Point(i, j));

    			  depth[i][j] = 0;
    		  } else depth[i][j] = -1;
    	  }
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
