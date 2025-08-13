package stringops;

import java.util.Scanner;

public class MainStringApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringOperations ops = new StringOperations();

        System.out.print("Enter a string for highest frequency char: ");
        String str1 = sc.nextLine();
        ops.highestFrequencyChar(str1);

        System.out.print("Enter a string to replace first vowel: ");
        String str2 = sc.nextLine();
        ops.replaceFirstVowel(str2);

        System.out.print("Enter a string to count types of characters: ");
        String str3 = sc.nextLine();
        ops.countCharTypes(str3);

        System.out.print("Enter a string to remove spaces: ");
        String str4 = sc.nextLine();
        ops.removeSpaces(str4);

        System.out.print("Enter first string to concatenate: ");
        String s1 = sc.nextLine();
        System.out.print("Enter second string to concatenate: ");
        String s2 = sc.nextLine();
        ops.concatenateStrings(s1, s2);

        sc.close();
    }
}
