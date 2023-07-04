In Next.js, getStaticProps is a function used in the context of Static Generation (SSG).
  It allows you to fetch data at build time and pre-render a page with the fetched data. 
  Heres an explanation of getStaticProps and its features, along with the provided notes:


1.getStaticProps runs only on the server side:

    - The function is executed during the build process and will never run client-side in the browser.
    - The code inside getStaticProps is not included in the JavaScript bundle sent to the browser, ensuring that sensitive server-side code remains secure.
    

2.You can write server-side code directly in getStaticProps:

    - getStaticProps runs in a server-side environment, so you can perform server-side operations like accessing the filesystem using the fs module or querying a database.
    - You can safely include sensitive information like API keys in getStaticProps because this code won't be sent to the browser.
    


3.getStaticProps is allowed only in a page and cannot be run from a regular component file:

    - It is a special function that is specific to Next.js pages and is used for pre-rendering.
    - getStaticProps cannot be used in regular component files. It is designed to be used within the context of a Next.js page.



4.getStaticProps should return an object with a props key:

     - The getStaticProps function should return an object that contains a props key, which itself is an object.
     - The props object represents the props that will be passed to the page component when it is rendered.
     - The values in the props object will be serialized and sent to the browser, so make sure they are serializable.




5.getStaticProps will run at build time in production:

      - During production builds, getStaticProps will run at build time, fetching the data and pre-rendering the page.
      - In development mode, getStaticProps runs on every request, allowing you to see changes in the data without having to rebuild the entire application.
      



Example usage of getStaticProps:

// pages/index.js
import React from 'react';

const HomePage = ({ data }) => {
  // Use the fetched data to render the page
  return (
    <div>
      <h1>Welcome to the homepage!</h1>
      <p>{data}</p>
    </div>
  );
};

export async function getStaticProps() {
  // Fetch data from an API or perform any server-side operations
  const response = await fetch('https://api.example.com/data');
  const data = await response.json();

  return {
    props: {
      data, // Pass the fetched data as props to the page component
    },
  };
}

export default HomePage;




In this example, the getStaticProps function is defined within the HomePage page component. 
  It fetches data from an API endpoint (https://api.example.com/data) during the build process and passes the fetched data as a prop to the HomePage component. The data is then used to render the page.

During the build process, the page will be pre-rendered with the fetched data, and subsequent requests to the page will serve the pre-rendered version.







****************************************************************************************************************************************************************8
1.getStaticProps runs only on the server side
The function will never run client-side
The code you write inside  getStaticProps wont even be included in the JS bundle that is sent to the browser


2.You can write server-side code directly in getStaticProps
Accessing the filesystem using the fs module or querring a database can be done inside getStaticProps.
You also dont have to woory about includeing API keys in getStaticProps as that won;t make it to the browser


3.GetStaticProps  is allowed only in a page and cannot be run from a regular component file
It is used only for pre-rendering and not client-side data fething.


4.gwtStaticProps should return an object and object should contain a props key which is an object
In our example , we returned an object and the object contained a props key which wa an object as well

5.getStaticProps will run at build time in production
During developmemnt, getStaticProps runs on evevry request



















































