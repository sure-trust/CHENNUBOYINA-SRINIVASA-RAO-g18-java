import java.util.Scanner;
class Combine
{
	public static void main(String args[])
	{
		System.out.println("enter the two strings");
		Scanner sc=new Scanner(System.in);
		String str1=sc.next();
		String str2=sc.next();
		System.out.println("the combination of the two strings "+str1.concat(str2));
	}
}