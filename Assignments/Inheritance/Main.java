class A
{
	void first()
	{
		System.out.println("this is class A");
	}
}
class B extends A
{
	void second()
	{
		System.out.println("this is class B");
	}
}
class SingleInheritance
{
	public static void main(String args[]){
		B obj=new B();
		obj.second();
		obj.first();
}}