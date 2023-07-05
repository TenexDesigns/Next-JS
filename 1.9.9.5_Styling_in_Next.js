Next.js supports various ways to add styles to your application.


  
  1.Global Styles

To add global styles, create a CSS file (for example, styles.css) in the styles directory in the root of your project.

/* styles/styles.css */
body {
  margin: 0;
  font-family: Arial, sans-serif;
}
Then, import this file in your _app.js file, which is the top-level component in Next.js.

// pages/_app.js
import '../styles/styles.css';

function MyApp({ Component, pageProps }) {
  return <Component {...pageProps} />;
}

export default MyApp;






2.Component-Level Styles with CSS Modules

For component-level styles, Next.js supports CSS Modules, which automatically scope CSS to individual components. To use CSS Modules, create a .module.css file and import it into your component:

/* styles/Button.module.css */
.button {
  padding: 10px 20px;
  color: white;
  background-color: blue;
}
// components/Button.js
import styles from '../styles/Button.module.css';

function Button() {
  return <button className={styles.button}>Click me</button>;
}

export default Button;







3.CSS-in-JS

Next.js supports CSS-in-JS libraries like Styled Components and Emotion.
  These libraries allow you to write CSS directly in your JavaScript files. Heres an example using Styled Components:

// components/StyledButton.js
import styled from 'styled-components';

const Button = styled.button`
  padding: 10px 20px;
  color: white;
  background-color: blue;
`;

function StyledButton() {
  return <Button>Click me</Button>;
}

export default StyledButton;
Using Tailwind CSS with Next.js

Next.js also supports utility-first CSS libraries like Tailwind CSS. To install Tailwind CSS in your Next.js project,
  youll need to install it and its dependencies, add it to your postcss configuration, and then import it into your global styles.

Here are the commands to install Tailwind CSS:

npm install tailwindcss postcss autoprefixer
npx tailwindcss init -p


Then, import Tailwind CSS in your global styles:

/* styles/styles.css */
@import 'tailwindcss/base';
@import 'tailwindcss/components';
@import 'tailwindcss/utilities';
You can now use Tailwind CSS classes in your components:

// components/TailwindButton.js
function TailwindButton() {
  return <button className="px-4 py-2 text-white bg-blue-500">Click me</button>;
}

export default TailwindButton;
blog.logrocket.com, tailwindcss.com





































....
