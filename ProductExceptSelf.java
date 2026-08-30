import java.util.Scanner;
public class ProductExceptSelf {

    public static int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] answer = new int[n];

        int leftProduct = 1;

        for (int i = 0; i < n; i++) {
            answer[i] = leftProduct;
            leftProduct = leftProduct * nums[i];
        }

        int rightProduct = 1;

        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * rightProduct;
            rightProduct = rightProduct * nums[i];
        }

        return answer;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter " + n + " elements:");

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        int[] answer = productExceptSelf(nums);

        System.out.print("Product of array except self: ");

        for (int i = 0; i < n; i++) {
            System.out.print(answer[i] + " ");
        }

        scanner.close();
    }
}