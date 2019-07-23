
import java.util.Scanner;

/**
 *
 *
 *
 * @author s16it14
 *
 */

public class PlayFair {

    public static String remove_repeated_chars(String key) {

        String temp = "";

        for (int i = 0; i < key.length(); i++) {

            char c = key.charAt(i);

            if (temp.indexOf(c) == -1) {

                temp = temp + c;

            }

        }

        return temp;

    }

    public static String add_junk(String text) {
        for (int i = 0; i < text.length() - 1; i = i + 2) {

            char c1 = text.charAt(i);

            char c2 = text.charAt(i + 1);

            if (c1 == c2) {

                if (c1 == 'X') {
                    text = text.substring(0, i + 1) + "Y" + text.substring(i + 1);
                } else {
                    text = text.substring(0, i + 1) + "X" + text.substring(i + 1);
                }

            }

        }

        if (text.length() % 2 != 0) {
            text += (text.charAt(text.length() - 1) == 'X') ? 'Y' : 'X';
        }

        return text;

    }

    public static String encrypt(String s, char a[][]) {
        char p = s.charAt(0);
        char q = s.charAt(1);
        int flag = 0;
        int pos[] = new int[4];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (a[i][j] == p) {
                    pos[0] = i;
                    pos[1] = j;
                    flag++;
                }
                if (a[i][j] == q) {
                    pos[2] = i;
                    pos[3] = j;
                    flag++;
                }
            }
            if (flag == 2) {
                break;
            }
        }

        //System.out.println("pos= "+pos[0]+pos[1]+pos[2]+pos[3]);
        String cipher = "";
        if (pos[0] == pos[2]) {
            cipher = "" + a[pos[0]][(pos[1] + 1) % 5] + a[pos[2]][(pos[3] + 1) % 5];
        } else if (pos[1] == pos[3]) {
            cipher = "" + a[(pos[0] + 1) % 5][pos[1]] + a[(pos[2] + 1) % 5][pos[3]];
        } else {
            cipher = "" + a[pos[0]][pos[3]] + a[pos[2]][pos[1]];
        }

        return cipher;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the key:");

        String key = sc.nextLine();

        key = key.toUpperCase();

        key = key.replace('J', 'I');

        System.out.println("Enter the PlainText:");

        String text = sc.nextLine();

        text = text.toUpperCase();

        key = key.replace('J', 'I');

        char a[][] = new char[5][5];

        key = remove_repeated_chars(key);

        int i = 0, j = 0, k = 0, alpha = 0, flag = 0;

//        ABC:
        for (j = 0; j < 5; j++) {

            for (k = 0; k < 5; k++) {

                if (i < key.length()) {

                    char c = key.charAt(i);

                    a[j][k] = c;
                    System.out.print(" "+a[j][k]+" ");

                    i++;

                } else {
                    flag = 1;
                }

//                   break ABC;
//                   break;
            }

            if (flag == 1) {
                break;
            }

        }

        j=key.length()/5;
        k=key.length()%5;
                
        System.out.println("j="+j+"k="+k);
        for (; j < 5; j++) {

            for (; k < 5;) {

                char c = (char) (65 + alpha);

                if (key.indexOf(c) == -1 && c != 'J') {

                    a[j][k] = c;

//                    System.out.print(a[j][k]+" ");
                    k++;

                }

                alpha++;

            }

            k = 0;

        }

        for(i=0;i<5;i++)

        {

            for(j=0;j<5;j++)

            {

                System.out.print(a[i][j]);

            }

            System.out.println();

        }
        text = add_junk(text);

        System.out.println("text= " + text);
        String cipher = "";
        for (i = 0; i < text.length(); i = i + 2) {
            cipher = cipher + encrypt(text.substring(i, i + 2), a);
        }

        System.out.println("Cipher text = " + cipher);
    }

}          
