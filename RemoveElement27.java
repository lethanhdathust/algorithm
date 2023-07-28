import java.util.ArrayList;

class RemoveElement27 {

    // public static int removeElement(int[] nums, int val) {
    // ArrayList<Integer> x = new ArrayList<>();

    // for (int i = 0; i < nums.length; i++) {

    // x.add(Integer.valueOf(nums[i]));
    // }
    // // When you remove an element from x using x.remove(i), the size of the
    // ArrayList changes, and the subsequent elements shift to fill the gap. As a
    // result, the index i no longer points to the correct element in the ArrayList
    // // This causes elements to be skipped or not properly checked for removal.
    // for (int i = x.size()-1; i >=0; i--) {
    // if (x.get(i).compareTo(Integer.valueOf(val)) == 0) {
    // x.remove(i);
    // }
    // }
    // System.out.println(x);
    // return x.size();
    // }
    // todo: The ideal
    // When the value is equal to val so we do not change anything,
    // We continue the loop until the value do not equal the val , the j still
    // increase ,
    // but the i like a anchor at the position has value equal to val
    // then we inverse the value of the nums[i] and nums[j]
    //
    public static int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            // If the value is not different to the val value , so we do not change the
            // value of the element at the index
            // Ex: loop 1: nums[0] = 1 not equal to 3 => do not change anything , then i++
            // to compare the next element to the val
            // loop 2, 3: Likewise
            // loop 4: The nums[j] = 4 equal
            if (nums[j] != val) {
                // if the value of the nums[i] not equal to val => swap
                // nums[j] to find the val in array
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }
        return i;
    }

    public static int removeElementV2(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {

            if (nums[j] == val) {
                continue;
            }
            nums[i] = nums[j];
            i++;
        }
        for (int v : nums) {
            System.out.println(v);

        }
        return i;
    }

    public static void main(String[] args) {
        int[] array = { 1, 2, 2, 3, 4, 3 };
        // loop 4 : 1,2,2,4,3,5 ( i = 4,j = 5)
        // loop 5:
        System.out.println(removeElementV2(array, 3));
    }
}

// 1. Initialize a variable i to keep track of the position where non-val
// elements should be placed in the nums array.

// 2. Iterate through the nums array using a variable j.

// 3. Check if the value at index j (nums[j]) is different from the given val.

// 4. If nums[j] is not equal to val, it means it is a non-val element that
// should be retained in the array. In this case:

// a. Swap the values of nums[i] and nums[j] to move the non-val element to the
// correct position, ensuring it is placed at index i.

// b. Increment i to indicate that a non-val element has been properly placed.

// 5. Repeat steps 3 to 4 for each element in the nums array.
//
// 6. After iterating through the entire array, i will represent the number of
// non-val elements present in the modified nums array.

// 7. Return the value of i, which represents the new size of the array with val
// elements removed.