class Linear
{
	public static void main(String args[])
	{
		int arr[]={3,7,1,9,55,234,2,377,88,90};
		int search=55;
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]==search)
			{
				System.out.println("Number is found at index "+i);
				return;
			}
		}
		System.out.println("Number is not found");
	}
}