import java.util.Scanner;
class Copy 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		char[] str1={'h','e','l','l','o'};
		System.out.println("Enter the starting and ending index");
		String str2="";
		int start=sc.nextInt();
		int end=sc.nextInt();
		str2=str2.copyValueOf(str1,start,end);
		System.out.println(str2);
	}
}
