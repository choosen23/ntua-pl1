import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.awt.Point;
import java.util.*;
import javax.xml.crypto.Data;


public class Ztalloc {

    public static void main(String[] args) throws Exception {

        File    file      = new File(args[0]);
        Scanner sc        = new Scanner(file);
        int     Q         = Integer.parseInt(sc.nextLine());
        String  tmp       = null;
        String [][] arr   = new String[Q+1][4];
        int     [][] Data = new int[Q+1][4];
        int     i         = 0;
        while (  sc.hasNextLine() ) {
            //eisodos me tin morfi
            //Lin Rin Lout Rout
                tmp = sc.nextLine();
            arr[i]  = tmp.split(" ");
            i++;       
        }
        sc.close();
        for ( i = 0; i < Q; i++) {
            for (int j = 0; j < 4; j++) {
                Data[i][j] = Integer.parseInt(arr[i][j]);
            }
        }
        int Lin,Rin,Lout,Rout;
        for ( i = 0; i < Q; i++ ) {
             Lin  = Data[i][0];
             Rin  = Data[i][1];
             Lout = Data[i][2];
             Rout = Data[i][3];
            if (!( Rout<Lin && Lout < Lin || Rout > Rin && Lout > Rin ) ) {
                System.out.println("EMPTY");
            }
            else {
                HashMap<Point    ,Integer> level = new HashMap<Point, Integer>();
                HashMap<Point    ,Point> parent  = new HashMap<Point, Point>();
                LinkedList<Point> frontier       = new LinkedList<Point>();
                LinkedList<Point> next           = new LinkedList<Point>();
                Point Start = new Point(-1,-1);
                level.put(new Point(Lin,Rin), 0);
                parent.put(new Point(Lin,Rin), Start);
                frontier.add(new Point(Lin,Rin));
                int k = 1;
                boolean isEnd = false;
                Point Target = Start;
                while (!frontier.isEmpty() && !isEnd) {
                    next.removeAll(next);
                    while(!frontier.isEmpty() && !isEnd ){
                        Point p = frontier.remove();
                        int   u = (int)p.getX();
                        int   v = (int)p.getY();
                        
                        Point h = new Point(u/2,v/2);
                        if (!level.containsKey(h) && !isEnd) {
                            level.put(h, k);
                            parent.put(h, p);
                            next.add(h);
                            if (u/2 >= Lout && u/2 <= Rout && v/2 >= Lout && v/2 <= Rout ) {
                                isEnd = true;
                                Target = h;
                                break;
                            }
                        }
                        Point t = new Point(u*3+1,v*3+1);
                        if (!level.containsKey(t) && v*3+1 <= 1000000 && !isEnd ) {
                            level.put(t, k);
                            parent.put(t, p);
                            next.add(t);
                            if ( u*3+1 >= Lout && u*3+1 <= Rout && v*3+1 >= Lout && v*3+1 <= Rout ) {
                                isEnd = true;
                                Target = h;
                                break;
                            }
                        }                
                    }
                    if (!isEnd) {
                    frontier.addAll(next);
                    k++;
                    }
                }
                if (!isEnd) {
                System.out.println("IMPOSSIBLE");
                Target = Start;
                parent.clear();
                level.clear();
                }
                Point c = new Point();
                String answer = null;

                System.out.println(parent.size());
                System.out.println(Target);
                
                
                
                if (!parent.isEmpty()) {
                    c = Target;
                    answer = " ";
                    while (true) {
                        if (c.equals(Start)) break;
                        if ((parent.get(c).getX() > c.getX()) 
                        || ( parent.get(c).getX() == c.getX() 
                        && parent.get(c).getY() > c.getY() )) {
                            answer = 'h' + answer;
                            c = parent.get(c);
                            }
                        else {
                            answer = 't' + answer;
                            c = parent.get(c);
                        }
                        
                    }
                    System.out.println(answer);
                    System.gc();
                    }
                }
            }
        }
    }
