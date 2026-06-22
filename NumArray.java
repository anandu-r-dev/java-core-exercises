public class NumArray {
    public static void main (String[] args){
        int[] nums = {12, 45, 7, 89, 23 , 4,67};
        int largest = nums[0];
        int smallest = nums[0];
        int sum =0;
        double avg;
        for(int num : nums){
            if (num > largest){
                largest = num;
            }else if (num < smallest){
                smallest = num;
            }
            sum += num;
        }
        avg = (double)sum/nums.length;

        System.out.println("Largest number: "+ largest);
        System.out.println("Smallest number: "+ smallest);
        System.out.println("Sum: "+ sum);
        System.out.println("Average: "+ avg);
    }
}
