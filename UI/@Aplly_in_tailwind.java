Using `@apply` in Tailwind CSS allows you to reuse styles and create custom utility classes for specific components or elements. It's a powerful feature that helps you maintain consistent styles while reducing redundancy. However, it's essential to use `@apply` judiciously to avoid premature abstraction and maintain the advantages of Tailwind CSS.

Here's how you can reuse styles with `@apply` in Tailwind CSS:

1. **Define Custom Utility Classes:**

   In your CSS file (typically where you define your custom styles), create a custom utility class and use `@apply` to apply Tailwind CSS classes to it. For example, you can create a custom button style:

   ```css
   /* styles.css */
   .custom-button {
     @apply py-2 px-4 bg-blue-500 text-white font-semibold rounded-lg shadow-md hover:bg-blue-700 focus:outline-none focus:ring-2 focus:ring-blue-400 focus:ring-opacity-75;
   }
   ```

   In this example, we define a `.custom-button` class that incorporates various Tailwind CSS utility classes.

2. **Apply the Custom Utility Class:**

   In your HTML or JSX files, you can now use the `.custom-button` class as a utility class for buttons or elements that require this specific style:

   ```jsx
   // In your Next.js component
   import React from 'react';

   function MyComponent() {
     return (
       <div>
         <button className="custom-button">Click Me</button>
       </div>
     );
   }

   export default MyComponent;
   ```

   By applying the `.custom-button` class to the button element, you reuse the defined styles.

The key point to remember when using `@apply` is to avoid excessive abstraction. It's best suited for small, highly reusable styles like buttons, form controls, or specific UI components. Using it for everything can lead to the disadvantages mentioned in your quoted text, such as making changes more complicated and increasing the CSS bundle size.

In summary, `@apply` is a valuable tool for creating custom utility classes and reusing styles in Tailwind CSS, but it should be used thoughtfully and for genuinely reusable elements to maintain the benefits of Tailwind's workflow and maintainability.
