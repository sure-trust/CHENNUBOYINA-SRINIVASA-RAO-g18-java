import java.util.Scanner;
class WhileLoop2
{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a integer number");
		int num=sc.nextInt();
		int i=1;
		while(i<=num){
			System.out.println(i);
			i++;
		}
	}
	    
		
}