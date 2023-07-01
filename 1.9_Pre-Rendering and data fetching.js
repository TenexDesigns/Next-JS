1.What is pre rendering
2.Why is pre-rendering important
3.Types of Prerendering
4.Static Generation
  -Static Generation without data
  -Static Generation with data
  -Static Generation with incremental static generation
  -Static Generation with dynamic parameteres when fetching data

5.Server Side rendering
   - Server Side rendering with data fething
6.Client side data fetching
7.Combining pre-rendering wit client-side data fetching
8.When to choose one type of pre-rendering over the other






*************************************************************************************************

1.What is Pre-rendering?
  Pre-rendering is the process of generating static HTML pages for your website or application during the build process, before they are served to the client.
Pre-rendering is a feature in Next.js where a page is generated at build time (static generation) or on each request (server-side rendering). Instead of rendering everything from scratch in the browser, Next.js can serve pre-rendered HTML, improving performance and SEO (nextjs.org).

2.Why is Pre-rendering Important?
Pre-rendering is important because it improves accessibility, performance and SEO. By pre-rendering pages, you can serve static HTML files that load faster than JavaScript-rendered pages. This approach also ensures that your page content is visible to search engines, which can help improve your site's visibility in search results.
Pre-rendering is important for improved performance, better SEO, and accessibility.
  
3.Types of Prerendering
Next.js supports two types of pre-rendering: 
                                               - Static Generation  
                                               - Server-side Rendering.

                                                 
(A)WHat is Staic Generation
Static Generation is a pre-rendering method in Next.js where HTML pages are generated at build time. These pages are then served statically to the client without the need for server-side processing on each request. Static Generation is suitable for pages with data that does not change frequently.
                       Key Points
  ------------------------------------------------------------------------
   -   Pages are pre-rendered at build time, and the generated HTML is saved as static files.
   -   Generated pages are served to the client directly from the server or a CDN, providing fast and efficient delivery.
   -   The data for the pages can be fetched during the build process using the getStaticProps function, which runs only during build time.
   -   Changes to the data will require a rebuild of the application to generate updated static pages.
   -   Next.js provides features like incremental Static Generation, where you can specify a revalidation interval to update the static pages periodically.

(B)Server-side Rendering (SSR):
Server-side Rendering (SSR) is a method of pre-rendering where the page is generated on each request. This means that the server generates the HTML for each page on every request.
SSR is ideal for pages where the data changes frequently and needs to be up-to-date for each request. Because the pages are generated on each request, the data on the pages is always fresh 
Server-side Rendering is another pre-rendering method in Next.js where pages are rendered on each request on the server-side. This means that the server dynamically generates the HTML for each request, including any data fetching or processing required. SSR is suitable for pages with data that frequently changes or needs to be personalized per request.
                      Key Points
  ------------------------------------------------------------------------
   -   Pages are rendered on the server for each request and the HTML is sent to the client.
   -   Data fetching and processing can be performed in the getServerSideProps function, which runs on every request.
   -   Server-side Rendering is useful for scenarios where data changes frequently or requires server-side processing before rendering.
   -   It provides the ability to fetch data that is specific to the request or requires authentication.
   -   Server-side Rendering can be slower than Static Generation since it involves server-side processing for each request.

In summary, Static Generation is suitable for pages with data that does not change frequently and can be pre-rendered at build time, while Server-side Rendering is useful for pages with dynamic or personalized data that needs to be generated on each request. Next.js provides flexible options to choose between these pre-rendering methods based on the specific requirements of your application.

8.When to choose one type of pre-rendering over the other:

      (a) ---> Use Static Generation (SSG) when the data is relatively static and can be pre-rendered at build time.
      (b) ---> Use Server-side Rendering (SSR) when the data changes frequently or needs to be personalized per request.
      (c) ---> Use Client-side Data Fetching when the data is dynamic and needs to be fetched on the client-side after the initial page load.
                                                 
4.Static Generation (SSG)
Types of Static Generation
  -Static Generation without data
  -Static Generation with data
  -Static Generation with incremental static generation
  -Static Generation with dynamic parameteres when fetching data


  

  -Static Generation without Data**:
(A)---------------------------------        
 If a page does not need to fetch external data at build time, it is pre-rendered without data. This is the default behavior for Next.js pages. For example:

// pages/about.js
function About() {
  return <div>About page</div>;
}

export default About;






  -Static Generation with Data:
(B)--------------------------------------------
 If a page needs to fetch external data at build time, it uses getStaticProps.
  This function runs at build time in production and inside the function, you can fetch external data and send it as props to the page.


  // pages/products.js
function Products({ products }) {
  return (
    <div>
      <h1>Products</h1>
      {products.map((product) => (
        <div key={product.id}>{product.name}</div>
      ))}
    </div>
  );
}

export async function getStaticProps() {
  const response = await fetch('https://api.example.com/products');
  const products = await response.json();

  return {
    props: {
      products,
    },
  };
}

export default Products;







  -Static Generation with Incremental Static Generation:
(C)----------------------------------------------------
 You can update statically pre-rendered pages after build time by adding a revalidate property to getStaticProps.
  This property specifies how often (in seconds) the page should be regenerated.



   // pages/blog.js
function Blog({ posts }) {
  return (
    <div>
      <h1>Blog</h1>
      {posts.map((post) => (
        <div key={post.id}>{post.title}</div>
      ))}
    </div>
  );
}

export async function getStaticProps() {
  const response = await fetch('https://api.example.com/posts');
  const posts = await response.json();

  return {
    props: {
      posts,
    },
    revalidate: 60, // regenerate the page every 60 seconds
  };
}

export default Blog;




  -Static Generation with Static Generation with Dynamic Parameters:
(C)----------------------------------------------------
 If a page has dynamic routes and uses static generation, you can implement getStaticPaths which determines the paths that have to be rendered to HTML at build time.

   // pages/post/[id].js
import { useRouter } from 'next/router';

function Post({ post }) {
  return (
    <div>
      <h1>{post.title}</h1>
      <p>{post.content}</p>
    </div>
  );
}

export async function getStaticPaths() {
  // Fetch the paths for all posts
  const response = await fetch('https://api.example.com/posts');
  const posts = await response.json();

  const paths = posts.map((post) => ({
    params: { id: post.id.toString() },
  }));

  return { paths, fallback: false };
}

export async function getStaticProps({ params }) {
  // Fetch the post with the specified id
  const response = await fetch(`https://api.example.com/posts/${params.id}`);
  const post = await response.json();

  return {
    props: {
      post,
    },
  };
}

export default Post;




5.Server Side Rendering
     - **Server Side rendering with Data Fetching**: 
  (A)----------------------------------------------------
  If you need to pre-render a page whose data must be fetched at request time, you can export an async function called `getServerSideProps`. 
  This function will be called by the server on every request.


// pages/users.js
function Users({ users }) {
  return (
    <div>
      <h1>Users</h1>
      {users.map((user) => (
        <div key={user.id}>{user.name}</div>
      ))}
    </div>
  );
}

export async function getServerSideProps() {
  const response = await fetch('https://api.example.com/users');
  const users = await response.json();

  return {
    props: {
      users,
    },
  };
}

export default Users;




6.Client-side Data Fetching:
You can also fetch data on the client side. This approach is ideal for data that changes constantly, 
  user-specific data, and other types of data that cannot be fetched at build time.


  // pages/products.js
import { useEffect, useState } from 'react';

function Products() {
  const [products, setProducts] = useState([]);

  useEffect(() => {
    fetchProducts();
  }, []);

  const fetchProducts = async () => {
    const response = await fetch('https://api.example.com/products');
    const data = await response.json();
    setProducts(data);
  };

  return (
    <div>
      <h1>Products</h1>
      {products.map((product) => (
        <div key={product.id}>{product.name}</div>
      ))}
    </div>
  );
}

export default Products;





7.Combining pre-rendering with client-side data fetching:
You can combine pre-rendering (SSG or SSR) with client-side data fetching to get the best of both worlds. Pre-render the static parts of the page and fetch dynamic data on the client-side.

8.When to choose one type of pre-rendering over the other:

      (a) ---> Use Static Generation (SSG) when the data is relatively static and can be pre-rendered at build time.
      (b) ---> Use Server-side Rendering (SSR) when the data changes frequently or needs to be personalized per request.
      (c) ---> Use Client-side Data Fetching when the data is dynamic and needs to be fetched on the client-side after the initial page load.
  
Note: The code examples provided assume you are using Next.js and have the necessary configurations and dependencies set up.
























  
