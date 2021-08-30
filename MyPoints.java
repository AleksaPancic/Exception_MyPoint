package aleksa;

import java.util.ArrayList;
import java.util.Iterator;

public class MyPoints {
ArrayList<Point> skup = new ArrayList<Point>();

public void add(Point p) throws SizeException, EqualsException {
	if(skup.size() == 300) {
		throw new SizeException("Size is already 300");
	}
	if(p.getX() >= 1000 || p.getX() <= -1000 || p.getY() >= 1000 || p.getY() <= -1000) {
		throw new SizeException("Point coordinates are over 1000 or under -1000" + "(" + p.getX() + "," + p.getY() + ")");
	}
	Iterator<Point> it = skup.iterator();
	while(it.hasNext()) {
		Point testp = it.next();
		if(testp.equals(p)) {
			throw new EqualsException("Point is already in Array");
		}
	}
//	for(int i = 0; i < skup.size(); i++) {
//		if(skup.get(i).equals(p)) {
//			throw new EqualsException("Point is already in Array");
//		}
//	}

	skup.add(p);
}

public Boolean Condition(Point p1, Point p, int a) {
	if(p1.getX() == p.getX() && p1.getY() == p.getY()) return true;
	if(p1.getX() >= p.getX() && p1.getX() <= p.getX() + a && p1.getY() >= p.getY() && p1.getY() <= p.getY() + a) return true;
	return false;
}

public void remove(Point p, int a) throws NegativeException, EmptyException, RemoveFailure {
	int brojac = 0;
	if(a < 0) {
		throw new NegativeException("Number is negative: " + a);
	}
	if(skup.isEmpty()) {
		throw new EmptyException("Array is empty " + skup.size());
	}
	Iterator<Point> it = skup.iterator();
	while(it.hasNext()) {
		if(Condition(it.next(),p,a)) {
			brojac++;
			it.remove();
		}
	}
	if(brojac == 0) {
		throw new RemoveFailure("Zero points removed");
	}
}
//sqrt((x1 + x2) * (x1 + x2) - (y1 - y2) * (y1 - y2)) Euklid
Point closest(Point p) throws ClosestException, EmptyException {
	if(skup.isEmpty()) {
		throw new EmptyException("Array is empty " + skup.size());
	}
	double trenutna = 0;
	double najbliza = 999999999;
	Point prom = skup.get(0);
	int brojac = 0;
	for(int i = 0; i < skup.size(); i++) {
		trenutna =  Math.sqrt(((skup.get(i).getX() + p.getX()) * (skup.get(i).getX() + p.getX())) - ((skup.get(i).getY() + p.getY() * (skup.get(i).getY() + p.getY()))));
		System.out.println(trenutna);
		if(trenutna < najbliza) {
			brojac++;
			prom = skup.get(i);
		}
	}
	if(brojac == 0) {
		throw new ClosestException("There is not a point that is closest to a point with coordinates: " + "(" + p.getX() + "," + p.getY() + ")");
	}
	return prom;
}
public void print() { //test funkcija
	for(int i = 0; i < skup.size(); i++) {
		System.out.println("("  + skup.get(i).getX() +  "," + skup.get(i).getY() +  ")");
	}
}
}
