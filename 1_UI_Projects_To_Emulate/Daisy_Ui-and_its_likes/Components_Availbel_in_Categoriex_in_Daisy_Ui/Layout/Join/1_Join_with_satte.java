Sure, I can help you with that.

The `join` component in Daisy UI is used to group multiple items together. It can be used to group buttons, inputs, or any other type of element.

The `join` component has two required children:

* The `join-item` component, which is used to define each item in the group.
* The `join-item` component can be any type of element, but it is most commonly used to define buttons or inputs.

The `join` component also has two optional modifier classes:

* `join-vertical`: This modifier class is used to show the items in the group vertically.
* `join-horizontal`: This modifier class is used to show the items in the group horizontally.

Here is an example of how to use the `join` component in a Next.js and Tailwind application:

```
<div className="join">
  <button className="btn join-item">Button</button>
  <button className="btn join-item">Button</button>
  <button className="btn join-item">Button</button>
</div>
```

In this example, three buttons are grouped together using the `join` component. The `join-item` modifier class is not used in this case, so the items are displayed horizontally by default.

Here is another example of how to use the `join` component:

```
<div className="join join-vertical">
  <button className="btn join-item">Button</button>
  <button className="btn join-item">Button</button>
  <button className="btn join-item">Button</button>
</div>
```

In this example, the same three buttons are grouped together, but this time the `join-vertical` modifier class is used. This causes the buttons to be displayed vertically.

The `join` component can be used in a variety of ways to group different types of elements together. It is a versatile component that can be used to improve the layout and usability of your website or application.

The code you have provided shows how the `join` component can be used to group buttons, inputs, and other elements together. It also shows how the `join-vertical` and `join-horizontal` modifier classes can be used to change the layout of the items in the group.

The `join` component is a powerful tool that can be used to improve the layout and usability of your website or application. It is a versatile component that can be used to group different types of elements together.

To manage state and know which button is active, you can use the `useState` hook from React. The `useState` hook allows you to create and manage state in your components.

In the example above, you could create a state variable called `activeItem` and set it to the index of the currently active item. Then, you could use the `onClick` event handler of each button to update the value of the `activeItem` state variable.

You could also use the `classnames` package to dynamically add the `active` class to the button that is currently active. This would make it visually obvious to the user which button is active.

Here is an example of how to use the `classnames` package:

```
import classnames from "classnames";

const App = () => {
  const [activeItem, setActiveItem] = useState(0);

  return (
    <div>
      <ul>
        <li
          className={classnames({
            "active": activeItem === 0,
          })}
          onClick={() => setActiveItem(0)}
        >
          Button 1
        </li>
        <li
          className={classnames({
            "active": activeItem === 1,
          })}
          onClick={() => setActiveItem(1)}
        >
          Button 2
        </li>
        <li
          className={classnames({
            "active": activeItem === 2,
          })}
          onClick={() => setActiveItem(2)}
        >
          Button 3
        </li>
      </ul>
    </div>
  );
};

export default App;
```

In this example, the `classnames` package is used to dynamically add the `active` class to the button that is currently active. The `activeItem` state variable is used to track which button is currently active. The `onClick` event handler of each button is used to update the value of the `activeItem` state variable.

I hope this helps!
