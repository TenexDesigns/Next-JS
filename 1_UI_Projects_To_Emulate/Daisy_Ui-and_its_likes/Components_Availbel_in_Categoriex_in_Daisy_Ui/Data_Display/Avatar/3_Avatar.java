Sure. Here is how to use the avatar component in Daisy UI in a Next.js and Tailwind application:

1. Import the Daisy UI library into your project. You can do this by using the `npm install daisyui` command.

2. Create an avatar element and add the `avatar` class to it.

3. Inside the avatar element, you can add an image or text.

4. You can use the `avatar-group` component to group multiple avatars together.

5. You can use the `online` modifier class to show a green dot as an online indicator.

6. You can use the `offline` modifier class to show a gray dot as an offline indicator.

7. You can use the `placeholder` modifier class to show some letters as an avatar placeholder.

Here is an example of how to use the avatar component in a Next.js and Tailwind application:

```
import React from "react";
import { Avatar } from "daisyui";

const App = () => {
  return (
    <div>
      <Avatar>
        <img src="https://avatars.githubusercontent.com/u/123456789?v=4" alt="Avatar" />
      </Avatar>

      <Avatar placeholder>AB</Avatar>

      <Avatar group>
        <Avatar>
          <img src="https://avatars.githubusercontent.com/u/123456789?v=4" alt="Avatar" />
        </Avatar>
        <Avatar>
          <img src="https://avatars.githubusercontent.com/u/987654321?v=4" alt="Avatar" />
        </Avatar>
      </Avatar>
    </div>
  );
};

export default App;
```

In this example, the first avatar is an image, the second avatar is a placeholder, and the third avatar is a group of two avatars.

The most important classes to consider are the `avatar-{variant}`, `avatar-group`, `online`, `offline`, and `placeholder` classes. These classes will determine the appearance of the avatar.

No, we don't need to use state to display an avatar. The avatar component will automatically be displayed when it is added to the DOM.

However, if you want to control the visibility of the avatar yourself, you can use the `hidden` prop.

Here is an example of how to use the `hidden` prop:

```
const App = () => {
  const [isAvatarVisible, setIsAvatarVisible] = useState(true);

  return (
    <div>
      <Avatar hidden={!isAvatarVisible}>
        <img src="https://avatars.githubusercontent.com/u/123456789?v=4" alt="Avatar" />
      </Avatar>

      <button onClick={() => setIsAvatarVisible(!isAvatarVisible)}>Toggle Avatar</button>
    </div>
  );
};

export default App;
```

In this example, the avatar will be hidden by default. When the user clicks the button, the `setIsAvatarVisible` function will be called, which will toggle the value of the `isAvatarVisible` state variable. The avatar will then be displayed or hidden accordingly.

I hope this helps!
