import java.util.Scanner;
class Index
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the string");
		String str=sc.nextLine();
		System.out.println("Enter the sub sring to find the index of  that string");
		String str2=sc.nextLine();
		System.out.println("the index of the "+str+" is "+str.indexOf(str2));
	}
}