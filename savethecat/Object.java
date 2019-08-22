import java.awt.Point;

public class Object {
	private Point cord1;
	private Point cord2;
	
	public Object(Point x,Point t){
		cord1 = x;
		cord2 = t;
		}
	
	public Point getStar(){
		return cord1;
	}
	public Point getDest(){
		return cord2;
	}
}
