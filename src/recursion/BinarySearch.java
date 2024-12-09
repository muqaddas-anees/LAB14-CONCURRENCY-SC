package recursion;  // The name of the package you're using

public class BinarySearch {
	 // Recursive binary search method
    public static int binarySearchRecursive(int[] arr, int target, int low, int high) {
        // Base case: array is exhausted
        if (low > high) {
            return -1; // target not found
        }
        
        int mid = low + (high - low) / 2;
        
        // Target found
        if (arr[mid] == target) {
            return mid;
        }
        
        // Recursive search in left half or right half
        if (arr[mid] > target) {
            return binarySearchRecursive(arr, target, low, mid - 1); // Search left
        } else {
            return binarySearchRecursive(arr, target, mid + 1, high); // Search right
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17};
        int target = 7;
        int result = binarySearchRecursive(arr, target, 0, arr.length - 1);
        System.out.println("Index of target " + target + ": " + result);
    }
}
