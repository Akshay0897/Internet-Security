import java.util.*;

class hcfr{
		public static int minmode(int a)
		{
		int n=26;
		int res=n-(-a%n);
		return res;
		}
		public static int find(int m)
		{
			int e=1,d=m,n=26;
			while(((e*d)%n!=1))
				e++;
			return e;
			
		}
		public static int determinant(int m,int a[][])
		{
			int m1=a.length;
			if(m1==1)
				return a[0][0];
			else if(m1==2)
				return a[0][0]*a[1][1]-a[0][1]*a[1][0];
			else{
				int det=0,s=0,t=0,i,j,k,x,y;
				int b[][];
				for(i=0;i<m;i++)
				{
				
					b=new int[m-1][m-1];
					for(j=0;j<m;j++)
					{
						 if(j!=0)
					       {
						for(k=0;k<m;k++)
						{   
						if(k!=i)
						{
							b[s][t]=a[j][k];
							t++;
						}
					}
					s++;
				}
				t=0;
			  }
			  s=0;
			  det+=(int)Math.pow(-1,i)*a[0][i]*determinant(m-1,b);
			}
		
			return det;
		}
	}
		public static int[][] inverse(int a[][])
		{
			int n=a.length;
			int adj[][]=new int[n][n];
			int tr[][]=new int[n][n];
			int b[][];
			int s=0,t=0,z,k;
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					tr[i][j]=a[j][i];
				}
			}
			for(z=0;z<n;z++)
			{
				for(int i=0;i<n;i++)
				{
					b=new int[n-1][n-1];
					for(int j=0;j<n;j++)
					{
						if(j!=z){
							for(k=0;k<n;k++)
							{
								if(k!=i)
								{
									b[s][t]=tr[j][k];
									t++;
								}
							}
							s++;
						}
						t=0;
					}
					s=0;
					adj[z][i]=(int)Math.pow(-1,i+z)*determinant(n-1,b);
					System.out.print(adj[z][i]);
				}
				System.out.println();
			}
			
			return adj;
		}
		public static void main(String args[])
		{
			System.out.println("welcome");
			int a[][]={
				{17,17,5},
				{21,18,21},
				{2,2,19},
			};
			int in[][]=new int[3][3];
			System.out.println("your key matrix is");
			for(int i=0;i<3;i++)
			{
				for(int j=0;j<3;j++)
				{
					System.out.print(a[i][j]+"  ");
				}
				System.out.println();
			}
			String key="pay";
			char k[]=key.toCharArray();
			int k1[]=new int[k.length];
			int k2[]=new int[k.length];
			int k3[]=new int[k.length];
			for(int i=0;i<k.length;i++)
			{
				k1[i]=(int)k[i]-97;
			}
				for(int i=0;i<k.length;i++)
			{
		//		System.out.print(k1[i]+" ");
			}
			System.out.println();
			int m=0;
			for(int i=0;i<3;i++)
			{
				m=0;
				for(int j=0;j<3;j++)
				{
					m+=a[i][j]*k1[j];
					
				}
				k2[i]=(m%26);
			}
				for(int i=0;i<k.length;i++)
			{
		//		System.out.print(k2[i]+" ");
			}
			System.out.println("ciphered txt is");
				for(int i=0;i<k.length;i++)
			{
				System.out.print((char)(k2[i]+97)+" ");
			}
		int det=minmode(determinant(3,a));
		 System.out.println("Decryption started"+ det);
		in=inverse(a);
		for(int i=0;i<3;i++)
			{
				
				for(int j=0;j<3;j++)
				{
					if(in[i][j]<0)
					     in[i][j]=minmode(in[i][j]);
					else
					     in[i][j]=in[i][j]%26;
				
					System.out.print(in[i][j]+"  ");
				}
				System.out.println();
			}
			int d=0;
		d=find(det);
		System.out.println(d);
		for(int i=0;i<3;i++)
			{
				
				for(int j=0;j<3;j++)
				{
						
					in[i][j]=((in[i][j]*d)%26);
					System.out.print(in[i][j]+"  ");
				}
				System.out.println();
			}
			for(int i=0;i<3;i++)
			{
				m=0;
				for(int j=0;j<3;j++)
				{
					m+=in[i][j]*k2[j];
					
				}
				k3[i]=(m%26);
			}
				for(int i=0;i<k.length;i++)
			{
			System.out.print(k3[i]+" ");
			}
		
		}
}