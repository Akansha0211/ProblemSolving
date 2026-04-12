package CSESProblems;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MinimizingCoins {
    /*
     * if the coins are {1,5,7} and the desired sum is 11, an optimal solution is 5+5+1 which requires 3 coins.
     * */
    public static void main(String[] args) {
        Reader io = new Reader();
        int n = io.nextInt();
        int x = io.nextInt();
        int[] coins = new int[n];
        for(int i = 0;i<n; i++){
            coins[i] = io.nextInt();
        }

        // you see the state depends on index, x --> 2D dp . This can also be done with 1D DP (iterating over all the indexes for a state n)
//        int[][] dp = new int[n][x+1];
//        for(int[] row : dp){
//            Arrays.fill(row , -1);
//        }
//        int ans = solution(0, coins, x, dp); // x here is the desired sum
//        if(ans == Integer.MAX_VALUE)ans = -1;
//        System.out.println(ans);

        /*----------------------------------------------------*/

//        int[] dp = new int[x+1];
//        Arrays.fill(dp, -1);
//        int ans = efficientSolution(x, coins, dp);
//        if(ans == Integer.MAX_VALUE)ans = -1;
//        System.out.println(ans);

        /*--------------------------------------------------*/

        int ans = bottomUp(x, coins);
        if(ans == Integer.MAX_VALUE) ans = -1;
        System.out.println(ans);

    }

    // bottom up approach : making up the answer from smaller values till the answer
    private static int bottomUp(int x, int[] coins){
        int[] dp = new int[x+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i<= x; i++){
            for(int j = 0; j<coins.length; j++){
                if(coins[j] <= i && dp[i-coins[j]] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i], 1+ dp[i-coins[j]]);
                }
            }
        }
        return dp[x];
    }

    // This approach is better : But still gives TLE on 3 test cases
    private static int efficientSolution(int x, int[] coins, int[] dp){
        if(x == 0) return 0;
        if(x < 0) return Integer.MAX_VALUE;
        if(dp[x] !=-1)return dp[x];
        int ans = Integer.MAX_VALUE;
        for(int i = 0;i<coins.length; i++){
            if(coins[i] <= x){
                int val = efficientSolution(x- coins[i], coins, dp);
                if( val != Integer.MAX_VALUE) ans = Math.min(ans, val+1);
//                ans = Math.min(ans, 1 + efficientSolution(x- coins[i], coins));
            }
        }
        return dp[x]=  ans;
    }

    /*
    * This approach dp state --> f(index, x) --> take and not Take approach
    * If you take at any index , you can again take it
    * But this approach gives TLE since the constraints are : x<=10^6, n <=10^2
    *
    * Now we try another approach, dp state --> f(x) --> looping over the coins at each state,
    * will take a coin only if its value <= x
    * */
    private static int solution(int index, int[] coins, int x, int[][] dp){
        if(x == 0)return 0;
        if(x <0 || index >= coins.length)return Integer.MAX_VALUE;
        int take = Integer.MAX_VALUE;
        if(dp[index][x] != -1)return dp[index][x];
        if(coins[index] <= x){
//            take = 1 + solution(index, coins, x-coins[index]);
            take = solution(index, coins, x-coins[index], dp);
            if(take !=Integer.MAX_VALUE) take+=1;

        }
        int dontTake = solution(index+1, coins, x, dp);
        return dp[index][x] = Math.min(take, dontTake);
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
