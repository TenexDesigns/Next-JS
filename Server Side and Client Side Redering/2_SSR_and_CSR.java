

1

2
The recommended applications for client-side rendering and server-side rendering in Next.js are as follows:

Client-side rendering (CSR)

When adding interactivity and event listeners like onClick(), onChange(), and others.
When using useState and lifecycle effects like useState(), useReducer(), useEffect(), and others.
When using browser-only APIs.
Server-side rendering (SSR)

Fetch data.
Access backend resources (directly).
Keep sensitive information on the server (access tokens, API keys, and others).
Keep large dependencies on the server/reduce client-side JavaScript.
Code samples

Client-side rendering

JavaScript
// Client-side component
import React from 'react';

const MyComponent = () => {
  const [count, setCount] = React.useState(0);

  const handleClick = () => {
    setCount(count + 1);
  };

  return (
    <div>
      <button onClick={handleClick}>Click me</button>
      <p>Count: {count}</p>
    </div>
  );
};

export default MyComponent;
Use code with caution. Learn more
Server-side rendering

JavaScript
// Server-side component
import React from 'react';
import { getStaticProps } from 'next';

const MyComponent = ({ data }) => {
  return (
    <div>
      <h1>{data.title}</h1>
      <p>{data.content}</p>
    </div>
  );
};

export async function getStaticProps() {
  const response = await fetch('https://api.example.com/data');
  const data = await response.json();

  return {
    props: {
      data,
    },
  };
}

export default MyComponent;
Use code with caution. Learn more
How to use and apply each in Next.js

To use client-side rendering in Next.js, simply create a React component and export it from your page. Next.js will automatically render the component on the client side.

To use server-side rendering in Next.js, you need to export a function called getStaticProps from your page. This function will be called on the server to fetch data and generate the page's HTML.

Here is an example of how to use server-side rendering to fetch data and render a page:

JavaScript
// pages/index.js
import React from 'react';
import { getStaticProps } from 'next';

const Home = ({ data }) => {
  return (
    <div>
      <h1>{data.title}</h1>
      <p>{data.content}</p>
    </div>
  );
};

export async function getStaticProps() {
  const response = await fetch('https://api.example.com/data');
  const data = await response.json();

  return {
    props: {
      data,
    },
  };
}

export default Home;
Use code with caution. Learn more
When you visit this page, Next.js will call the getStaticProps function to fetch the data and generate the page's HTML. This HTML will then be sent to the client and rendered.

Benefits of client-side rendering and server-side rendering

Client-side rendering has the following benefits:

It is faster than server-side rendering because the page's HTML does not need to be generated on the server.
It is more interactive because the page can be updated without having to reload the page.
Server-side rendering has the following benefits:

It is better for SEO because the page's HTML is generated on the server and can be indexed by search engines.
It is better for performance on slow devices because the page's HTML is sent to the client in a single request.
Which one to use?

The best rendering strategy for your app will depend on your specific needs. If you need a fast and interactive app, then client-side rendering is a good choice. If you need an app that is good for SEO and performs well on slow devices, then server-side rendering is a good choice.

You can also use a combination of client-side rendering and server-side rendering in your app. For example, you could use server-side rendering to generate the initial page HTML and then use client-side rendering to update the page without having to reload it.













  ..
