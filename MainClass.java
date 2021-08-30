package aleksa;

public class MainClass {
public static void main(String[] args) {
	try {
	Point p0 = new Point(-1,-2);
	Point p1 = new Point(1,2);
	Point p2 = new Point(2,3);
	Point p3 = new Point(4,5);
	Point p4 = new Point(6,7);
	Point p5 = new Point(8,9);
	Point p6 = new Point(0,0);
	MyPoints skup = new MyPoints();
	skup.add(p0);
	skup.add(p1);
	skup.add(p2);
	skup.add(p3);
	skup.add(p4);
	skup.add(p5);
	skup.add(p6);
	//skup.add(p1);
	skup.remove(p0, 4);
	skup.print();
	System.out.println(skup.closest(p1).getX() + "," +  skup.closest(p1).getY());
	} catch(Exception e) {
		e.printStackTrace();
	}
}
}
