class A
{
	void Dog(){
		System.out.println("this is dog");
	}
}
class B extends A
{
	void Cat(){
		System.out.println("this is cat");
	}
}
class C extends A
{
	void pig(){
		System.out.println("this is pig");
	}
}
class HierarchicalInheritance
{
	public static void main(String args[]){
		B c=new B();
		c.Dog();
		c.Cat();
		C p=new C();
		p.Dog();
		p.pig();
}
}