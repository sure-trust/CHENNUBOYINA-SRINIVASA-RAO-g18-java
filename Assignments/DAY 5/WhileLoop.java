import java.util.Scanner;
class WhileLoop
{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a integer number");
		int num=sc.nextInt();
		while(num!=0){
			
			System.out.println(num);
			num--;
		}
	}
	    
		
}