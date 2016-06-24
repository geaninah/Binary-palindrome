public class Palindrome
{
    static int flip(int x)
    {
        int b = 0;

        while (x != 0)
        {
            b <<= 1;
            b |= x & 1;
            x >>= 1;
        }

        return b;
    }

    static boolean isPalindrome(int x)
    {
        String binaryValue = Integer.toBinaryString(x);        
        int initialLength = String.valueOf(binaryValue).length();

        int newValue = Integer.parseInt(Integer.toBinaryString(flip(x)));
        String flippedValue = Integer.toString(newValue);
        int newLength = String.valueOf(flippedValue).length();

        // Find how many 0's we need in front of the new value
        int difference = initialLength - newLength;

        // Add 0 in front of those numbers which initial values ended in 1
        while(difference > 0)
        {
            flippedValue = "0" + flippedValue;
            difference--;
        }

        if(binaryValue.compareTo(flippedValue) == 0)
        {
            return true;
        }

        return false;
    }

    static int kthPalindrome(int k)
    {
        int x = 1;
        int palindrome = 1;
        
        while(k > 0)
        {
            if(isPalindrome(x))
            {
               palindrome = x;
               k--; 
            }

            x++;
        }

        return palindrome;
    }

    public static void main(String args[])
    {
        System.out.print("First palindrome: expectation -- 1, actual -- ");
        System.out.println(kthPalindrome(1));
        System.out.print("First palindrome: expectation -- 3, actual -- ");
        System.out.println(kthPalindrome(2));
        System.out.print("First palindrome: expectation -- 5, actual -- ");
        System.out.println(kthPalindrome(3));
        System.out.print("First palindrome: expectation -- 7, actual -- ");
        System.out.println(kthPalindrome(4));
    }
}
