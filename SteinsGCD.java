import java.lang.*;
import java.util.Scanner;

/**
 * Solution to 'Zack And The Handkerchieves' CodeChef problem (ZACKHAN)
 * 
 * Stein's binary GCD algorithm
 */
class Solution {
    static long gcdBySteinsAlgorithm(long n1, long n2) {
        if (n1 == 0) return n2;
        if (n2 == 0) return n1;
        long n;
        for (n = 0; ((n1 | n2) & 1) == 0; n++) {
            n1 >>= 1;
            n2 >>= 1;
        }
        while ((n1 & 1) == 0)
            n1 >>= 1;
        do {
            while ((n2 & 1) == 0)
                n2 >>= 1;
            if (n1 > n2) {
                long temp = n1;
                n1 = n2;
                n2 = temp;
            }
            n2 = (n2 - n1);
        } while (n2 != 0);
        return n1 << n;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        long T = sc.nextInt();
        for (long i = 0; i < T; i++) {
            long L = sc.nextLong();
            long B = sc.nextLong();
            System.out.println(gcdBySteinsAlgorithm(L, B));
        }
    }
}