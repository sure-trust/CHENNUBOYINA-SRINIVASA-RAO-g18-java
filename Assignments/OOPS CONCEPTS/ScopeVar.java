import java.util.Scanner;
class ScopeVar
{
	String StuName;//instance variables
	String StuBranch;
	float cgpa;
	void display()  
	{
		System.out.println("the name of the student is "+StuName);
		System.out.println("the branch of the student is  "+StuBranch);
	    System.out.println("the cgpa of the student is "+cgpa);
	}
	public static void main(String args[])
	{
		 ScopeVar obj=new ScopeVar();
		 Scanner sc=new Scanner(System.in);
		 System.out.println("Enter the name of the student");
		 obj.StuName=sc.next();
		 System.out.println("Enter the branch of the student");
		 obj.StuBranch=sc.next();
		 System.out.println("Enter the cgpa of the student");
		 obj.cgpa=sc.nextFloat();
		
		 obj.display();
}}
