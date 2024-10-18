package Practice;

public class primeEle {

	public static void main(String[] args) {
		String s = "abcdefghijklmnopqrstuvwx";
		char[] a = s.toCharArray();
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] == a[j]) {
					a[j] = '%';
				}
			}
		}
		int c = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i]>= 'a' && a[i]<= 'z') {
				c++;
			}
		}
		System.out.println("count is :" + c);
		if (c == 26) {
			System.out.println("panagram");
		} else {
			System.out.println("not a panagram");
		}

	}

}
