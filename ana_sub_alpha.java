import java.util.Arrays;
import java.util.Scanner;

public class ana_sub_alpha {
    public static void main (String args []) throws ArrayIndexOutOfBoundsException {
        Scanner sc = new Scanner (System.in);
        System.out.println ("Enter the SuperString (Ex: Google): ");
        String S = sc.nextLine ();
        System.out.println ("Enter the SubString (Ex: elg)");
        String T = sc.nextLine ();
        
        int chars [] = new int [26];
        int bkp [] = new int [26];
        S = S.toLowerCase ();
        T = T.toLowerCase ();
        int len = T.length();
        int bkplen = len;
        for (int i=0; i<len; i++) {
            chars [((int)T.charAt(i))-97] += 1;
        }
        bkp = Arrays.copyOf(chars, chars.length);
        boolean isFound = false;
        for (int i=0; i<S.length(); i++) {
            if (!isFound) {
                if (chars[((int)S.charAt(i)) - 97] > 0) {
                    chars[((int)S.charAt(i)) - 97] -=1;
                    len -= 1;
                    if (len == 0) {
                        isFound = true;
                    }
                } else if (bkp[((int)S.charAt(i)) - 97] > 0) {
                    len = bkplen;
                    chars = Arrays.copyOf(bkp, bkp.length);
                    i -= 1;
                } else {
                    len = bkplen;
                    chars = Arrays.copyOf(bkp, bkp.length);
                }
            }
        }
        if (isFound) {
            System.out.println ("True");
        } else {
            System.out.println ("False");
        }
    }
}