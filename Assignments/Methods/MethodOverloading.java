class A
{
	public void Sum(int i,int j){
		System.out.println("the sum of the given two numbers "+(i+j));
	}
	public void Sum(int i,int j,int k){
		System.out.println("the sum of the given three numbers "+(i+j+k));
	}
}
class MethodOverloading
{
	public static void main(String args[]){
		A a=new A();
		a.Sum(5,6);
		a.Sum(5,6,7);
	}
}