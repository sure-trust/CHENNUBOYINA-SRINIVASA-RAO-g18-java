import java.util.Scanner;
class Odd
{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a integer number");
		int num=sc.nextInt();
		System.out.println("the first "+num+" odd numbers");
		int i=1;
		while(i<=num){
			if(i%2!=0)
				System.out.println(i);
			
			i++;
		}
	}
	    
		
}