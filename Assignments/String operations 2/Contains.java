import java.util.Scanner;
class Contains 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the string ");
		String str1=sc.next();
		System.out.println("enter the string to check is it present in the string");
		String str2=sc.next();
		if(str1.contains(str2)){
			System.out.println("it is found");
	}
	else System.out.println("it is not found");
	}
}
