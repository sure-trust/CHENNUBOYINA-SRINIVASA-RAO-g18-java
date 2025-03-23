class InnerTryDemo
{
	public static void main(String args[])
	{
		try{
			int a=Integer.parseInt(args[0]);
			System.out.println(a);
			try{
				int[] x=new int[a];
				System.out.println("array size is "+x.length);
			}
			catch(NegativeArraySizeException nas){
				int[] x=new int[3];
				System.out.println("new array size "+x.length);
			}
			int b=a+20;
			System.out.println("b "+b);
		}
			catch(ArrayIndexOutOfBoundsException ae){
				System.out.println("pass one int value");
			}
			catch(NumberFormatException a){
				System.out.println("pass only int values");
			}}
			
}