import java.util.Scanner;
class EqualsWithoutCase 
{ 
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a two strings to perform equalsIgnoreCase ");
		String str1=sc.next();
		String str2=sc.next();
		if(str1.equalsIgnoreCase(str2))
			System.out.println("this two strings are same");
		else System.out.println("this two strings are not same");
	}
}
