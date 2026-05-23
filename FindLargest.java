public class FindLargest {
    public static void main(String[] args) {
        int[] numbers = {4, 19, 72, 45, 6, 98, 23, 81};

        int largest = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > largest) {
                largest = numbers[i];
            }
        }

        System.out.println("The largest number in the array is: " + largest);
    }
}