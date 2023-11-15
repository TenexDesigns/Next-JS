In React, you can share state between components by lifting the state up to a common ancestor or by using state management libraries like React Context or Redux. Here's an example using local state and lifting state up:

Assuming you have a `Cart` component managing the state of the cart, and a `Nav` component that displays the number of items in the cart:

```jsx
// Cart.js
import React, { useState } from 'react';

const Cart = () => {
  const [cartItems, setCartItems] = useState([]);

  const addToCart = (product) => {
    setCartItems([...cartItems, product]);
  };

  const removeFromCart = (product) => {
    const updatedCart = cartItems.filter((item) => item !== product);
    setCartItems(updatedCart);
  };

  return (
    <div>
      <h2>Cart</h2>
      <ul>
        {cartItems.map((item, index) => (
          <li key={index}>{item}</li>
        ))}
      </ul>
      <button onClick={() => addToCart('Product 1')}>Add Product 1</button>
      <button onClick={() => addToCart('Product 2')}>Add Product 2</button>
      <button onClick={() => removeFromCart('Product 1')}>Remove Product 1</button>
    </div>
  );
};

export default Cart;
```

```jsx
// Nav.js
import React from 'react';

const Nav = ({ numberOfItems }) => {
  return (
    <div>
      <h2>Nav</h2>
      <p>Number of items in cart: {numberOfItems}</p>
    </div>
  );
};

export default Nav;
```

```jsx
// App.js (or any other parent component)
import React, { useState } from 'react';
import Cart from './Cart';
import Nav from './Nav';

const App = () => {
  const [cartItems, setCartItems] = useState([]);

  const addToCart = (product) => {
    setCartItems([...cartItems, product]);
  };

  const removeFromCart = (product) => {
    const updatedCart = cartItems.filter((item) => item !== product);
    setCartItems(updatedCart);
  };

  return (
    <div>
      <Cart cartItems={cartItems} addToCart={addToCart} removeFromCart={removeFromCart} />
      <Nav numberOfItems={cartItems.length} />
    </div>
  );
};

export default App;
```

In this example:

1. The state (`cartItems`) and state-modifying functions (`addToCart` and `removeFromCart`) are defined in the `App` component, acting as a common ancestor for `Cart` and `Nav`.

2. The `App` component passes down the state and functions as props to both `Cart` and `Nav`.

3. The `Nav` component displays the `numberOfItems` prop, reflecting the length of `cartItems`.

This approach is suitable for managing state within a small to medium-sized React application. For larger applications, you might consider using state management libraries like React Context or Redux for more centralized state management.



  ....
