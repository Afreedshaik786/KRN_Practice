package Practice;

public class Number_pattern {

	public static void main(String[] args) {
		int n=5;
		for (int i =1; i<= n;i++) {
			int num=i;
			for (int j = 1; j<= n; j++) {
				System.out.print(num+" ");
				num=num+n;
			}
			System.out.println();
		}
	}
}
