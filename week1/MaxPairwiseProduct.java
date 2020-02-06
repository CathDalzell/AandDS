import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {

    static int getMax(int[] numbers){
      int n = numbers.length;
      int max_first = 0;
      for (int i = 0; i < n; i++){
        if (numbers[i] > max_first) {
          max_first = numbers[i];
        }
      }
      return max_first;
    }

    public static int[] removeValue(int[] numbers, int value){
      int n = numbers.length;
      int[] arr = new int[n - 1];

      int stopValue = 0;
      while (numbers[stopValue] != value && stopValue < n){
        arr[stopValue] = numbers[stopValue];
        stopValue++;
      }

      for (int i = stopValue + 1; i < n; i++){
        arr[i-1] = numbers[i];
      }
      return arr;
    }
    static long getMaxPairwiseProduct(int[] numbers) {

        int max_first = getMax(numbers);
        int[] numbersMinus = removeValue(numbers, max_first);
        int max_second = getMax(numbersMinus);
        long max_product = (long) max_first * (long) max_second;
        return max_product;
      }

/*
        for (int first = 0; first < n; ++first) {
            for (int second = first + 1; second < n; ++second) {
                max_product = Math.max(max_product,
                    numbers[first] * numbers[second]);
            }
        }

        return max_product;
    }
*/



    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextint();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextint();
        }
        System.out.println(getMaxPairwiseProduct(numbers));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                    InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextint() {
            return Integer.parseInt(next());
        }
    }

}
