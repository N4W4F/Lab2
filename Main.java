import java.util.*;

public class Main
{
    public static void main(String[] args)
    {

        Scanner input = new Scanner(System.in);

//      1. Calling findLongest method to return the longest words in an ArrayList
        ArrayList<String> dictionary = new ArrayList<>();
        dictionary.add("cat");
        dictionary.add("dog");
        dictionary.add("red");
        dictionary.add("is");
        dictionary.add("am");
        System.out.println("Original Array: " + dictionary);

        System.out.println("Output: " + findLongest(dictionary));


        System.out.println("----------------------------------------------------------");


//      2. Calling displayOcc to display the occurrences of each element in the array
        int[] occurrencesArray = {1, 1, 1, 3, 3, 5};
        System.out.println("Original Array: " + Arrays.toString(occurrencesArray));

        displayOcc(occurrencesArray);


        System.out.println("----------------------------------------------------------");


//      3. Calling findKLargest to find the K largest elements of array
        int[] array = {1, 4, 17, 7, 25, 3, 100};
        int k = 3;

        findKLargest(array, k);


        System.out.println("\n----------------------------------------------------------");


//      4. Calling reverseArray to print the reversed order of previous array.
        int[] myArray = {5, 4, 3, 2, 1};
        System.out.println("Original Array: " + Arrays.toString(myArray));

        System.out.print("Reversed Array: ");
        reverseArray(myArray);


        System.out.println("\n----------------------------------------------------------");


//      5. Calling arrayMenu method to create an ArrayList with menu.
        System.out.print("Please, input the size of the array: ");
        arrayMenu(input.nextInt());


        System.out.println("\n----------------------------------------------------------");


//      6. Calling randomNum method to generate a random number in the range of given numbers
        System.out.print("Enter the minimum value of the range: ");
        int bound1 = input.nextInt();

        System.out.print("Enter the maximum value of the range: ");
        int bound2 = input.nextInt();

        System.out.print("Enter the number of random numbers to generate: ");
        int randNumbers = input.nextInt();

        randomNum(bound1, bound2, randNumbers);


        System.out.println("\n----------------------------------------------------------");


//      7. Calling checkStrength to classify the password to weak, moderately strong or strong
        System.out.print("Enter a password: ");
        String password = input.next();

        System.out.println("The password is " + checkStrength(password));


        System.out.println("\n----------------------------------------------------------");


//      8. Calling fiboSequence method to generate a Fibonacci sequence up to
//      the specified number of terms
        System.out.print("Enter the number of Fibonacci terms to generate: ");
        fiboSequence(input.nextInt());
    }


//  1. Write a program to find all of the longest word in a given dictionary.

    public static ArrayList<String> findLongest(ArrayList<String> myList)
    {
        ArrayList<String> newList = new ArrayList<>();

        int wordLength = 0;

        for (String m : myList)
            if (m.length() >= wordLength)
                wordLength = m.length();

        for (String m : myList)
            if (m.length() >= wordLength)
                newList.add(m);

        return newList;
    }


//  2. Write a program that displays the number of occurrences of an element in the array.

    public static void displayOcc(int[] arr)
    {
        for (int i = 1; i <= 9; i++)
        {
            int counter = 0;

            for (int j = 0; j < arr.length; j++)
                if (arr[j] == i)
                    counter++;

            System.out.println(i + " occurs " + counter + " times");
        }
    }


//  3. Write a program to find the k largest elements in a given array.
//  Elements in the array can be in any order.

    public static void findKLargest(int[] array, int k)
    {
        // Sort the array in descending order
        Arrays.sort(array);

        System.out.println("Original Array: " + Arrays.toString(array));

        System.out.println(k + " largest elements of the array are:");

        for (int i = array.length - 1; i >= array.length - k; i--)
            System.out.print(array[i] + " ");
    }


//  4. Create a method to reverse and array of integers. Implement the method without
//  creating a new array.

    public static void reverseArray(int[] arr)
    {
        for (int i = arr.length - 1; i > 0; i--)
            System.out.print(arr[i] + " ");
    }


//  5. Write a menu driven Java program with following option:

    public static void arrayMenu(int size)
    {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> myList = new ArrayList<>();
        int choice = 0;
        do
        {
            System.out.print(
                    "1. Accept elements of an array\n" +
                    "2. Diplay elements of an array\n" +
                    "3. Search the element within array\n" +
                    "4. Sort the array\n" +
                    "5. To stop\n");
            choice = input.nextInt();

            switch (choice)
            {
                case 1:
                    System.out.print("Input an element: ");
                    myList.add(input.nextInt()); break;
                case 2: System.out.println(myList); break;
                case 3: {
                    System.out.print("Input the index of element: ");
                    int index = input.nextInt();
                    if (index < myList.size() && index >= 0) {
                        System.out.println(myList.get(index));
                    break; }
                    else System.out.println("Index is out of bound!"); break;
                }
                case 4:
                    myList.sort(Integer::compareTo);
                    System.out.println(); break;
                default: break;
            }
        } while (choice != 5 && myList.size() <= size);
    }


//  6. Create a method that generates a random number within a given range. Allow the user to
//  specify the range and call the method to display random numbers.

    public static void randomNum(int num1, int num2, int count)
    {
        Random rand = new Random();

        if(num2 - num1 == 0)
        {
            System.out.println("The difference between " + num2 + " and " + num1 + " must be more than 0");
            return;
        }

        for (int i = 0; i < count; i++)
            System.out.print(++num1 + rand.nextInt(num2 - num1) + " ");
    }


//  7. Write a program that check the strength of a password. Create a method that evaluates
//  a password based on criteria like length, inclusion of special characters, and
//  uppercase/lowercase letters.

    public static String checkStrength(String password)
    {
        int totalScore = 0;

        totalScore += checkLength(password);
        totalScore += checkSpecialCharacters(password);
        totalScore += checkUpperCaseLowerCase(password);

        if (totalScore >= 8)
            return "strong";

        else if (totalScore >= 5)
            return "moderately strong";

        return "weak";
    }


//  7.1 Write checkLength method to specify the score of a given password based on length

    public static int checkLength(String password)
    {
        if (password.length() <= 5)
            return 0;

        else if (password.length() <= 7)
            return 2;

        return 3;
    }


//  7.2 Write checkSpecialCharacters to specify the score of a given password based on special characters

    public static int checkSpecialCharacters(String password)
    {
        for (int i = 0; i < password.length(); i++)
        {
            char ch = password.charAt(i);

            if (!((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')))
                return 2;
        }
        return 0;
    }


//  7.3 Write checkUpperCaseLowerCase to specify the score of a given password based on
//  upper or lower case letters

    public static int checkUpperCaseLowerCase(String password)
    {
        boolean isUpperCase = false, isLowerCase = false;
        for (int i = 0; i < password.length(); i++)
        {
            char ch = password.charAt(i);
            if (ch >= 'A' && ch <= 'Z')
                isUpperCase = true;

            else if (ch >= 'a' && ch <= 'z')
                isLowerCase = true;
        }
        if (isUpperCase && isLowerCase)
            return 3;

        return 0;
    }


//  8. Create method that generates the Fibonacci sequence up to a specified number of terms.

    public static void fiboSequence(int terms)
    {
        int first = 0, second = 1;

        System.out.println("Fibonacci sequence with " + terms + " terms:");

        for (int i = 0; i < terms; i++)
        {
            System.out.print(first + " ");
            int next = first + second;
            first = second;
            second = next;
        }
    }
}
