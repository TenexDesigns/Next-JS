Starting from Next.js 13, there have been some changes regarding the _app.js file. The new feature introduced in Next.js 13
  is the App Router which is available in the app directory and co-exists with the pages directory beta.nextjs.org.

If you dont see the _app.js file under the pages directory, it could be because the file has been moved to the app directory as per the new convention.

Here is how you could structure your new _app.js file in the app directory:

// app/App.tsx
import { AppProps } from 'next/app'
import '../styles/globals.css'

export default function App({ Component, pageProps }) {
  return <Component {...pageProps} />
}
Note that the new app directory should be created at the root of your project or the src/ directory. This new structure will allow you to continue using pages with new features that work in both directories, such as the updated Image component, Link component, Script component, and Font optimization beta.nextjs.org.

However, upgrading to Next.js 13 does not require using the new App Router. If you prefer, you can continue using the old structure, with the _app.js file placed under the pages directory beta.nextjs.org.




..
