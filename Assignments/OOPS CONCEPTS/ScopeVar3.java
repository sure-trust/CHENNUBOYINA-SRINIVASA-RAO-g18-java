class ScopeVar3
{
	void display()
	{
		String StuName="Srinivasa Rao";//local variables
		String StuBranch="Computer Science and Engineering";
		System.out.println("The name of the student is "+StuName);
		System.out.println("The branch of the student is "+StuBranch);
	}
	public static void main(String args[])
	{
		ScopeVar3 obj=new ScopeVar3();
		obj.display();
	}
}