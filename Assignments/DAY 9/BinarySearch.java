class BinarySearch
{
	public static void main(String args[])
	{
		int arr[]={1,6,9,12,18,20,34,43,50};
		int target=12;
		int n=arr.length;
		int index=binary(arr,n,target);
		System.out.println("the element is found at index "+index);
	}
	static int binary(int arr[],int n,int target)
	{
		int start=0;
		int end=n-1;
		int mid=(start+end)/2;
		while(start<=end)
		{
			if(arr[mid]==target)
				return mid;
			else if(arr[mid]>target)
						end=mid-1;
			else
				start=mid+1;
		}
		return -1;
	}
}