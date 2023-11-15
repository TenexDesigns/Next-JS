Certainly! Here's a simple implementation of a queue in TypeScript:

```typescript
/**
 * A generic queue implementation.
 * @template T - The type of elements stored in the queue.
 */
export class Queue<T> {
  private list: T[] = [];

  /**
   * Adds an item to the end of the queue.
   * @param {T} item - The item to enqueue.
   */
  enqueue(item: T): void {
    this.list.push(item);
  }

  /**
   * Removes and returns the item at the front of the queue.
   * @return {T} The dequeued item.
   */
  dequeue(): T | undefined {
    return this.list.shift();
  }

  /**
   * Gets the number of elements in the queue.
   * @return {number} The number of elements in the queue.
   */
  size(): number {
    return this.list.length;
  }

  /**
   * Checks if the queue is empty.
   * @return {boolean} True if the queue is empty, false otherwise.
   */
  isEmpty(): boolean {
    return this.list.length === 0;
  }

  /**
   * Retrieves the item at the front of the queue without removing it.
   * @return {T} The item at the front of the queue.
   */
  peek(): T | undefined {
    return this.list[0];
  }

  /**
   * Clears all elements from the queue.
   */
  clear(): void {
    this.list = [];
  }

  /**
   * Converts the queue to an array.
   * @return {T[]} An array representation of the queue.
   */
  toArray(): T[] {
    return [...this.list];
  }
}

// Example usage:

const myQueue = new Queue<number>();

myQueue.enqueue(1);
myQueue.enqueue(2);
myQueue.enqueue(3);

console.log(myQueue.toArray()); // [1, 2, 3]

console.log(myQueue.dequeue()); // 1

console.log(myQueue.size()); // 2

console.log(myQueue.isEmpty()); // false

console.log(myQueue.peek()); // 2

myQueue.clear();

console.log(myQueue.isEmpty()); // true
```

This is a basic implementation of a queue in TypeScript. It includes methods for enqueueing, dequeuing, checking the size, checking if it's empty, peeking at the front element, clearing the queue, and converting the queue to an array.
