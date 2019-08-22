import java.util.LinkedList;
import java.util.Queue;
import java.io.*;


public class Doomsday {
	
	private static char grid[][]= new char[1000][1000];
	
	public static void main(String[] args){
		
		Queue<Object> myqueue= new LinkedList<Object>();
		try {
			BufferedReader in= new BufferedReader(new FileReader(args[0]));
			int i=0;
			int j=0;
			int rows=0;
			int lines=0;
			int a;
			char character;
			while ( (a=in.read()) != -1 ) {
					character=(char)a;
					if (character=='\n'){
						i++;
						rows=j;
						j=0;
						continue;
					}
					grid[i][j]= character;
					if (character == '+' || character == '-'){
						myqueue.add(new Object(i,j,0,character));
					}
					j++;
			}
			lines=i;
			in.close();
			
			int TIME=0, timeofdoom=-1;
			boolean doomsday= false;
			while (!myqueue.isEmpty()){
				Object testsymb= myqueue.element();
				if ( testsymb.getTime()== TIME) ++TIME;
				if ((doomsday==false) || ((doomsday==true) && (testsymb.getTime()==timeofdoom-1))) {
				      if (testsymb.getline()-1>=0){//panw
				          if (grid[testsymb.getline()-1][testsymb.getrow()]=='.'){
				            if (grid[testsymb.getline()][testsymb.getrow()]=='+') {
				              grid[testsymb.getline()-1][testsymb.getrow()]='+';
				              Object newobject= new Object(testsymb.getline()-1,testsymb.getrow(),TIME,'+');
				              myqueue.add(newobject);
				            }
				            else{
				              grid[testsymb.getline()-1][testsymb.getrow()]='-';
				              Object newobject=new Object(testsymb.getline()-1,testsymb.getrow(),TIME,'-');
				              myqueue.add(newobject);
				            }
				          }
				          else if ((grid[testsymb.getline()-1][testsymb.getrow()]!='X') && (testsymb.getSymbol()!= grid[testsymb.getline()-1][testsymb.getrow()])){
				              doomsday=true;
				              grid[testsymb.getline()-1][testsymb.getrow()]='*';
				              timeofdoom=TIME;

				          }
				      }
				      if (testsymb.getline()+1<=lines-1){//katw
				          if (grid[testsymb.getline()+1][testsymb.getrow()]=='.') {
				            if (grid[testsymb.getline()][testsymb.getrow()]=='+') {
				              grid[testsymb.getline()+1][testsymb.getrow()]='+';
				              Object newobject= new Object(testsymb.getline()+1,testsymb.getrow(),TIME,'+');
				              myqueue.add(newobject);
				            }
				            else{
				              grid[testsymb.getline()+1][testsymb.getrow()]='-';
				              Object newobject=new Object(testsymb.getline()+1,testsymb.getrow(),TIME,'-');
				              myqueue.add(newobject);
				            }
				          }
				          else if ((grid[testsymb.getline()+1][testsymb.getrow()]!='X') && (testsymb.getSymbol()!= grid[testsymb.getline()+1][testsymb.getrow()])){
				              doomsday=true;
				              grid[testsymb.getline()+1][testsymb.getrow()]='*';
				              timeofdoom=TIME;
				          }
				      }
				      if (testsymb.getrow()-1>=0){//aristera
				          if (grid[testsymb.getline()][testsymb.getrow()-1]=='.'){
				            if (grid[testsymb.getline()][testsymb.getrow()]=='+') {
				              grid[testsymb.getline()][testsymb.getrow()-1]='+';
				              Object newobject=new Object(testsymb.getline(),testsymb.getrow()-1,TIME,'+');
				              myqueue.add(newobject);
				            }
				            else{
				              grid[testsymb.getline()][testsymb.getrow()-1]='-';
				              Object newobject=new Object(testsymb.getline(),testsymb.getrow()-1,TIME,'-');
				              myqueue.add(newobject);
				            }
				          }
				          else if ((grid[testsymb.getline()][testsymb.getrow()-1]!='X') && (testsymb.getSymbol()!= grid[testsymb.getline()][testsymb.getrow()-1])){
				              doomsday=true;
				              grid[testsymb.getline()][testsymb.getrow()-1]='*';
				              timeofdoom=TIME;
				          }
				      }
				      if (testsymb.getrow()+1<=rows-1){//deksia
				          if (grid[testsymb.getline()][testsymb.getrow()+1]=='.'){
				            if (grid[testsymb.getline()][testsymb.getrow()]=='+') {
				              grid[testsymb.getline()][testsymb.getrow()+1]='+';
				              Object newobject=new Object(testsymb.getline(),testsymb.getrow()+1,TIME,'+');
				              myqueue.add(newobject);
				            }
				            else{
				              grid[testsymb.getline()][testsymb.getrow()+1]='-';
				              Object newobject=new Object(testsymb.getline(),testsymb.getrow()+1,TIME,'-');
				              myqueue.add(newobject);
				            }
				          }
				          else if ((grid[testsymb.getline()][testsymb.getrow()+1]!='X') && (testsymb.getSymbol()!= grid[testsymb.getline()][testsymb.getrow()+1])) {
				              doomsday=true;
				              grid[testsymb.getline()][testsymb.getrow()+1]='*';
				              timeofdoom=TIME;
				          }
				      }
				      
				      
				}
				myqueue.remove();
			}
			if (doomsday==false) System.out.println("the world is saved");
			else System.out.println(timeofdoom);	
			for (i=0;i<=lines-1;i++){
			    for (j=0;j<= rows-1;j++){
			        if (j==rows-1) System.out.println(grid[i][j]);
			        else
			          System.out.print(grid[i][j]);
			    }
			}

		}
		
		catch (IOException e){
			e.printStackTrace();
		}
		
	}
}

