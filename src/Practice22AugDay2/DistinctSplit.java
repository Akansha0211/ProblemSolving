package Practice22AugDay2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DistinctSplit {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            String s = sc.next();
            Set<Character> setPrefix = new HashSet<>();
            Set<Character> setSuffix = new HashSet<>();

            int[] prefix = new int[n];
            int[] suffix = new int[n];

            for(int i = 0; i<n; i++){
                if(!setPrefix.contains(s.charAt(i))){
                    setPrefix.add(s.charAt(i));
                }
                prefix[i] = setPrefix.size();
            }
            for(int i = n-1; i>=0; i--){
                if(!setSuffix.contains(s.charAt(i))){
                    setSuffix.add(s.charAt(i));
                }
                suffix[i] = setSuffix.size();
            }
            int max = 0;
            for(int i = 0; i<n-1; i++){
                max = Math.max(max, prefix[i] + suffix[i+1]);
            }
            System.out.println(max);

        }
    }

}
