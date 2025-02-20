import java.util.Scanner;
class Read_data 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);//it us use for reading the data in run time
		System.out.print("Enter value of  a : ");
		int a=sc.nextInt();
		System.out.print("Enter value of b : ");
		int b=sc.nextInt();
		int c=a+b;
		System.out.println("The sum of given two numbers "+a+" and "+b+" is "+c);
	}
}
