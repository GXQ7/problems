package exercises;

public class App 
{
    public static void main( String[] args )
    {
        
    }

     public static void testisDuplicateWithSum() {
        // Driver method
        boolean t1 = sortedIsDuplicateWithSum(new int[]{1,2,3,9}, 8);
        boolean t2 = sortedIsDuplicateWithSum(new int[]{1,2,4,4}, 8);
        //boolean t1 = unsortedIsDuplicateWithSum(new int[] { 3, 2, 1, 9 }, 8);
        //boolean t2 = unsortedIsDuplicateWithSum(new int[] { 4, 2, 1, 4 }, 8);
        if (t1 == false && t2 == true)
             System.out.println("Works");
        else
            System.out.println("Keep trying! You got this");
    }

    // Given an array of sorted numbers and a sum value check if there are duplicate
    // values that equal the sum
    public static boolean sortedIsDuplicateWithSum(int[] array, int sum) {
        int min = array[0];
        int max = array[array.length - 1];
        boolean flag = false;

        // O(n) = linear scan through array
        while (min < max) {
            flag = ((min + max) == sum) ? true : false;
            if (flag)
                return true;
            else if (min == max)
                return false;
            else
                min += 1;
        }
        return flag;
    }
}
