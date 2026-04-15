package CSESProblems.LeetcodeAsked;

public class CountBinarySubstrings {
    public static void main(String[] args) {
        String s = "00110011";
        int ans = countBinarySubstrings(s);
        System.out.println(ans);
    }
    public static int countBinarySubstrings(String s) {
        // 000110011 --> count all subarrays with count_0s == count_1s && 0s and 1s grouped consecutively...
        // Was thinking to do with Sliding Window : But there is another much easier approach

        int prev = 0;
        int curr = 1;
        int ans = 0;
        for(int i = 1; i<s.length(); i++){
            if(s.charAt(i) == s.charAt(i-1))curr+=1;
            else{
                ans += Math.min(prev, curr);
                prev = curr;
                curr = 1;
            }
        }
        // also here for eg 1100 --> then for last index also min val of prev and curr should be added
        ans +=Math.min(prev  , curr);
        return ans;
    }
}
