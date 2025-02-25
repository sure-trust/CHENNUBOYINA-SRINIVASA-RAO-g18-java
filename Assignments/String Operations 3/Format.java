import java.util.Scanner;
class  
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		String str1="I am %s i am from %s my age is %d";
		System.out.println("Enter your name");
		String str2=sc.next();
		System.out.println("Enter your city");
		String str3=sc.next();
		System.out.println("Enter your age");
		int age=sc.nextInt();
		System.out.println(String.format(str1,str2,str3,age));
	}
}