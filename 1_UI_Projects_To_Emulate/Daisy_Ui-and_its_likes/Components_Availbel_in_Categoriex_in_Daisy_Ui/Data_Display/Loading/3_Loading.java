Sure. Here is how to use the loading component in Daisy UI in a Next.js and Tailwind application:

1. Import the Daisy UI library into your project. You can do this by using the `npm install daisyui` command.

2. Create a loading element and add the `loading` class to it.

3. You can use the `loading-{variant}` modifier class to change the animation of the loading indicator.

Here is an example of how to use the loading component in a Next.js and Tailwind application:

```
import React from "react";
import { Loading } from "daisyui";

const App = () => {
  return (
    <div>
      <Loading>Loading...</Loading>
    </div>
  );
};

export default App;
```

In this example, the loading indicator will use the default spinner animation.

The most important classes to consider are the `loading-{variant}` classes. These classes will determine the animation of the loading indicator.

No, we don't need to use state to display a loading indicator. The loading component will automatically be displayed when it is added to the DOM.

However, if you want to control the visibility of the loading indicator yourself, you can use the `hidden` prop.

Here is an example of how to use the `hidden` prop:

```
const App = () => {
  const [isLoading, setIsLoading] = useState(true);

  return (
    <div>
      <Loading hidden={!isLoading}>Loading...</Loading>

      <button onClick={() => setIsLoading(!isLoading)}>Toggle Loading</button>
    </div>
  );
};

export default App;
```

In this example, the loading indicator will be hidden by default. When the user clicks the button, the `setIsLoading` function will be called, which will toggle the value of the `isLoading` state variable. The loading indicator will then be displayed or hidden accordingly.

Here are some additional details about the loading component:

* The `loading-{variant}` modifier classes can be used to change the animation of the loading indicator. The available variants are `spinner`, `dots`, `ring`, `ball`, `bars`, and `infinity`.
* The loading component can also be used to show a loading message. To do this, you need to wrap the loading element in a `loading-message` component and pass the message text as a prop.

I hope this helps!

