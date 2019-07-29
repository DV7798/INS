
import java.util.Scanner;


public class DES {
    
    public static String hexToBin(String s)
    {
        String temp="";
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            switch(c)
                    {
                        case '0':
                        temp=temp+"0000";
                        break;
                        case '1':
                        temp=temp+"0001";
                        break;
                        case '2':
                        temp=temp+"0010";
                        break;
                        case '3':
                        temp=temp+"0011";
                        break;
                        case '4':
                        temp=temp+"0100";
                        break;
                        case '5':
                        temp=temp+"0101";
                        break;
                        case '6':
                        temp=temp+"0110";
                        break;
                        case '7':
                        temp=temp+"0111";
                        break;
                        case '8':
                        temp=temp+"1000";
                        break;
                        case '9':
                        temp=temp+"1001";
                        break;
                        case 'a':
                        temp=temp+"1010";
                        break;
                        case 'b':
                        temp=temp+"1011";
                        break;
                        case 'c':
                        temp=temp+"1100";
                        break;
                        case 'd':
                        temp=temp+"1101";
                        break;
                        case 'e':
                        temp=temp+"1110";
                        break;
                        case 'f':
                        temp=temp+"1111";
                        break;  
                    }           
        }
        return temp;
    }
    
    public static String binToHex(String s)
    {
        String temp="",temp1="";
        for(int i=0;i<s.length()/4;i++)
        {
            temp=s.substring(i*4, i*4+4);
            
            temp1+=Integer.toHexString(Integer.parseInt(temp,2));
//            if(temp.equals("0000"))
//                temp1=temp1+"0";
//            else if(temp.equals("0001"))
//                temp1=temp1+"1";
//            else if(temp.equals("0010"))
//                temp1=temp1+"2";
//            else if(temp.equals("0011"))
//                temp1=temp1+"3";
//            else if(temp.equals("0100"))
//                temp1=temp1+"4";
//            else if(temp.equals("0101"))
//                temp1=temp1+"5";
//            else if(temp.equals("0110"))
//                temp1=temp1+"6";
//            else if(temp.equals("0111"))
//                temp1=temp1+"7";
//            else if(temp.equals("1000"))
//                temp1=temp1+"8";
//            else if(temp.equals("1001"))
//                temp1=temp1+"9";
//            else if(temp.equals("1010"))
//                temp1=temp1+"a";
//            else if(temp.equals("1011"))
//                temp1=temp1+"b";
//            else if(temp.equals("1100"))
//                temp1=temp1+"c";
//            else if(temp.equals("1101"))
//                temp1=temp1+"d";
//            else if(temp.equals("1110"))
//                temp1=temp1+"e";
//            else if(temp.equals("1111"))
//                temp1=temp1+"f";
        }
        return temp1;
    }
    
    public static String initial_permutation(String s)
    {
        int initial_perm[]=new int[]  
        {   58,50,42,34,26,18,10,2, 
            60,52,44,36,28,20,12,4, 
            62,54,46,38,30,22,14,6, 
            64,56,48,40,32,24,16,8, 
            57,49,41,33,25,17,9,1, 
            59,51,43,35,27,19,11,3, 
            61,53,45,37,29,21,13,5, 
            63,55,47,39,31,23,15,7 
        };  
        String temp="";
        for(int i=0;i<s.length();i++)
        {
            temp=temp+s.charAt(initial_perm[i]-1);
        }
        return temp;
    }
    
    public static String permuted_choice1(String s)
    {
        String temp="";
        int pc1[]=new int[]
        {
          57,49,41,33,25,17,9,
          1,58,50,42,34,26,18,
          10,2,59,51,43,35,27,
          19,11,3,60,52,44,36,
          63,55,47,39,31,23,15,
          7,62,54,46,38,30,22,
          14,6,61,53,45,37,29,
          21,13,5,28,20,12,4      
        };
        
        for(int i=0;i<pc1.length;i++)
        {
            temp=temp+s.charAt(pc1[i]-1);
        }
        return temp;
    }
    
    public static String left_circular_shift(String s,int shift)
    {
        String left=s.substring(0,s.length()/2);
        String right=s.substring(s.length()/2);
        
        left=left.substring(shift)+left.substring(0,shift);
        right=right.substring(shift)+right.substring(0,shift);
        
        return (left+right);
    }
    
    public static String permuted_choice2(String s)
    {
        int pc2[]= new int[]
        {   14,17,11,24,1,5, 
            3,28,15,6,21,10, 
            23,19,12,4,26,8, 
            16,7,27,20,13,2, 
            41,52,31,37,47,55, 
            30,40,51,45,33,48, 
            44,49,39,56,34,53, 
            46,42,50,36,29,32 
        };
        String temp="";
        
        for(int i=0;i<pc2.length;i++)
        {
            temp=temp+s.charAt(pc2[i]-1);
        }
        return temp;
    }
    
    public static String round(String s,String key)
    {
        String left=s.substring(0,s.length()/2);
        String right=s.substring(s.length()/2);
        
        //Expansion E-box Table 
	int exp_e[]= new int[]
	{       32,1,2,3,4,5,4,5, 
		6,7,8,9,8,9,10,11, 
		12,13,12,13,14,15,16,17, 
		16,17,18,19,20,21,20,21, 
		22,23,24,25,24,25,26,27, 
		28,29,28,29,30,31,32,1 
	};
        String temp="";
        
        for(int i=0;i<exp_e.length;i++)
        {
            temp=temp+right.charAt(exp_e[i]-1);
        }
       
        temp=exor(temp,key);
          
        //S-box Table 
	int s_box[][][]= new int[][][]
	{{ 
            {14,4,13,1,2,15,11,8,3,10,6,12,5,9,0,7}, 
            {0,15,7,4,14,2,13,1,10,6,12,11,9,5,3,8}, 
            {4,1,14,8,13,6,2,11,15,12,9,7,3,10,5,0}, 
            {15,12,8,2,4,9,1,7,5,11,3,14,10,0,6,13} 
	}, 
	{ 
            {15,1,8,14,6,11,3,4,9,7,2,13,12,0,5,10}, 
            {3,13,4,7,15,2,8,14,12,0,1,10,6,9,11,5}, 
            {0,14,7,11,10,4,13,1,5,8,12,6,9,3,2,15}, 
            {13,8,10,1,3,15,4,2,11,6,7,12,0,5,14,9} 
	}, 


	{ 
            {10,0,9,14,6,3,15,5,1,13,12,7,11,4,2,8}, 
            {13,7,0,9,3,4,6,10,2,8,5,14,12,11,15,1}, 
            {13,6,4,9,8,15,3,0,11,1,2,12,5,10,14,7}, 
            {1,10,13,0,6,9,8,7,4,15,14,3,11,5,2,12} 
	}, 
	{ 
            {7,13,14,3,0,6,9,10,1,2,8,5,11,12,4,15}, 
            {13,8,11,5,6,15,0,3,4,7,2,12,1,10,14,9}, 
            {10,6,9,0,12,11,7,13,15,1,3,14,5,2,8,4}, 
            {3,15,0,6,10,1,13,8,9,4,5,11,12,7,2,14} 
	}, 
	{ 
            {2,12,4,1,7,10,11,6,8,5,3,15,13,0,14,9}, 
            {14,11,2,12,4,7,13,1,5,0,15,10,3,9,8,6}, 
            {4,2,1,11,10,13,7,8,15,9,12,5,6,3,0,14}, 
            {11,8,12,7,1,14,2,13,6,15,0,9,10,4,5,3} 
	}, 
	{ 
            {12,1,10,15,9,2,6,8,0,13,3,4,14,7,5,11}, 
            {10,15,4,2,7,12,9,5,6,1,13,14,0,11,3,8}, 
            {9,14,15,5,2,8,12,3,7,0,4,10,1,13,11,6}, 
            {4,3,2,12,9,5,15,10,11,14,1,7,6,0,8,13} 
	}, 
	{ 
            {4,11,2,14,15,0,8,13,3,12,9,7,5,10,6,1}, 
            {13,0,11,7,4,9,1,10,14,3,5,12,2,15,8,6}, 
            {1,4,11,13,12,3,7,14,10,15,6,8,0,5,9,2}, 
            {6,11,13,8,1,4,10,7,9,5,0,15,14,2,3,12} 
	}, 
	{ 
            {13,2,8,4,6,15,11,1,10,9,3,14,5,0,12,7}, 
            {1,15,13,8,10,3,7,4,12,5,6,11,0,14,9,2}, 
            {7,11,4,1,9,12,14,2,0,6,10,13,15,3,5,8}, 
            {2,1,14,7,4,10,8,13,15,12,9,0,3,5,6,11} 
	}}; 
        String temp1="";
        for(int i=0;i<8;i++)
        {
            String t=temp.substring(i*6, i*6+6);
            String r=""+t.charAt(0)+t.charAt(5);
            String c=""+t.charAt(1)+t.charAt(2)+t.charAt(3)+t.charAt(4);
            int row=Integer.parseInt(r,2); 
            int col=Integer.parseInt(c,2); 
            String hex=Integer.toHexString(s_box[i][row][col]);
            temp1=temp1+hexToBin(hex);
        }
        
        //Permutation Table in Round 
	int per[]= new int[]
	{       16,7,20,21, 
		29,12,28,17, 
		1,15,23,26, 
		5,18,31,10, 
		2,8,24,14, 
		32,27,3,9, 
		19,13,30,6, 
		22,11,4,25 
	};
        temp="";
        for(int i=0;i<per.length;i++)
        {
            temp=temp+temp1.charAt(per[i]-1);
        }
        
        temp1=exor(left,temp);
        
        s=right+temp1;
        
        return s;
        
    }
    
    public static String exor(String a,String b)
    {
        String temp="";
        int x,y,i;
        for(i=0;i<a.length()-1;i++)
        {
            x=Integer.parseInt(a.substring(i, i+1));
            y=Integer.parseInt(b.substring(i, i+1));
            if(x==y)
                temp=temp+"0";
            else
                temp=temp+"1";
        }
        x=Integer.parseInt(a.substring(i));
        y=Integer.parseInt(b.substring(i));
        if(x==y)
                temp=temp+"0";
            else
                temp=temp+"1";
        
        return temp;
    }
    
    
    public static void main(String[] args) {
        
        /*
        plain text="123456ABCD132536";
        key="AABB09182736CCDD";
        cipher text="
        */
        
        Scanner sc=new Scanner(System.in);
        
        System.out.println("Enter the Plain Text :");
        String pt=sc.nextLine();
        
        System.out.println("Enter the Key");
        String key=sc.nextLine();
        
//        String pt="123456ABCD132536";
        pt=pt.toLowerCase();
//        String key="AABB09182736CCDD";
        key=key.toLowerCase();
        
        pt=hexToBin(pt);
        key=hexToBin(key);
        
        pt=initial_permutation(pt);
        System.out.println("Plain Text after Initial Permutation is : ");
        System.out.println(binToHex(pt));
        
        key=permuted_choice1(key);
        System.out.println("Key after Permuted Choice 1 is : ");
        System.out.println(binToHex(key));
        
        int shift_num[]=new int[] 
        {   1, 1, 2, 2, 
            2, 2, 2, 2,  
            1, 2, 2, 2,  
            2, 2, 2, 1 
        }; 
        
        String round_key;
        
        for(int i=0;i<16;i++)
        {
            int shift=shift_num[i];
            key=left_circular_shift(key,shift);
            System.out.println("key after Left Circular Shift no."+(i+1)+" :");
            System.out.println(binToHex(key));
            
            round_key=permuted_choice2(key);
            System.out.println("Key after Permuted Choice 2 for Round no."+(i+1)+" :");
            System.out.println(binToHex(round_key));
            
            pt=round(pt,round_key);
            System.out.println("Text after Round no."+(i+1)+" :");
            System.out.println(binToHex(pt));
        }
        
        //32 bit swapping
        pt=pt.substring(pt.length()/2)+pt.substring(0, pt.length()/2);
        
        //Final Permutation Table 
	int final_perm[]= new int[]
	{       40,8,48,16,56,24,64,32, 
		39,7,47,15,55,23,63,31, 
		38,6,46,14,54,22,62,30, 
		37,5,45,13,53,21,61,29, 
		36,4,44,12,52,20,60,28, 
		35,3,43,11,51,19,59,27, 
		34,2,42,10,50,18,58,26, 
		33,1,41,9,49,17,57,25 
	}; 
        
        String temp="";
        for(int i=0;i<final_perm.length;i++)
        {
            temp=temp+pt.charAt(final_perm[i]-1);
        }
        pt=temp;
        
        System.out.println("Cipher Text is : "+binToHex(pt));
        
    }
    
}