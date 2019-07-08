
import java.io.*;
import java.util.Scanner;

public class cryptoanalysis {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String freq = "etaoinshrdlcumwfgypbvkjxqz";
//        File f=new File(abc.txt);
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Dharm\\Documents\\NetBeansProjects\\Ingeniuos\\src\\output.txt"));
        String s = "";
        s = reader.readLine();

//        while(reader.readLine()!=null)
//        {
//            s=s+reader.readLine();
//        }
        s = s.toLowerCase();
        int frequency[] = new int[26];

        for (int i = 0; i < s.length(); i++) 
        {
            char c = s.charAt(i);

            if (c >= 97 && c <= 122) 
            {
                frequency[c - 97]++;
            }
        }

        System.out.println("Frequency Distribution is :");
        for (int i = 0; i < 26; i++) 
        {
            System.out.println((char) (i + 97) + "=" + frequency[i]);
        }
        int max, pos = 0;
        String outfreq = "";
        for (int i = 0; i < 26; i++) 
        {
            max = -1;
            pos = -1;
            for (int j = 0; j < 26; j++) 
            {
                if (max < frequency[j]) 
                {
                    max = frequency[j];
                    pos = j;
                }
            }
            outfreq = outfreq + (char) (97 + pos);
            frequency[pos] = -1;
        }
        System.out.println("Frequency String is :" + outfreq);

        for (int i = 0; i < 26; i++) 
        {
            char a = freq.charAt(i);
            char b = outfreq.charAt(i);
            if (a >= 97 && a <= 122) 
            {
                s = s.replace(a, '@');
                s = s.replace(b, a);
                pos = outfreq.indexOf(a);
                char c = freq.charAt(pos);
                s = s.replace('@', c);
                freq = freq.replace(c, '*');
                //outfreq = outfreq.replace(a, '*');
            }
        }

        System.out.println("The data in the file is :");
        System.out.println(s);

        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Dharm\\Documents\\NetBeansProjects\\Ingeniuos\\src\\after.txt"));
        writer.write(s);
        reader.close();
        writer.close();

    }
}
