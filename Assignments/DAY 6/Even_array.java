class Even_array
{
	public static void main(String args[])
	{
		 int array[]={6,2,8,55,39,32,12};
		 System.out.println("the even elements of the given array");
		 for(int i=0;i<array.length;i++)
		{
			 if(array[i]%2==0)
				System.out.println(array[i]);
		}
	}
}