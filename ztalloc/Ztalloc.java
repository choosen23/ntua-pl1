import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.awt.Point;
import java.util.*;
import javax.xml.crypto.Data;
import java.lang.*;
import java.awt.Point;










public class Ztalloc {
    public static void main(String[] args) throws Exception {

        File file = new File(args[0]); 
        Scanner sc = new Scanner(file); 
        int Q = Integer.parseInt(sc.nextLine());
        String tmp = null;
        String[][] arr = new String[Q+1][4];
        int [][] Data = new int[Q+1][4];
        int i = 0;
        while (  sc.hasNextLine() ) {
            //eisodos me tin morfi
            //Lin Rin Lout Rout
            tmp = sc.nextLine();
            arr[i] = tmp.split(" "); 
            i++;       
        }
        for ( i = 0; i < Q; i++) {
            for (int j = 0; j < 4; j++) {
                if (j == 3) System.out.println(arr[i][j]);
                else System.out.print(arr[i][j]);
                Data[i][j] = Integer.parseInt(arr[i][j]);       
            }
        }

        int Lin,Rin,Lout,Rout;
        for ( i = 0; i < Q; i++ ) {
             Lin = Data[i][0];
             Rin = Data[i][1];
             Lout = Data[i][2];
             Rout = Data[i][3];
            if (!( Rout<Lin && Lout < Lin || Rout > Rin && Lout > Rin ) ) {
                System.out.println("EMPTY");
                continue;
            }
            else {
                HashMap<Point,Integer> level = new HashMap<Point,Integer>();
                HashMap<Point,Point> parent = new HashMap<Point,Point>();
                LinkedList<Point> frontier = new LinkedList<Point>();
                LinkedList<Point> next = new LinkedList<Point>();
                level.put(new Point(Lin,Rin), 0);
                parent.put(new Point(Lin,Rin), new Point(-1,-1));
                frontier.add(new Point(Lin,Rin));
                int k = 1;
                while (!frontier.isEmpty()) {
                    next.removeAll(next);
                    while(!frontier.isEmpty()){
                        Point p = frontier.remove();
                        int u = (int)p.getX();
                        int v = (int)p.getY();
                        
                        Point h = new Point(u/2,v/2);
                        if (!level.containsKey(h)) {
                            level.put(h, k);
                            parent.put(h, p);
                            next.add(h);
                            if (u/2 >= Lout && u/2 <= Rout && v/2 >= Lout && v/2 <= Rout ) {
                                

                            }
                        }
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    }

                }
                

            
            }
            



        }






















     
        
    }
}