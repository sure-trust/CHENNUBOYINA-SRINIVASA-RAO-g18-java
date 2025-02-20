class Prime_Sum {
    public static void main(String args[]) {
        int arr[] = {2, 3, 5, 4, 7, 21, 23, 31, 46};
        int sumPrime = 0, sumComp = 0;

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            boolean isPrime = true;

            if (num < 2) {
                continue; 
            }

            for (int j = 2; j <= Math.sqrt(num); j++) {
                if (num % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                sumPrime += num;
            } else {
                sumComp += num;
            }
        }

        System.out.println("The sum of the prime numbers: " + sumPrime);
        System.out.println("The sum of the composite numbers: " + sumComp);
    }
}
