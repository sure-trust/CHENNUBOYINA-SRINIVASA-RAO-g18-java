class Sum_Of_Last_First 
{
    public static void main(String args[]) 
    {
        int arr[] = {1, 2, 6, 3, 7, 9, 6};
        int sum = 0;

        for (int i = 0; i < arr.length / 2; i++)
         {
            int j = arr.length - 1 - i; 
            sum = arr[i] + arr[j];
            System.out.println("Sum of " + arr[i] + " and " + arr[j] + " is " + sum);
        }
        
    }
}
