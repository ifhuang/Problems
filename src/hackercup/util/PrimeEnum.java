package hackercup.util;

import java.io.FileWriter;

public class PrimeEnum {

	static boolean isPrime(int n) {
		int end = (int) Math.sqrt(n) + 1;
		for (int i = 2; i < end; i++)
			if (n % i == 0)
				return false;
		return true;
	}

	public static void main(String[] args) throws Exception {
		FileWriter fw = new FileWriter("Prime.txt");
		fw.write(2 + "");
		for (int i = 3; i < 10000000; i++)
			if (isPrime(i))
				fw.write("," + i);
		fw.flush();
		fw.close();
	}

}
