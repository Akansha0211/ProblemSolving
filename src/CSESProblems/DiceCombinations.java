package CSESProblems;

import java.io.*;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class DiceCombinations {
    public static void main(String[] args) {
        Reader io = new Reader();
        int  n = io.nextInt();
        long[] dp = new long[n + 1];
//        Arrays.fill(dp, -1);
//        long ans =solution(n, dp);
//        System.out.println(ans);
        long ans = bottomUpSolution(n, dp);
        System.out.println(ans);
    }
    private static long solution(int n, long[] dp){
        int mod = 1_000_000_007;
        if(n ==0)return 1;
        if(n<0) return 0;
        if(dp[n] !=-1)return dp[n];
        long ans = 0;
        long max = Math.min(n, 6);
        for(int i = 1; i<=max; i++){
//            ans += (solution(n-i, dp) % mod);   will still give overflow
            ans = (ans + solution(n - i, dp)) % mod;
        }
        return dp[n] = ans;
    }
    private static long bottomUpSolution(int n, long[] dp){
        int mod = 1_000_000_007;
        dp[0] = 1;
        for(int i = 1;i<=n; i++){
            for(int j = 1; j<=6; j++){
                if(j<=i){
                    dp[i] = (dp[i] + dp[i-j])% mod;
                }
            }
        }
        return dp[n];
    }

    // Template for Fast IO....
// use this snippet for efficient IO operations` (taking input of Long type)
    static class Reader extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;
        // standard input
        public Reader() { this(System.in, System.out); }
        public Reader(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }
        // USACO-style file input
        public Reader(String problemName) throws IOException {
            super(problemName + ".out");
            r = new BufferedReader(new FileReader(problemName + ".in"));
        }
        // returns null if no more input
        public String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) { }
            return null;
        }
        public int nextInt() { return Integer.parseInt(next()); }
        public double nextDouble() { return Double.parseDouble(next()); }
        public long nextLong() { return Long.parseLong(next()); }
    }

}
