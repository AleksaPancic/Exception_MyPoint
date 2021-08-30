package aleksa;

public class Worker implements Runnable {
	
	private int a[];
	private int l,r;
	private static volatile Boolean isProgression = true;
	
	

	public Worker(int[] a, int l, int r) {
		super();
		this.a = a;
		this.l = l;
		this.r = r;
	}



	@Override
	public void run() {
		int num = a[l+1] - a[l];
		for(int i = l + 1; i < r - 1 && getIsProgression(); i++) {
			for(int j = l + 2; j < r; j++) {
				if((a[j] - a[i]) == num) {
					isProgression = true;
				}
			}
			
		}
	}



	public static Boolean getIsProgression() {
		return isProgression;
	}



	public static void setIsProgression(Boolean isProgression) {
		Worker.isProgression = isProgression;
	}

}
