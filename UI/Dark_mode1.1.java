To handle dark mode in a Next.js application with Tailwind CSS, you can follow the instructions provided in the documentation you mentioned. Here, I'll explain the steps with code samples for better clarity:

1. **Configure Tailwind CSS for Dark Mode:**

   In your `tailwind.config.js` file, set the `darkMode` option to `'class'` to enable manual dark mode toggling. This allows you to apply dark mode styles based on the presence of the `dark` class in your HTML. If you have a prefix set in your Tailwind config (e.g., `tw-`), use that prefix with the `dark` class (e.g., `tw-dark`).

   ```javascript
   // tailwind.config.js
   module.exports = {
     darkMode: 'class',
     // ... other configuration options
   };
   ```

2. **Manually Toggle Dark Mode:**

   To manually toggle dark mode, you can use JavaScript to add or remove the `dark` class from the `html` element based on user preferences or a user's interaction. You can store the user's preference in `localStorage` and use the `Window.matchMedia()` API to detect the system's dark mode preference. Here's a sample JavaScript code:

   ```javascript
   // In your JavaScript file (e.g., app.js)
   if (
     localStorage.theme === 'dark' ||
     (!('theme' in localStorage) &&
       window.matchMedia('(prefers-color-scheme: dark)').matches)
   ) {
     document.documentElement.classList.add('dark');
   } else {
     document.documentElement.classList.remove('dark');
   }

   // To explicitly choose light mode
   localStorage.theme = 'light';

   // To explicitly choose dark mode
   localStorage.theme = 'dark';

   // To respect the OS preference
   localStorage.removeItem('theme');
   ```

   This code checks if the user's preference is set to dark in `localStorage` or if the system's preference is dark. If so, it adds the `dark` class to the `html` element. You can call this script on page load or when a user interacts with a dark mode toggle button.

3. **HTML Structure with Dark Mode Class:**

   In your HTML or JSX files, apply the `dark` class to the `html` element when dark mode is enabled. Here's an example:

   ```jsx
   // In your Next.js component
   import React from 'react';

   function MyComponent() {
     return (
       <html className="dark">
         <body>
           {/* Your content */}
         </body>
       </html>
     );
   }

   export default MyComponent;
   ```

   In this example, we add the `dark` class to the `html` element to enable dark mode manually.

4. **Apply Dark Mode Styles:**

   With the `dark` class applied to the `html` element, you can use Tailwind CSS's dark mode variants to style your components differently when dark mode is enabled. For example, you can use `dark:bg-gray-900` to set the background color to dark gray in dark mode.

   ```jsx
   // In your Next.js component
   import React from 'react';

   function MyComponent() {
     return (
       <div className="bg-white dark:bg-gray-900">
         <p>Content goes here.</p>
       </div>
     );
   }

   export default MyComponent;
   ```

   In this example, the background color will be white in light mode and dark gray in dark mode.

By following these steps, you can implement dark mode in your Next.js application using Tailwind CSS. Users can manually toggle dark mode, and your styles will adapt accordingly based on the presence of the `dark` class in the HTML element.



