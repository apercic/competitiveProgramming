import java.lang.*;
import java.util.Scanner;

/**
 * Solution to 'Fibonacci Inspiration' CodeChef problem (IEMCO8F)
 * <p>
 * Matrix multiplication
 * f(N)=a⋅f(N−1)+b⋅f(N−2)+c⋅f(N−3)+d⋅f(N−4)+e
 * <p>
 * | dp(i)   | = | a b c d 1 | x | dp(i-1) |
 * | dp(i-1) |   | 1 0 0 0 0 |   | dp(i-2) |
 * | dp(i-2) |   | 0 1 0 0 0 |   | dp(i-3) |
 * | dp(i-3) |   | 0 0 1 0 0 |   | dp(i-4) |
 * |   e     |   | 0 0 0 0 1 |   |   e     |
 */
class Solution {
    static long mod = 1000000007L;

    public static void multiplyMatrices(long[][] firstMatrix, long[][] secondMatrix) {
        long[][] product = new long[5][5];
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                for (int k = 0; k < 5; k++)
                    product[i][j] = (product[i][j] + (firstMatrix[i][k] * secondMatrix[k][j]) % mod) % mod;

        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                firstMatrix[i][j] = product[i][j];

    }

    static long[][] rec(long a, long b, long c, long d, long e, long n) {
        //n = power to which we rise the matrix
        long[][] first = {{a, b, c, d, 1}, {1, 0, 0, 0, 0}, {0, 1, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 0, 1}};
        long[][] second = {{1, 0, 0, 0, 0}, {0, 1, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 1, 0}, {0, 0, 0, 0, 1}}; //identity matrix

        while (n > 0) {
            if (n % 2 == 1)
                multiplyMatrices(second, first);
            multiplyMatrices(first, first);
            n /= 2;
        }
        return second;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            long a = sc.nextLong() % mod;
            long b = sc.nextLong() % mod;
            long c = sc.nextLong() % mod;
            long d = sc.nextLong() % mod;
            long e = sc.nextLong() % mod;
            long N = sc.nextLong();

            if (N <= 4) {
                System.out.println(N - 1);
                continue;
            }

            long[][] sol = rec(a, b, c, d, e, N - 4);
            System.out.printf("%d\n", (3 * sol[0][0] % mod + 2 * sol[0][1] % mod + sol[0][2] % mod + e * sol[0][4] % mod) % mod);
        }
    }
}