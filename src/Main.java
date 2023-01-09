import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int []a = new int[n];
        System.arraycopy(arr, 0, a, 0, n);
        for (int i = 0; i < n; i++) {
            if(a[i] == 1) a[i] = Integer.MIN_VALUE;
            if(a[i] == 0) a[i] = 1;
        }
        int k = Kadens(a, n);
        System.out.println("k = "+k);
        System.out.println(findMax(arr, n, k));
    }
    static int findMax(int[] arr, int n, int k)
    {
        int t, i;
        int c , max = 0;

        for(i = 0; i < n - k + 1; i++)
        {
            t = i - 1;
            c = 0;

            while (t >= 0 && arr[t] == 1)
            {
                t--;
                c++;
            }
            t = i + k;

            while (t < n && arr[t] == 1)
            {
                t++;
                c++;
            }
            c += k;

            if (c > max)
                max = c;
        }

        return max;
    }
    static int Kadens(int []arr, int n){
        int currSum = 0, maxSum = Integer.MIN_VALUE, start = 0, st = 0, en = 0;
        for (int i = 0; i < n; i++) {
            currSum += arr[i];
            if(currSum > maxSum) {
                maxSum = currSum;
                st = start;
                en = i;
            }
            if(currSum < 0) {
                currSum = 0;
                start = i+1;
            }
        }
        return en- st+1;
    }
}