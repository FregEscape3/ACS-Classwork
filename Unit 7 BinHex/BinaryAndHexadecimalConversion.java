public class BinaryAndHexadecimalConversion {

	public static void main(String[] args) {
		System.out.println(convertIntToBinary(2890));
		System.out.println(convertBinaryToInt("101101001010"));
		System.out.println(convertIntToHexadecimal(3499));
		System.out.println(convertHexadecimalToInt("DAB"));
		System.out.println(convertHexadecimalToBinary("B5A"));
		System.out.println(convertBinaryToHexadecimal("101101011010"));
		System.out.println(convertStringToInt("0b101101001010"));
		System.out.println(convertStringToInt("0xDAB"));
		System.out.println(convertStringToInt("6767"));
	}

	// Given an int, returns the binary representation of that int as a String
	// Precondition: num >= 0
	public static String convertIntToBinary(int num) {
		if (num < 0) {
			return "";
		}
		if (num == 0) {
			return "0";
		}
		if (num == 1) {
			return "1";
		}
		return convertIntToBinary(num / 2) + (num % 2);
	}

	// Given a String of a binary representation of an int, returns that int
	// Precondition: binary string is not negative
	public static int convertBinaryToInt(String binary) {
		if (binary.length() == 0) {
			return 0;
		}
		int lastDigit = binary.charAt(binary.length() - 1) - '0';
		String remainingDigits = binary.substring(0, binary.length() - 1);
		return convertBinaryToInt(remainingDigits) * 2 + lastDigit;
	}

	// Given an int, returns the hexadecimal representation of that int as a String
	// Precondition: num >= 0
	public static String convertIntToHexadecimal(int num) {
		if (num < 0) {
			return "";
		}
		if (0 <= num && num < 10) {
			return String.valueOf(num);
		}
		if (num == 10) {
			return "a";
		}
		if (num == 11) {
			return "b";
		}
		if (num == 12) {
			return "c";
		}
		if (num == 13) {
			return "d";
		}
		if (num == 14) {
			return "e";
		}
		if (num == 15) {
			return "f";
		}
		int lastDigit = num % 16;
		if (lastDigit < 10) {
			return convertIntToHexadecimal(num / 16) + lastDigit;
		}
		return convertIntToHexadecimal(num / 16) + convertIntToHexadecimal(lastDigit);
	}

	// Given a String of a hexadecimal representation of an int, returns that int
	// Precondition: hexadecimal string is not negative
	public static int convertHexadecimalToInt(String hex) {
		if (hex.length() == 0) {
			return 0;
		}
		char lastChar = hex.charAt(hex.length() - 1);
		int lastDigit;
		if ('0' <= lastChar && lastChar <= '9') {
			lastDigit = lastChar - '0';
		} else {
			lastDigit = lastChar - 'a' + 10;
		}
		String remainingDigits = hex.substring(0, hex.length() - 1);
		return convertHexadecimalToInt(remainingDigits) * 16 + lastDigit;
	}

	// Given a String of a hexadecimal representation of an int,
	// returns the String of the binary representation
	// Precondition: hexadecimal string is not negative
	public static String convertHexadecimalToBinary(String hex) {
		return convertIntToBinary(convertHexadecimalToInt(hex));
	}

	// Given a String of a binary representation of an int,
	// returns the String of the hexadecimal representation
	// Precondition: hexadecimal string is not negative
	public static String convertBinaryToHexadecimal(String binary) {
		return convertIntToHexadecimal(convertBinaryToInt(binary));
	}

	// Converts the String representation of the number to an int.
	// If the String starts with 0b, then convert the rest of the String as if it
	// were binary.
	// If the String starts with 0x, then convert the rest of the String as if it
	// were hexadecimal.
	// If the String starts with neither, then convert the rest of the String as if
	// it were decimal.
	public static int convertStringToInt(String numString) {
		numString = numString.toLowerCase();
		if (numString.substring(0, 2).equals("0b")) {
			return convertBinaryToInt(numString.substring(2));
		} else if (numString.substring(0, 2).equals("0x")) {
			return convertHexadecimalToInt(numString.substring(2));
		} else {
			return Integer.parseInt(numString);
		}
	}
}
