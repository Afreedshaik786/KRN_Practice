package Practice;

public class afreed {

	public static void main(String[] args) {
		String s = "wel co m e";
		int c=0;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch==' ') {
			c++;
			}
		}
		System.out.println("no of spaces: "+c );
	}

}
