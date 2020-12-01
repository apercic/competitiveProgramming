import java.lang.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Solution to 'Moony and ICPC team' CodeChef problem (COG2002)

 * Circles-like
 * Could also do: In order to account for the cyclic nature of the array, take a(i-1) as a((i-1+n)%n) and a(i+1) as a((i+1)%n)
 */
class Code {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        long T = sc.nextLong();
        for (long i = 0; i < T; i++) {
            long N = sc.nextLong();

            List<Long> list = new ArrayList<>();
            for (int j = 0; j < N; j++)
                list.add(sc.nextLong());

            //add begining
            list.add(0, list.get(list.size() - 1));
            list.add(0, list.get(list.size() - 2));
            //add end
            list.add(list.get(2));
            list.add(list.get(3));

            long maxScore = 0;
            for (int j = 0; j < list.size() - 3; j++) {
                long tempScore = list.get(j) + list.get(j + 1) + list.get(j + 2);
                if (tempScore > maxScore) maxScore = tempScore;
            }
            System.out.println(maxScore);
        }
    }
}
