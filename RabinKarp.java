package DataStructuresAndAlgorithms;

import java.util.*;

public class RabinKarp {

    public static void main(String args[])
    {
        System.out.println("Enter character one at a time");
        Scanner input = new Scanner(System.in);

        /** read the first character and initialize ch and str */
        char ch = input.next().charAt(0);
        String str = "" + ch;

        int d = 256;  // d is the number of ascii characters
        int q = 101; // prime number used to evaluate hash

        /** initialize forwardHash, backwardHash, and multiplier */
        int forwardHash = ch % q;  // forwardHash is from left (most significant) to right (left significant)
        int backwardHash = ch % q; // backwardHash is from right to left
        int multiplier = 1;


        /** Rabin Karp rolling hash implemented below.
         * loop to process current character,
         * then prompt the next character */
        while (true) {
            // if the forward and backward hashes don't match, str cannot be a palindrome
            if (forwardHash != backwardHash) {
                System.out.println("No");
            }
            // otherwise, test character by character to determine if str is palindrome
            else {
                boolean isPalindrome = true;
                for (int i = 0; i < str.length() / 2; i++) {
                    if (str.charAt(i) != str.charAt(str.length()-i-1)) {
                        isPalindrome = false;
                        System.out.println("No");
                        break;
                    }
                }
                if (isPalindrome) {
                    System.out.println("Yes");
                }
            }

            ch = input.next().charAt(0);  // get the next character
            str = str + ch; // append to string

            forwardHash = (forwardHash * d % q + ch) % q;   // update forwardHash
            backwardHash = (backwardHash + ch * (d * multiplier) % q) % q; // update backwardHash

            multiplier = multiplier * d % q; // update multiplier
        }
    }
}