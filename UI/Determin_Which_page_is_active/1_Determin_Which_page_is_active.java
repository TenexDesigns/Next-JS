In a Next.js and Tailwind CSS app, you can determine which page is active and apply a specific color to the corresponding link in your navigation bar by utilizing the `useRouter` from Next.js and conditional rendering. Here's a step-by-step guide:

1. First, make sure you have the `useRouter` hook imported from Next.js in your component:

   ```jsx
   import { useRouter } from 'next/router';
   ```

2. Use the `useRouter` hook to access the current route and pathname:

   ```jsx
   const router = useRouter();
   const { pathname } = router;
   ```

3. In your navigation bar component, add a CSS class that applies the desired color to the active link. You can define custom CSS classes in your Tailwind CSS stylesheet or use the built-in classes like `text-blue-500` to apply a blue color.

4. Conditionally apply the active CSS class to the corresponding link based on the current route's `pathname`.

Here's an updated version of the previous example with active link highlighting:

```jsx
import { useState, useEffect } from 'react';
import { useRouter } from 'next/router';

function Navbar() {
  const router = useRouter();
  const { pathname } = router;

  // State to track the screen width
  const [isSmallScreen, setIsSmallScreen] = useState(false);

  // Function to update the state based on screen width
  const updateScreenWidth = () => {
    setIsSmallScreen(window.innerWidth < 768); // Adjust the screen width breakpoint as needed
  };

  // Add an event listener to update the screen width state on window resize
  useEffect(() => {
    updateScreenWidth();
    window.addEventListener('resize', updateScreenWidth);
    return () => {
      window.removeEventListener('resize', updateScreenWidth);
    };
  }, []);

  // Function to check if a link is active
  const isLinkActive = (linkPath) => {
    return pathname === linkPath;
  };

  return (
    <nav className="bg-blue-500 p-4">
      <div className="container mx-auto flex justify-between items-center">
        <div className="text-white font-semibold text-lg">
          Your Logo
        </div>
        {isSmallScreen ? (
          <button className="text-white p-2 focus:outline-none">
            <svg
              xmlns="http://www.w3.org/2000/svg"
              className="h-6 w-6"
              fill="none"
              viewBox="0 0 24 24"
              stroke="currentColor"
            >
              <path
                strokeLinecap="round"
                strokeLinejoin="round"
                strokeWidth="2"
                d="M4 6h16M4 12h16M4 18h16"
              />
            </svg>
          </button>
        ) : (
          <div className="space-x-4">
            <a
              href="#"
              className={`text-white ${isLinkActive('/') ? 'text-blue-500' : ''}`}
            >
              Home
            </a>
            <a
              href="#"
              className={`text-white ${isLinkActive('/about') ? 'text-blue-500' : ''}`}
            >
              About
            </a>
            <a
              href="#"
              className={`text-white ${isLinkActive('/services') ? 'text-blue-500' : ''}`}
            >
              Services
            </a>
          </div>
        )}
      </div>
    </nav>
  );
}

export default Navbar;
```

In this code, we added the `isLinkActive` function, which takes a `linkPath` parameter and compares it with the current `pathname` obtained from `useRouter`. If they match, we apply the `text-blue-500` class to highlight the active link. You can adjust the color or customize the logic to suit your styling needs.
