//Given two strings s and t, determine if they are isomorphic.
//Two strings s and t are isomorphic if the characters in s can be replaced to get t.

import java.util.Scanner;
import java.util.Arrays;

public class Isomorphic_String_205 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the first string:");
        String s = sc.nextLine();

        System.out.println("Enter the second string:");
        String t = sc.nextLine();

        Isomorphic_String_205 isomorphicString = new Isomorphic_String_205();
        boolean isIsomorphic = isomorphicString.isIsomorphic(s, t);

        System.out.println(isIsomorphic);

    }
    public boolean isIsomorphic(String s, String t) {
        int sToTMap[] = new int[128];
        int tToSMap[] = new int[128];
        Arrays.fill(sToTMap,-1);
        Arrays.fill(tToSMap,-1);
        StringBuilder sbS =new StringBuilder(s);
        StringBuilder sbT =new StringBuilder(t);
        int n =s.length();
        for(int i=0;i<n;i++){
            char s1 = sbS.charAt(i);
            char t1 = sbT.charAt(i);
            if(sToTMap[s1] == -1){
                sToTMap[s1] = t1;
            }
            if(tToSMap[t1] == -1){
                tToSMap[t1] = s1;
            }
            if(sToTMap[s1]!=t1 ||tToSMap[t1]!=s1 ){
                return false;
            }

        }
        return true;
    }
}
