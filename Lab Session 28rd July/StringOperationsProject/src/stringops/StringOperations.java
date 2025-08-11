package stringops;

public class StringOperations {

	// 1. Return highest frequency character and its count
	public String highestFrequencyChar(String input) {
	    int[] freq = new int[256];
	    for (char c : input.toCharArray()) {
	        freq[c]++;
	    }

	    int max = 0;
	    char result = ' ';
	    for (int i = 0; i < 256; i++) {
	        if (freq[i] > max) {
	            max = freq[i];
	            result = (char) i;
	        }
	    }

	    return "Highest frequency character: '" + result + "' occurred " + max + " times.";
	}
	// 2. Return string with first vowel replaced
	public String replaceFirstVowel(String input) {
	    return input.replaceFirst("[AEIOUaeiou]", "-");
	}

    // 3. Count alphabets, digits, and special characters
    public void countCharTypes(String input) {
        int letters = 0, digits = 0, specials = 0;
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) letters++;
            else if (Character.isDigit(c)) digits++;
            else specials++;
        }

        System.out.println("Alphabets: " + letters + ", Digits: " + digits + ", Special Characters: " + specials);
    }

    // 4. Remove all blank spaces
    public void removeSpaces(String input) {
        String result = input.replaceAll("\\s+", "");
        System.out.println("String without spaces: " + result);
    }

    // 5. Concatenate two strings
    public void concatenateStrings(String s1, String s2) {
        String result = s1 + s2;
        System.out.println("Concatenated string: " + result);
    }
}
