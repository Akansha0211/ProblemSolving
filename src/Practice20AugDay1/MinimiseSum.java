package Practice20AugDay1;

import java.util.Scanner;

/*
* https://codeforces.com/problemset/problem/2124/B
*
* Approach :
* a1 a2 a3 a4 a5
* if a1 > a2 ==> a1 + a2
*
* a1 a2 a3 a4 a5
* if a1 < a2 ==>  a1  (a2 + a3) 0 .... ==> min prefix array ==> a1 a1 0 0 ......all zeroes
* answer is 2* a1
*
* */
public class MinimiseSum {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i<n; i++){
                arr[i] = sc.nextInt();
            }
            int a1 = arr[0];
            int a2 = arr[1];
            if(a1 >= a2){
                System.out.println(a1+ a2);
            }else if(a1 < a2){
                System.out.println(2* a1);
            }

        }
    }

}
