class Odd_Index_Sum
{
    public static void main(String args[])
    {
        int arr[]={6,2,8,3,11,23,28};
        int sum=0;
        for(int i=0;i<arr.length;i+=2)
        {
            sum+=arr[i];
        }
        System.out.println("The sum of the odd index elements "+sum);
    }
}