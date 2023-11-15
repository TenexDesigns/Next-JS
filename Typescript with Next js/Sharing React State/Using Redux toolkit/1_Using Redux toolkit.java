To handle state in React with Redux Toolkit, you would typically follow these steps:

1. **Install Redux Toolkit:**
   ```bash
   npm install @reduxjs/toolkit react-redux
   ```

2. **Set Up Redux Slice:**
   Create a Redux "slice" to manage the state related to the cart. A slice includes reducers, actions, and the initial state.

   ```jsx
   // cartSlice.js
   import { createSlice } from '@reduxjs/toolkit';

   const cartSlice = createSlice({
     name: 'cart',
     initialState: {
       items: [],
     },
     reducers: {
       addToCart: (state, action) => {
         state.items.push(action.payload);
       },
       removeFromCart: (state, action) => {
         state.items = state.items.filter((item) => item !== action.payload);
       },
     },
   });

   export const { addToCart, removeFromCart } = cartSlice.actions;
   export default cartSlice.reducer;
   ```

3. **Configure Redux Store:**
   Set up the Redux store and include the cart slice.

   ```jsx
   // store.js
   import { configureStore } from '@reduxjs/toolkit';
   import cartReducer from './cartSlice';

   export const store = configureStore({
     reducer: {
       cart: cartReducer,
     },
   });
   ```

4. **Wrap Your App with Redux Provider:**
   Wrap your React application with the Redux `Provider` to make the store available to all components.

   ```jsx
   // index.js or App.js
   import React from 'react';
   import ReactDOM from 'react-dom';
   import { Provider } from 'react-redux';
   import { store } from './store';
   import App from './App';

   ReactDOM.render(
     <Provider store={store}>
       <App />
     </Provider>,
     document.getElementById('root')
   );
   ```

5. **Connect Components to Redux:**
   Modify your `Cart` and `Nav` components to connect to Redux using the `useDispatch` and `useSelector` hooks.

   ```jsx
   // Cart.js
   import React from 'react';
   import { useDispatch, useSelector } from 'react-redux';
   import { addToCart, removeFromCart } from './cartSlice';

   const Cart = () => {
     const dispatch = useDispatch();
     const cartItems = useSelector((state) => state.cart.items);

     return (
       <div>
         <h2>Cart</h2>
         <ul>
           {cartItems.map((item, index) => (
             <li key={index}>{item}</li>
           ))}
         </ul>
         <button onClick={() => dispatch(addToCart('Product 1'))}>Add Product 1</button>
         <button onClick={() => dispatch(addToCart('Product 2'))}>Add Product 2</button>
         <button onClick={() => dispatch(removeFromCart('Product 1'))}>Remove Product 1</button>
       </div>
     );
   };

   export default Cart;
   ```

   ```jsx
   // Nav.js
   import React from 'react';
   import { useSelector } from 'react-redux';

   const Nav = () => {
     const numberOfItems = useSelector((state) => state.cart.items.length);

     return (
       <div>
         <h2>Nav</h2>
         <p>Number of items in cart: {numberOfItems}</p>
       </div>
     );
   };

   export default Nav;
   ```

Now, your state is managed by Redux Toolkit. When you dispatch actions, they will update the state in the Redux store, and any component connected to the store will automatically reflect those changes.
