import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class LCS_Mitalivijay_Bhiwande_mitalivi
{
	
	public static String computeLCS(char[] a, char[] b)
	{
		int opt[][]=new int[a.length +1][b.length +1];
		String[][] lcspath=new String[a.length +1][b.length +1];
		for(int i=0;i<a.length;i++)
		{
			opt[i][0]=0;
		}
		for(int i=0;i<b.length;i++)
		{
			opt[0][i]=0;
		}
		
		for(int i=1;i<=a.length;i++)
		{
			
			for(int j=1;j<=b.length;j++)
			{
				if(a[i-1]==b[j-1])
				{
					opt[i][j]=opt[i-1][j-1]+1;
					lcspath[i][j]="diagonal";
				}
				
				else if(opt[i][j-1]>=opt[i-1][j])
				{
					opt[i][j]=opt[i][j-1];
					lcspath[i][j]="left";
				}
				else
				{
					opt[i][j]=opt[i-1][j];
					lcspath[i][j]="top";
					
				}
				
				
			}
		}
		
		String finallcs="";
		int i=a.length;
		int j=b.length;
		
		while(i>0 && j>0)
		{
			//System.out.println(i+" "+j);
			if(lcspath[i][j].equals("diagonal"))
			{
				finallcs=a[i-1]+ finallcs;
				i--;
				j--;
			}
			else if(lcspath[i][j].equals("top"))
			{
				i--;
			}
			else
				j--;
			
		
		}
		//System.out.println(finallcs);
		//System.out.println(finallcs.length());
		return (finallcs);
	}

	public static void main(String args[]) throws Exception
	{
		Scanner scan = new Scanner(new File("test10")); // scanner to read file
		PrintWriter pw= new PrintWriter("output.txt");
		
		
		while(scan.hasNext())
		{
			 String string1=scan.nextLine();
			 String string2=scan.nextLine();
			 String output=computeLCS(string1.toCharArray(), string2.toCharArray());
			// System.out.println(output.length());
			 pw.println(output.length());
			 pw.println(output);
		}
		pw.close();
		scan.close();

	}
}
