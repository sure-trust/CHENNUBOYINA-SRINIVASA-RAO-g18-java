class A
{
	public void dog(){//override mathod
		System.out.println("this is dog");
	}
	public void cat(){
		System.out.println("this is cat");
	}
}
class B extends A
{
	public void dog(){//override method
		System.out.println("the name of the animal is dog");
	}
}
class MethodOverriding
{
	public static void main(String args[]){
		B obj=new B();
		obj.dog();
		obj.cat();
	}
		
}