import java.util.Scanner;
class Endwith
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a String ");
		String str=sc.next();
		System.out.println("Enter an another string to perform end with operation");  
		String substr=sc.next();
		System.out.println(str.endsWith(substr));
	}
}