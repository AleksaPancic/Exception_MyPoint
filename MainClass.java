package aleksa;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainClass {
	static int a[];
	
	public static void solveSimple(int a[], int n) {
		int num = a[1] - a[0]; // 3
		for(int i = 1; i < n - 1; i++) { //a[1]
			for(int j = i + 1; j < n; j++) {//a[2]
				if((a[j] - a[i]) == num) { // a[2] - a[1] ? 3
					System.out.println("ok");
				}
				else System.out.println("not ok");
			}
			
		}
	}
	public static void F(int a[], int n, int t) {
		ExecutorService executor =  Executors.newFixedThreadPool(t);
		Worker[] workers = new Worker[t];
		int d = n/t;
		
		for(int i = 0; i < t; i++) {
			workers[i] = new Worker(a, i * d, (i == d-1) ? n - 1: (i + 1) * d - 1);
		}
		
		for(int i = 0; i < t; i++) {
			executor.submit(workers[i]);
		}
		
		executor.shutdown();
		
		try {
			executor.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		/*for(int i = 0; i < t; i++) {
			if(workers[i].getIsProgression()) {
				System.out.println("its progression");
			} else System.out.println("its not");
		}*/
		System.out.println("Array is Progression? > " + (Worker.getIsProgression() ? "Yes" : "No"));
	}
	public static void main(String[] args) {
		int n = 4;
		int t = 2;
		int[] a = new int[n];
		a[0] = 2;
		a[1] = 5;
		a[2] = 6;
		a[3] = 8;
		F(a, n, t);
		solveSimple(a, n);
	}

}
