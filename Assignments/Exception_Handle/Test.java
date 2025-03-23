class Test
{
	public static void main(String args[])
	{
		try{
			System.out.println(10/0);
		}
		catch(ArithmeticException ae){
			System.out.println("getMessage()");
			System.out.println(ae.getMessage());
			System.out.println(ae.toString());
			ae.printStackTrace();
			//System.out.println(throws ae);
		}}
}