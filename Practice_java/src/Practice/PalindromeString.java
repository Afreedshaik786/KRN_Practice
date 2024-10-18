package Practice;

public class PalindromeString {

	public static void main(String[] args) {
		String s = "51132123";
		int c = 0;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);

			if (ch >= '0' && ch <= '9') {
				c++;
			}
		}
		if (c == s.length()) {
			System.out.println("string contains only letters");
		} else {
			System.out.println("string contains not only letters");
		}
	}
}
