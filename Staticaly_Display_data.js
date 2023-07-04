To statically display and fetch data in a Next.js component, you can use various approaches. Heres a simplified example:

import { useEffect, useState } from 'react';

const MyComponent = () => {
  const [users, setUsers] = useState([]);

  useEffect(() => {
    // Fetch data from an API or a local file
    const fetchData = async () => {
      try {
        const response = await fetch('https://api.example.com/users');
        const data = await response.json();
        setUsers(data);
      } catch (error) {
        console.error('Error fetching data:', error);
      }
    };

    fetchData();
  }, []);

  return (
    <div>
      <h1>Products</h1>
      {users.map((user) => (
        <div key={user.id}>{user.name}</div>
      ))}
    </div>
  );
};

export default MyComponent;
In this example, the useState hook is used to initialize the users state variable as an empty array.
  The useEffect hook is responsible for fetching the data from an API endpoint (e.g., https://api.example.com/users) when the component mounts. Once the data is retrieved, it is stored in the users state using the setUsers function.

Finally, the retrieved users array is mapped over, and for each user, a <div> element is rendered with their name.
  The key attribute is assigned the id of each user to ensure efficient rendering and update of the list.

Remember to replace the API endpoint (https://api.example.com/users) with the actual endpoint you are using to fetch the data.





MORE EXPLANANTION
*******************************************************************************************

  To statically display and fetch data in a Next.js component, you can use the getStaticProps function. This function lets you fetch data at build time and pass it as props to your component. Here is an example:

export async function getStaticProps() {
  const res = await fetch('https://api.example.com/products')
  const products = await res.json()

  return {
    props: {
      products,
    },
  }
}

export default function Products({ products }) {
  return (
    <div>
      <h1>Products</h1>
      {products.map((product) => (
        <div key={product.id}>{product.name}</div>
      ))}
    </div>
  )
}
In this example, the getStaticProps function fetches data from an API at build time and passes it to the Products component as a prop.
  The Products component then renders the data. spacejelly.dev

If you want to fetch data at request time instead of at build time, you can use the getServerSideProps function. Here is an example:

export async function getServerSideProps() {
  const res = await fetch('https://api.example.com/products')
  const products = await res.json()

  return {
    props: {
      products,
    },
  }
}

export default function Products({ products }) {
  return (
    <div>
      <h1>Products</h1>
      {products.map((product) => (
        <div key={product.id}>{product.name}</div>
      ))}
    </div>
  )
}
In this example, the getServerSideProps function fetches data from an API each time the page is requested and passes it to the Products component as a prop.
  The Products component then renders the data. spacejelly.dev






















                                      
