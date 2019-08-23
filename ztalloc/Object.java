public class Object {
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
    
	public Object( x1, int x2, int x3, int x4){
        Lin = x1;
        Rin = x2;
        Lout = x3;
        Rout = x4;    
    }
	
	public int getLin(){
		return Lin;
	}
	public int getLout(){
		return Lout;
    }
    
	public int getRin(){
		return Rin;
    }
    
	public int getRout(){
		return Rout;
    }
}