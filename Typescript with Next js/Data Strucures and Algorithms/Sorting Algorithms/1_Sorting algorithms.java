Sorting algorithms are fundamental to computer science and are used to rearrange a list of items in a specific order. Here are some examples of sorting algorithms implemented in TypeScript:

**1. Bubble Sort**

Bubble Sort is a simple sorting algorithm that repeatedly steps through the list, compares adjacent elements and swaps them if they are in the wrong order. The pass through the list is repeated until the list is sorted.

```typescript
function bubbleSort(arr: number[]): number[] {
   for (let i = 0; i < arr.length; i++) {
       for (let j = 0; j < arr.length - i - 1; j++) {
           if (arr[j] > arr[j + 1]) {
               // Swap arr[j] and arr[j + 1]
               let temp = arr[j];
               arr[j] = arr[j + 1];
               arr[j + 1] = temp;
           }
       }
   }
   return arr;
}
```
[Source 1](https://dev.to/aravindvcyber/sorting-algorithms-implemented-in-typescript-501c)

**2. Selection Sort**

Selection Sort is a simple sorting algorithm that divides the input into a sorted and an unsorted region. The algorithm repeatedly selects the smallest (or largest, depending on the ordering) element from the unsorted region and moves it to the sorted region.

```typescript
function selectionSort(arr: number[]): number[] {
   for (let i = 0; i < arr.length; i++) {
       let minIndex = i;
       for (let j = i + 1; j < arr.length; j++) {
           if (arr[j] < arr[minIndex]) {
               minIndex = j;
           }
       }
       // Swap arr[minIndex] and arr[i]
       let temp = arr[i];
       arr[i] = arr[minIndex];
       arr[minIndex] = temp;
   }
   return arr;
}
```
[Source 1](https://dev.to/aravindvcyber/sorting-algorithms-implemented-in-typescript-501c)

**3. Quick Sort**

Quick Sort is a divide-and-conquer algorithm. It works by selecting a 'pivot' element from the array and partitioning the other elements into two sub-arrays, according to whether they are less than or greater than the pivot. The sub-arrays are then recursively sorted.

```typescript
function quickSort(arr: number[], low: number = 0, high: number = arr.length - 1): number[] {
   if (low < high) {
       const pi = partition(arr, low, high);
       quickSort(arr, low, pi - 1);
       quickSort(arr, pi + 1, high);
   }
   return arr;
}

function partition(arr: number[], low: number, high: number): number {
   const pivot = arr[high];
   let i = low - 1;
   for (let j = low; j < high; j++) {
       if (arr[j] < pivot) {
           i++;
           [arr[i], arr[j]] = [arr[j], arr[i]];
       }
   }
   [arr[i + 1], arr[high]] = [arr[high], arr[i + 1]];
   return i + 1;
}
```
[Source 7](https://ricardoborges.dev/quick-sort)

These are just a few examples of sorting algorithms. There are many other sorting algorithms, each with its own strengths and weaknesses, and each suitable for different kinds of data and different use cases.



  ...
