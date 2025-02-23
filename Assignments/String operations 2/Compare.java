import java.util.Scanner;
class Compare
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the two strings ");
		String str1=sc.next();
		String str2=sc.next();
		if(str1.compareTo(str2)==0){
			System.out.println("given two strings are same");
		}
		else System.out.println("given two strings are not same");
}}