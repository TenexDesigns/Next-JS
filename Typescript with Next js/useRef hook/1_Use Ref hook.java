The `useRef` hook in React is a built-in hook that allows you to create mutable references to values and DOM elements. This hook returns a mutable ref object whose `.current` property is initialized with the passed argument (`initialValue`). The returned object will persist for the full lifetime of the component [Source 2](https://react.dev/reference/react/useRef).

The `useRef` hook is often used for two main purposes:

1. **Accessing DOM elements directly**: The `useRef` hook can be used to get a reference to a DOM element in your component. This is useful when you need to interact with the DOM directly, for example, to set focus on an input field or measure the size of an element. Here's an example of how to use `useRef` to focus an input field:

  ```jsx
  import React, { useRef } from 'react';

  function MyComponent() {
    const inputRef = useRef(null);

    const handleClick = () => {
      inputRef.current.focus();
    };

    return (
      <div>
        <input ref={inputRef} type="text" />
        <button onClick={handleClick}>Focus the input</button>
      </div>
    );
  }
  ```
  [Source 2](https://react.dev/reference/react/useRef)

2. **Storing mutable values**: The `useRef` hook can also be used to store a mutable value that persists across re-renders of your component. This is useful when you need to keep track of a value that doesn't cause a re-render when it changes. Here's an example of how to use `useRef` to store a counter:

  ```jsx
  import React, { useRef } from 'react';

  function MyComponent() {
    const countRef = useRef(0);

    const increment = () => {
      countRef.current++;
    };

    return (
      <div>
        <p>You clicked {countRef.current} times</p>
        <button onClick={increment}>Click me</button>
      </div>
    );
  }
  ```
  [Source 0](https://upmostly.com/tutorials/how-to-react-useref-hook)

While `useRef` can be used to store mutable values, it's generally recommended to use `useState` for this purpose. The `useRef` hook should be used when you need to persist a value across re-renders without causing a re-render itself [Source 0](https://upmostly.com/tutorials/how-to-react-useref-hook).

In terms of when to use `useRef`, it's most useful when you need to interact with the DOM directly or when you need to persist a value across re-renders without causing a re-render. However, you should avoid using `useRef` to store state that should cause a re-render when it changes. In such cases, `useState` is a better choice [Source 0](https://upmostly.com/tutorials/how-to-react-useref-hook).
                                                                                                                                                                                                                                                                                                                                                     

                                                                                                                                                                                                                                                                                                                                                     
                                                                                                                                                                                                                                                                                                                                                     
                                                                                                                                                                                                                                                                                                                                                     
 CUSTOME USE OF THE USE REF HOOK                                                                                                                                                                                                                                                                                                                                                    
---------------------------------------------------------------------------------
                                                                                                                                                                                                                                                                                                                                                     
                                                                                                                                                                                                                                                                                                                                                     
                                                                                                                                                                                                                                                                                                                                                     
                                                                                                                                                                                                                                                                                                                                                     
                                                                                                                                                                                                                                                                                                                                                     
                                                                                                                                                                                                                                                                                                                                                     
import React, { FormEvent, useRef } from "react";

function Form() {
  const person = { name: "", age: 0 };
  const nameRef = useRef<HTMLInputElement>(null);
  const ageRef = useRef<HTMLInputElement>(null);
  const handleSubmit = (event: FormEvent) => {
    event.preventDefault();
    if (nameRef.current !== null) {
      person.name = nameRef.current.value;
      console.log(nameRef.current.value);
    }
    if (ageRef.current !== null) {
      person.name = ageRef.current.value;

      console.log(ageRef.current.value);
    }
    console.log(person);
  };
  return (
    <>
      <form onSubmit={handleSubmit}>
        <div className="mb-3">
          <label htmlFor="name" className="form-label">
            Name
          </label>
          <input ref={nameRef} id="name" type="text" className="form-control" />
        </div>

        <div className="mb-3">
          <label htmlFor="age" className="form-label">
            Age
          </label>
          <input id="age" type="number" className="form-control" />
        </div>

        <button type="submit" className="btn btn-primary">
          Submit
        </button>
      </form>
    </>
  );
}

export default Form;
                             
                                                                                                                                                                                                                                                                                                                                                     
                                                                                                                                                                                                                                                                                                                                                     
                                                                                                                                                                                                                                                                                                                                                     
                                                                                                                                                                                                                                                                                                                                                     
