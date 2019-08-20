
import java.util.ArrayList;
import java.util.Scanner;


public class RowTransposition {

    /*
    key = 4 3 1 2 5 6 7
    plaintext = attackpostponeduntiltwoam
    */
    
    public static String encrypt(ArrayList a,char b[][])
    {
        int len=a.size();
        String s="";
        int p=1;
        for(int i=0;i<len;i++)
        {
            int pos=a.indexOf(p++);
            for(int j=0;j<b.length;j++)
            {
                s=s+b[j][pos];
            }
        }
        
        return s;
    }
    
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        
        System.out.println("Enter the Size of Key : ");
        
        int len=sc.nextInt();
        ArrayList a=new ArrayList(len);
        System.out.println("Enter the key value : ");
        
        for(int i=0;i<len;i++)
        {
            a.add(sc.nextInt());
        }
        
        sc.nextLine();
        
        System.out.println("Enter the PlainText : ");
        String pt=sc.nextLine();
        String st[]=pt.split(" ");
        pt="";
        for(int q=0;q<st.length;q++)
        {
            pt=pt+st[q];
        }
        
        
        int row=(int)Math.ceil((float)pt.length()/len);
        System.out.println("row = "+row);
        char b[][]=new char[row][len];
        int k=0,j=0,i;
        for(i=0;i<row;i++)
        {
            for(j=0;j<len&&k<pt.length();j++)
            {
                b[i][j]=pt.charAt(k++);
            }
        }
        
        
        for(i=j;i<len;i++)
        {
            b[row-1][i]='x';
        }
        
        String cipher=encrypt(a,b);

        System.out.println("Cipher text is : "+cipher);
    }
    
}
