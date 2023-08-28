package DataStructuresAndAlgorithms;

import java.util.*;

public class RobinKarp {

    public static void main(String args[])
    {
        String txt = "aabbaaccaabbaa";
        checkPalindromes(txt);
        System.out.println();
        String txt2 = "racecar";
        checkPalindromes(txt2);
    }

    public static void checkPalindromes(String str) {
        int d = 256;  // d is the number of ascii characters
        int q = 101; // prime number used to evaluate hash
        int N = str.length(); // Length of input string

        // A single character is always a palindrome
        System.out.println(str.charAt(0)+" Yes");
        if (N == 1) return;

        // Initialize firstHalf reverse and secondHalf
        int firstHalf  = str.charAt(0) % q;
        int secondHalf = str.charAt(1) % q;

        int multiplier = 1;
        int i; int j;

        // check for palindrome after second character
        for (i = 1; i < N; i++)
        {
            /**If the hash values of firstHalf and secondHalf match,
             * then compare characters to determine if string is palindrome*/
            boolean isPalindrome = true;
            if (firstHalf == secondHalf)
            {
                for (j = 0; j < i/2; j++) {
                    if (str.charAt(j) != str.charAt(i - j)) {
                        isPalindrome = false;
                        break;
                    }
                }
                if (isPalindrome)
                    System.out.println(str.charAt(i) + " Yes");
                else
                    System.out.println(str.charAt(i)+ " No");
            }

            /**if the hash values of firstHalf and secondHalf don't match,
             * then print the character and "No"*/
            else {
                System.out.println(str.charAt(i)+ " No");
            }

            // Calculate hash values for next iteration
            if (i != N - 1)
            {
                /** if i is even:
                 * Add next character to firstHalf hash value
                 * Add next character at the end of second half.*/
                if (i % 2 == 0) {
                    multiplier = (multiplier * d) % q;
                    firstHalf  = (firstHalf + multiplier *str.charAt(i / 2)) % q;
                    secondHalf = (secondHalf * d + str.charAt(i + 1)) % q;
                }
                /** If next i is odd,
                 * we just need to remove secondHalf first character append character to it.*/
                else {
                    secondHalf = (((secondHalf - str.charAt((i + 1) / 2) * multiplier+ q) * d) % q + str.charAt(i + 1)) % q;
                }
            }
        }
    }
}