import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
class RSA
{
public static void main(String args[])throws IOException
{
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
System.out.println("Enter 2 Prime nos");
BigInteger p=new BigInteger(br.readLine());
BigInteger q=new BigInteger(br.readLine());
BigInteger  n=p.multiply(q);
BigInteger a=p.subtract(new BigInteger("1"));
BigInteger b=q.subtract(new BigInteger("1"));
a=a.multiply(b);
String s=a.toString();
BigInteger fi=new BigInteger(s); 
System.out.println("Enter the value for e");
BigInteger e=new BigInteger(br.readLine());
while(true)
{
if(!(fi.gcd(e).equals(new BigInteger("1"))))
{
System.out.println("Enter a valid value for e");
e=new BigInteger(br.readLine());
}
else
break;
}
int d=findD(e.intValue(),fi.intValue());
System.out.println("Enter plain text(number):"+d);
BigInteger m=new BigInteger(br.readLine());
BigInteger c= m.pow(e.intValue()).mod(n);
BigInteger x= c.pow(d).mod(n);
System.out.println("Cipher text is:"+c);
if(x.equals(m))
System.out.println("Inputs matched.");
else
System.out.println("Inputs mismatched.");
}

static int findD(int e, int fi)
{
int x;
for(int i=1;i<=fi;i++)
{
x=(i*e)%fi;
if(x==1)
return i;
}
return 0;
}

static int findGCD(int number1, int number2) {
//base case
if(number2 == 0){
return number1;
}
return findGCD(number2, number1%number2);
}
}