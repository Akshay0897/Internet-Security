import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class monocipher {
	
	public static void main(String args[])
	{
	System.out.println("welcome to monocipher");
	char ch;
	ArrayList<Character> list=new ArrayList<Character>();
	HashMap<Character,Character> map=new HashMap<Character,Character>();
	for(int i=97;i<123;i++)
	{
		list.add((char)i);
	}
	System.out.print("enter your choice"+"\n"+"1)for find your desired patterns"+"\n"+"2)to set your key"+"\n"+"3)to encrypt text"+"\n"+"4)to dycrypt text"+"\n"+"5)to Exit");
	Scanner scan=new Scanner(System.in);
	int k=1;
	while(true){
		ch=scan.next().charAt(0);
		if(k==1)
			while(!(ch=='1'))
			{
				ch=scan.next().charAt(0);
			}
		k++;
		switch(ch)
		{
		case '1':Collections.shuffle(list);
		for(int i=0;i<list.size();i++)
		{
			System.out.print(list.get(i));
		}
			break;
		case '2':System.out.println("yout key is");
		for(int i=0;i<list.size();i++)
		{
			map.put((char)(i+97),list.get(i));
			System.out.print(list.get(i));
		}
			//System.out.println(map);
				break;
		case '3':System.out.println("Enter your plane text");
				scan.nextLine();
				String s=scan.nextLine();
				s=s.replaceAll("\\s+","");
				char a[]=s.toCharArray();
				String cipher="";
				for(int i=0;i<a.length;i++)
				{
					cipher+=map.get(a[i]);
				}
				System.out.println("your cipher text is");
				System.out.println(cipher);
				break;
		case '4':
			System.out.println("Enter cipher text recieved by you");
			scan.nextLine();
			String s1=scan.nextLine();
			char a1[]=s1.toCharArray();
			String plain="";
			HashMap<Character,Character> map1=new HashMap<Character,Character>();
			for(int i=0;i<26;i++)
			{
				map1.put(list.get(i),(char)(i+97));
			}
		//	System.out.println(map1);
			for(int i=0;i<a1.length;i++)
			{
				plain+=map1.get(a1[i]);
			}
			System.out.println("your plain text is");
			System.out.println(plain);
			break;
		case '5':
			System.out.println("you exited");
			System.exit(1);
		break;
		}
	}
	
 }
}
