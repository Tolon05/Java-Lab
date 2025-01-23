import java.util.Scanner;
public class Lab {
    public static void main(String[] args) {
        //task 1
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите числа через пробел:");
        String input = scanner.nextLine();

        String[] inputArray = input.split(" ");

        int[] nums = new int[inputArray.length];
        for (int i = 0; i < inputArray.length; i++) {
            nums[i] = Integer.parseInt(inputArray[i]);
        }

        //1
        int summa = 0;
        for (int i:nums) {
            summa += i;
        }
        System.out.println("summa elementov -> " + summa);

        //2
        System.out.println("average -> " + (double) summa / nums.length);

        //3
        int min = nums[0];
        int max = nums[0];
        int min2 = nums[0];
        int max2 = nums[0];

        for (int i:nums) {
            if (i > max) {
                max2 = max;
                max = i;
            } else if (max != i && i > max2) {
                max2 = i;
            }
            if (i < min) {
                min2 = min;
                min = i;
            } else if (min != i && i < min2) {
                min2 = i;
            }
        }
        System.out.println("The largest number is " + max);
        System.out.println("The smallest number is " + min);
        System.out.println("The second largest number is " + max2);
        System.out.println("The second smallest number is " + min2);




        // task 2
        System.out.println("Введите слово или число: ");
        String inputPal = scanner.nextLine();
        inputPal = inputPal.replaceAll("[^a-zA-Z0-9]", "");

        if (isPalindrome(inputPal)) {
            System.out.println(inputPal + " является палиндромом.");
        } else {
            System.out.println(inputPal + " не является палиндромом.");
        }
        scanner.close();
    }

    public static boolean isPalindrome(String inputPal) {
        int left = 0;
        int right = inputPal.length() - 1;

        while (left < right) {
            if (inputPal.charAt(left) != inputPal.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}


