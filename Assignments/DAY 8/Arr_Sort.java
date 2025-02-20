class Arr_Sort
{
    public static void main(String args[])
    {
        int arr[]={9,3,1,6,5,21,19,8};
        for(int i=0;i<arr.length;i++)
        {
            for(int j=i+1;j<arr.length;j++)
            {
                if(arr[j]<arr[i])
                {
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        for(int x:arr)
            System.out.println(x);
    }
}