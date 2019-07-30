
import java.util.Scanner;


public class Hill_Cipher
{
    
    public static void substitute(int a[],String s)
    {
        for(int i=0;i<s.length();i++)
        {
            a[i]=s.charAt(i)-97;
        }
    }
    
    public static int[] multiply(int k[][],int a[])
    {
        int b[]=new int[a.length];
        for(int i=0;i<a.length;i++)
        {
            int temp=0;
            for(int j=0;j<a.length;j++)
            {
                temp=temp+k[i][j]*a[j];
            }
            b[i]=temp%26;
        }
        return b;
    }
    
    public static void main(String[] args) {
        
        /*
        key size = 3
        key values = 17 17 5 21 18 21 2 2 19
        */
        
        int key;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Key size : ");
        key=sc.nextInt();
        
        int k[][]=new int[key][key];
        
        System.out.println("Enter Key values : ");
        for(int i=0;i<key;i++)
        {
            for(int j=0;j<key;j++)
            {
                k[i][j]=sc.nextInt();
            }
        }
        sc.nextLine();
        System.out.println("Enter the Plain Text : ");
        String pt=sc.nextLine();
        pt=pt.toLowerCase();
        
        if(pt.length()%key!=0)
        {
            if(pt.charAt(pt.length()-1)=='x')
            {
                String temp="yyyyyyyyyy";
                pt=pt+temp.substring(0, key-pt.length()%key);
            }
            else
            {
                String temp="xxxxxxxxxx";
                pt=pt+temp.substring(0, key-pt.length()%key);
            }
        }
        String cipher="";
        for(int i=0;i<pt.length()/key;i++)
        {
            int a[]=new int[key];
            substitute(a,pt.substring(i*key, i*key+key));
            a=multiply(k,a);
            
            for(int j=0;j<key;j++)
            {
                char c=(char)(a[j]+97);
                cipher=cipher+c;
            }
            
        }
        
        System.out.println("Cipher = "+cipher);
        
        
    }
}