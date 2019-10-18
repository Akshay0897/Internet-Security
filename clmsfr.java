import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class clmsfr {

	public static void main(String args[]){
		
		System.out.println("welcome");
		Scanner scan=new Scanner(System.in);
		System.out.println("enter plain txt");
		String ptxt=scan.nextLine();
		System.out.println("Enter key");
		String key=scan.nextLine();
		double len=key.length();
		int order[]=new int[key.length()];
	//	String order="";
		char[] b=key.toCharArray();
		Arrays.sort(b);
		String o=new String(b);
		String dup=o;
		int pos=0;
		for(int i=0;i<key.length();i++)
		{
			pos=dup.indexOf(key.charAt(i))+1;
		//	System.out.print(pos);
			dup=dup.substring(0,pos-1)+' '+dup.substring(pos);
			order[i]=pos;
		}
		String d=ptxt.replaceAll("\\s+","");
		int row=(int)Math.ceil((double)d.length()/len);
		char a[][]=new char[row][key.length()];
	//	System.out.println(d);
		int k=0;
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<key.length();j++)
			{
				if(k<d.length())
				a[i][j]=d.charAt(k);
				k=k+1;
			}
		}
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<key.length();j++)
			{
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
		String cipher="";
		int m=0;
		for(int i=0;i<order.length;i++)
		{
			m=order[i]-1;
			for(int l=0;l<row;l++)
			{
				if(a[l][m]>=97 && a[l][m]<=127)
				cipher+=a[l][m];
				else
				cipher+='@';
			}
		//	System.out.println(cipher);
		}
		System.out.println("ciphered text is  "+cipher);
	
		System.out.println("at decryption side");
		
		int length=(int)Math.ceil((double)cipher.length()/len);
		char q[][]=new char[length][key.length()];
		k=0;
		for(int i=0;i<key.length();i++)
		{
			m=order[i]-1;
			if(k<cipher.length())
			for(int j=0;j<row;j++)
			{
			q[j][m]=cipher.charAt(k);
			k=k+1;
			}
		}
		String decode="";
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<key.length();j++)
			{
				if(q[i][j]>=97 && q[i][j]<=127)
				{
				System.out.print(q[i][j]+" ");
				decode+=q[i][j];	
				}
			}
			System.out.println();
		}
		System.out.println("decoded string is  "+decode);
	}		
}