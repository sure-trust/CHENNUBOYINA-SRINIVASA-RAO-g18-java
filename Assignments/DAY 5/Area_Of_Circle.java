import java.util.Scanner;
class  Area_Of_Circle
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the value for to find the area of the below figures");
		System.out.println("1 for circle");
		System.out.println("2 for square");
		System.out.println("3 for rectangle");
		System.out.println("4 for Triangle");
		byte a=sc.nextByte();
		if(a==1)
		{
			System.out.println("Enter the radius of the circle");
			double radius=sc.nextDouble();
			System.out.println("The area of the circle is "+3.1415*radius*radius);
		}
			else if(a==2){
				System.out.println("Enter the length of the side of the square");
				double side=sc.nextDouble();
				System.out.println("The area of the square is "+side*side);
			}
			else if(a==3){
				System.out.println("Enter the length and breadth of the rectagle");
				double length=sc.nextDouble();
				double breadth=sc.nextDouble();
				System.out.println("The area of the rectangle is "+2*(length+breadth));
			}
			else if(a==4){
				System.out.println("Enter the base length and heigth of the Triangle");
				double l=sc.nextDouble();
				double h=sc.nextDouble();
				System.out.println("The area of the Triangle is "+(l*h)/2);
			}
			else
				System.out.println("Invalid input");
		
	}
}
