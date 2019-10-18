import java.util.HashMap;
import java.util.Scanner;

public class polyalpha {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
		Scanner scan=new Scanner(System.in);
		System.out.println("Entern the key");
		String key=scan.nextLine();
		n=key.length();
		char a[][]=new char[n+1][27];
		for(int i=1;i<n+1;i++)
		{
			a[i][0]=key.charAt(i-1);
		}
		for(int i=1;i<=26;i++)
		{
			a[0][i]=(char)(i+96);
		}
		int s;
		int diff;
			for(int i=1;i<n+1;i++)
			{
			s=(int)a[i][0];
				for(int j=1;j<27;j++)
				{
				if(s>122)
					s=97;
				a[i][j]=(char)s;
				s=s+1;
				}
			//System.out.println();
			}
			for(int i=0;i<n+1;i++)
			{
				for(int j=0;j<27;j++)
				{
			System.out.print(a[i][j]+" ");
				}
			System.out.println();
			}
		System.out.println("Encryption Started enter plain text");
		
		String plain=scan.nextLine();
		HashMap<Character,Character> h = new HashMap<Character,Character>();
		String ciph="";
		String ptxt[]=plain.split("\\s+");
		for(int k=0;k<ptxt.length;k++)
		{
		System.out.println(ptxt[k]);
			for(int i=0,j=1;i<ptxt[k].length();i++,j++)
			{
				ciph+=a[j][(((int)ptxt[k].charAt(i))-97)+1];
				if(j>key.length()-1)
					{j=0;}
				//System.out.print(ciph);
			}
			ciph+=" ";
		}

		System.out.println("ciphered text is"+ciph);
	
	System.out.println("dycryption started enter cipher text");
	String p=scan.nextLine();
	String ctxt[]=p.split("\\s+");
	String p2="";
	diff=0;
	for(int k=0;k<ctxt.length;k++)
	{
		for(int i=0,j=0;i<ctxt[k].length();i++,j++)
		{
			if(j>key.length()-1)
				j=0;
			diff=0;
		diff=ctxt[k].charAt(i)-((int)key.charAt(j));
				if(diff<0)
					diff+=26;
				
			p2+=a[0][diff+1];
		}
	p2+=" ";
		
	}
	System.out.println("decoded String is"+p2);
}
}
