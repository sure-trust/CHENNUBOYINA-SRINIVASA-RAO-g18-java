class Arr_Add
{
    public static void main(String args[])
    {
        int add=5;
        int arr[]={1,6,3,5,9,2};
        int Upadate_arr[]=new int[arr.length];

        for(int i=0;i<arr.length;i++)
        {
            Upadate_arr[i]=arr[i]+add;
        }
        for(int x:Upadate_arr)
        System.out.println(x);
    }
}