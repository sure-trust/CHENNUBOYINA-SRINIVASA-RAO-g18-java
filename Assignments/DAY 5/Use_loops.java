import java.util.Scanner;
class Use_loops 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a positive integer number");
		int a=sc.nextInt();
		int sum=0;
		while(a!=0){
			sum=sum+a;
			a--;
		}
			System.out.println("The sum of the given "+a+" positive natural numbers is "+sum);
	}
}
