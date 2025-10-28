package Practice22AugDay2;


import java.util.Scanner;

/*
* https://codeforces.com/problemset/problem/2122/B
*
*
* NOT ACCEPTED..  (REVISE THE APPROACH)
* */
public class PileShuffling {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int ans = 0;
            for(int i = 0; i<n; i++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                int c = sc.nextInt();
                int d = sc.nextInt();

                if(b> d){
                    ans+= a + (b-d);
                }
                else if(a> c)ans+=(a-c);
            }
            System.out.println(ans);
        }
    }
}
