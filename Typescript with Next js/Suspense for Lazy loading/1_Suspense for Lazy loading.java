In React, `<Suspense>` is a component that allows you to "wait" for some code to load and declaratively specify a loading state (like a spinner or fallback component) while we're waiting. It's used to wrap components that might have asynchronous operations, like data fetching or code splitting.

Here's a basic example of how to use `<Suspense>`:

```jsx
import React, { Suspense } from 'react';

function MyComponent() {
 return (
   <div>
     <Suspense fallback={<div>Loading...</div>}>
       <OtherComponent />
     </Suspense>
   </div>
 );
}
```

In this example, `<OtherComponent />` might be a component that fetches data from an API or is loaded lazily. While `<OtherComponent />` is loading, React will render the fallback UI specified in the `fallback` prop.

Here's a more complex example that uses lazy loading and `<Suspense>`:

```jsx
import React, { Suspense, lazy } from 'react';

const OtherComponent = lazy(() => import('./OtherComponent'));

function MyComponent() {
 return (
   <div>
     <Suspense fallback={<div>Loading...</div>}>
       <OtherComponent />
     </Suspense>
   </div>
 );
}
```

In this example, `OtherComponent` is loaded lazily using the `lazy()` function. While `OtherComponent` is being loaded, React will render the fallback UI specified in the `fallback` prop.

`<Suspense>` can also be used to wrap multiple components. In this case, all the components inside the `<Suspense>` boundary will be treated as a single unit. If any of the components suspends, the fallback UI will be shown until all the components are ready to be displayed.

```jsx
import React, { Suspense, lazy } from 'react';

const Component1 = lazy(() => import('./Component1'));
const Component2 = lazy(() => import('./Component2'));

function MyComponent() {
 return (
   <div>
     <Suspense fallback={<div>Loading...</div>}>
       <Component1 />
       <Component2 />
     </Suspense>
   </div>
 );
}
```

In this example, `Component1` and `Component2` are loaded lazily. While either of them is loading, React will render the fallback UI. Once both components are ready, they will be displayed together.

Remember that `<Suspense>` is not yet available for server-side rendering. It's also not yet integrated with React's data fetching libraries like Relay or Next.js. However, it's a powerful tool for handling loading states in your React applications [Source 1](https://reactjs.org/docs/concurrent-mode-suspense.html).
