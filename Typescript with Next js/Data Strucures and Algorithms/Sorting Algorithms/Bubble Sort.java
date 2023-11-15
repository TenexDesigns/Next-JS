Certainly! Here's an example of a sorting algorithm implemented in TypeScript. Let's use the Bubble Sort algorithm as an example:

```typescript
/**
 * Bubble Sort algorithm for sorting an array of numbers in ascending order.
 * @param {number[]} arr - The array to be sorted.
 * @return {number[]} - The sorted array.
 */
function bubbleSort(arr: number[]): number[] {
  const length = arr.length;

  // Outer loop: Traverse through all array elements
  for (let i = 0; i < length - 1; i++) {
    // Inner loop: Last i elements are already sorted, so we don't need to check them
    for (let j = 0; j < length - 1 - i; j++) {
      // Swap if the element found is greater than the next element
      if (arr[j] > arr[j + 1]) {
        const temp = arr[j];
        arr[j] = arr[j + 1];
        arr[j + 1] = temp;
      }
    }
  }

  return arr;
}

// Example usage:

const unsortedArray = [64, 34, 25, 12, 22, 11, 90];
const sortedArray = bubbleSort(unsortedArray);

console.log("Unsorted Array:", unsortedArray);
console.log("Sorted Array:", sortedArray);
```

This is a simple implementation of the Bubble Sort algorithm, which is not the most efficient sorting algorithm for large datasets but serves well for educational purposes. There are more efficient sorting algorithms like Merge Sort, Quick Sort, and others that you might want to explore based on your specific needs.

Feel free to ask if you have any questions or if you'd like to see examples of other sorting algorithms!



  ...
