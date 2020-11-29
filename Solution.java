import java.lang.*;
import java.util.Scanner;

/**
 * Solution to My Fair Coins CodeChef problem (CSUMD)
 *
 * Matrix multiplication
 * |F(n)  |    |a b c |   |F(n-1)|
 * |F(n-1)|  = |1 0 0 | * |F(n-2)|
 * |F(n-2)|    |0 1 0 |   |F(n-3)|
 *
 * F(n) = a*F(n-1) + b*F(n-2) + c*F(n-3)
 *
 * (only two dimensions in this example)
 */
class Solution {
    static long mod = 1000000007L;

    public static void multiplyMatrices(long[][] firstMatrix, long[][] secondMatrix) {
        long[][] product = new long[2][2];
        for(int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++)
                for (int k = 0; k < 2; k++)
                    product[i][j] += (firstMatrix[i][k] * secondMatrix[k][j])%mod;

        for(int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++)
                firstMatrix[i][j] = product[i][j];

    }

    static long[][] rec(long n) {
        //n = power to which we rise the matrix
        long [][] a = {{2,2},{1,0}};
        long [][] b = {{1,0},{0,1}}; //identity matrix

        while (n > 0) {
            if (n % 2 == 1)
                multiplyMatrices(b,a);
            multiplyMatrices(a, a);
            n /= 2;
        }
        return b;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            long N  = sc.nextLong();

            if (N == 1) System.out.println(1);
            else {
                long[][] a = rec(N-2);
                System.out.println((3*a[0][0]+a[0][1])%mod);
            }
        }
    }
}