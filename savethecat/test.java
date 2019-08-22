import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.*;

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
      Queue<<Point, Integer>> q = new LinkedList<>();
      Queue<<Point, Integer>> cat = new LinkedList<>();
      Queue<<Point, Integer>> solutions = new LinkedList<>();
      

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