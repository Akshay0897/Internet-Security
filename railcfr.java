import java.util.Scanner;

public class railcfr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to rail cipher");
		String ptxt,cipher="",dup="";
		int len=0,k=0;
		Scanner scan=new Scanner(System.in);
		System.out.println("AT encryption side");
		System.out.println("Enter Plain Text");
		ptxt=scan.nextLine();
		ptxt=ptxt.replaceAll("\\s+","");
		len=ptxt.length();
		char[][] a=new char[2][len];
		char[][] decode=new char[2][len];
		for(int i=0;i<len;i++)
		{
			if(i%2==0)
			{
				a[1][i]=ptxt.charAt(k++);
			}
			else
			{
				a[0][i]=ptxt.charAt(k++);
			}
		}
		for(int i=0;i<2;i++)
		{
			for(int j=0;j<len;j++)
			{
				if(a[i][j]>=97 && a[i][j]<=127)
				{
				System.out.print(a[i][j]+" ");
				cipher+=a[i][j];
				}
				else
				System.out.print(' '+" ");	
			}
			System.out.println();
		}
		System.out.println("encrypted text is"+cipher);
		System.out.println("AT decryption side");
		k=0;
		for(int i=0;i<len;i++)
		{
			if(i%2!=0)
			{
				decode[0][i]=cipher.charAt(k++);
			}
		}
		
		for(int i=0;i<len;i++)
		{	
			if(i%2==0)
				decode[1][i]=cipher.charAt(k++);
		
		}
		for(int j=0;j<2;j++)
		{
		 for(int i=0;i<len;i++)
		 {
			
				if(decode[j][i]>=97 && decode[j][i]<=127)
				{
				System.out.print(decode[j][i]+" ");
	
				}
				else
				System.out.print(' '+" ");			
		 }
		 System.out.println();
		}
		
		for(int j=0;j<len;j++)
		 {
			for(int i=0;i<2;i++)
			{
				if(decode[i][j]>=97 && decode[i][j]<=127)
				dup+=decode[i][j];
			}
		}
		System.out.println("decoded String is"+dup);
	}

}
