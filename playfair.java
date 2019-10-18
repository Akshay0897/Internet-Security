import java.util.*;
public class playfair {


	public static String formatkey(String k){
		String key="";
		int flag=0;
		for(int i=0;i<k.length();i++)
		{
			flag=0;
			
			for(int j=0;j<key.length();j++)
			{
				if(key.charAt(j)==k.charAt(i))
					flag=1;
			}
			if(flag==0)
				key+=k.charAt(i);
		}
		
		return key;
	}
	
	public static String genkey(String k)
	{
		String key="",ch;
		int flag=0;
		char a;
		key+=k;
		for(int i=0;i<26;i++)
		{
			a=(char)(i+97);
			if(a=='j')
				continue;
			ch=Character.toString(a);
			if(!key.contains(ch))
			{
				key+=ch;
			}
			
		}
		return key;
	}
	public static char[][] matrix(String k)
	{
		char a[][]=new char[5][5];
		int cnt=0;
		System.out.println(k);
		String key=k;
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
			{
				a[i][j]=key.charAt(cnt);
			//	System.out.print(a[i][j]);
				cnt++;
			}
		}
		return a;
		
	}
	
	public static String genpair(String k)
	{
		String key="";
		for(int i=0;i<k.length()-1;i++)
		{
			
			if(k.charAt(i)==k.charAt(i+1))
			{
			   k=k.substring(0,i+1)+'x'+k.substring(i+1);
			  // System.out.println(k);
			}
		}
		int len=k.length();
		if(k.length()%2!=0)
		{
			k+='x';
			//System.out.println(k);
		}
		
		key=k;
	
		return key;
	}
		public static String find(char a,char b,char map[][])
		{	
			String pos="";
			for(int i=0;i<5;i++)
			{
				for(int j=0;j<5;j++)
				{
					if(map[i][j]==a)
					pos+=Integer.toString(i)+Integer.toString(j)+" ";
				}
			}
			for(int i=0;i<5;i++)
			{
				for(int j=0;j<5;j++)
				{
					if(map[i][j]==b)
					pos+=Integer.toString(i)+Integer.toString(j);
				}
			}
			
			return pos;
		}
		
		public static String encrypt(String s,char a[][])
		{
			String code="";
			String p1="",p2="";
			for(int i=0;i<s.length();i=i+2)
			{
				String pos=find(s.charAt(i),s.charAt(i+1),a);
				p1=pos.substring(0,2);
				p2=pos.substring(3);
				int a1=Character.getNumericValue(p1.charAt(0));
				int a2=Character.getNumericValue(p1.charAt(1));
				int b1=Character.getNumericValue(p2.charAt(0));
				int b2=Character.getNumericValue(p2.charAt(1));
			//	System.out.println(a1+""+a2+b1+""+b2+"convert");
				if(a1==b1)
				{
					if(a2<4 && b2<4)
					{ a2+=1;b2+=1;}
					else if(a2==4)
						{a2=0;b2+=1;}
					else if(b2==4)
						{b2=0;a2+=1;}
					
				}
				else if(a2==b2)
				{
					if(a1<4 && b1<4)
					{ a1+=1;b1+=1;}
					else if(a1==4)
						{a1=0;b1+=1;}
					else if(b1==4)
						{b1=0;a1+=1;}
				}
				else
				{
					int temp=0;
					temp=a2;
					a2=b2;
					b2=temp;
				}
				
				code+=a[a1][a2]+""+a[b1][b2];
			}
			
			return code;
		}
		public static String decrypt(String s,char a[][])
		{
			String code="";
			String p1="",p2="";
			for(int i=0;i<s.length();i=i+2)
			{
				String pos=find(s.charAt(i),s.charAt(i+1),a);
				p1=pos.substring(0,2);
				p2=pos.substring(3);
				int a1=Character.getNumericValue(p1.charAt(0));
				int a2=Character.getNumericValue(p1.charAt(1));
				int b1=Character.getNumericValue(p2.charAt(0));
				int b2=Character.getNumericValue(p2.charAt(1));
			//	System.out.println(a1+""+a2+b1+""+b2+"convert");
				if(a1==b1)
				{
					
					
					 if(a2==0)
						{a2=4;b2-=1;}
					 if(b2==0)
						{b2=4;a2-=1;}
					 else
					 { a2-=1;b2-=1;}
					
				}
				else if(a2==b2)
				{
					if(a1==0)
						{a1=4;b1-=1;}
					if(b1==0)
					   {b1=4;a1-=1;}
					else
					{a1-=1;b1-=1;}
				}
				else
				{
					int temp=0;
					temp=a2;
					a2=b2;
					b2=temp;
				}
				
				code+=a[a1][a2]+""+a[b1][b2];
			}
			
			return code;
		}
		
	public static void main(String args[]){
		
		
		String key,ptxt;
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the key");
		key=scan.nextLine();
		ptxt=key;
		
		key=key.replace('j', 'i');
		System.out.println(key);
		String fkey=formatkey(key);
		//System.out.println("your key is "+fkey);
		String mkey=genkey(fkey);
		//System.out.println("your key is "+mkey);
		System.out.println("matrix is");
		char a[][]=new char[5][5];
		a=matrix(mkey);
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
			{
				System.out.print(a[i][j]+"  ");
			}
			System.out.println();
		}
		ptxt=ptxt.replace('j','i');
		String plain=genpair(ptxt);
		String ip=scan.nextLine().replace('j','i');
		ip=ip.replaceAll("\\s+","");
		ip=genpair(ip);
		String cipher=encrypt(ip,a);
		System.out.println("encrypted text is(cypher text is)"+cipher);
		System.out.println("decrypted text is(cypher text is)"+decrypt(cipher,a));
		
}
}
