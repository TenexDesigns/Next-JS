React is a popular JavaScript library for building user interfaces, especially for single-page applications. It's known for its efficiency and performance, but like any tool, it has its limitations.

React's performance is largely dependent on how it's used. React uses a virtual DOM to minimize direct manipulation of the actual DOM, which can significantly improve performance. However, if not used properly, React can lead to performance issues. For instance, unnecessary re-renders can slow down your application, and complex components with many child components can lead to performance degradation [Source 1](https://reacthandbook.dev/react-performance-optimization).

React's performance can be optimized in several ways:

1. **Using `React.memo` or `shouldComponentUpdate`**: These methods can prevent unnecessary re-renders by telling React to skip rendering a component if its props haven't changed.

2. **Using `React.lazy` and `React.Suspense`**: These features allow you to load components lazily, which can improve initial load times.

3. **Using `useCallback` and `useMemo` hooks**: These hooks can help prevent unnecessary computations and re-renders by memoizing functions and values.

4. **Avoiding inline functions**: Inline functions can cause unnecessary re-renders because a new function is created every time the component renders.

5. **Proper use of state and props**: Overuse of state and props can lead to unnecessary re-renders. It's important to manage state and props efficiently to avoid performance issues [Source 3](https://www.copycat.dev/blog/react-performance/).

Regarding the statement about React not being able to handle 1000 requests per second, it's important to note that React itself doesn't handle requests. React is a library for building user interfaces, and it runs in the browser. It doesn't have direct control over server-side operations or network requests. However, React can be used in conjunction with other libraries or frameworks that do handle requests, such as Express.js in Node.js.

In conclusion, while React has some limitations and performance can be a concern in certain cases, it's a powerful tool for building high-performance user interfaces. With proper use and optimization, React can be used to build applications that handle thousands of requests per second [Source 0](https://www.makeuseof.com/react-limitations/).

