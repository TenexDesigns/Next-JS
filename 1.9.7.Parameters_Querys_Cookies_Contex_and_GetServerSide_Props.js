For Serverside rendering to happen,effectivelu, we nned access to the request and the response.
  To do this on the serverside, next gives us CONTEXT in the getServerSideProps() function
  This CONETEXT is an object that has accss to  --->  params, query, req, res, cookies, preview 






1.Understanding context in getServerSideProps

export async function getServerSideProps(context) {
  const { params, query, req, res, cookies, preview } = context
}

The context parameter in getServerSideProps provides information and utilities related to the current request and server-side rendering context. 
  It includes the following properties:

context.params: An object containing the dynamic route parameters.They are used to access a specific resource
context.query: An object containing the query parameters. They are used to sort resources based on certain conditions
context.req: The HTTP request object.
context.res: The HTTP response object.
context.cookies: An object for working with cookies (set/get).
context.preview: A boolean indicating whether the request is in preview mode.


-----------------------------------------------------------------------
  you can destructure it and see like this 

export async function getServerSideProps({ params, req, res, query, preview, previewData }) {
  // Now you can use params, req, res, query, preview, and previewData directly
  return {
    props: {}, // will be passed to the page component as props
  };
}

  

By destructuring the context object, you can directly access the individual properties within the function's scope.

Remember, getServerSideProps is only executed on the server side, so you won't be able to access these properties in client-side code.


The context parameter is an object containing the following properties:

    params:        Contains the route parameters for pages using dynamic routes.
    req:           The HTTP IncomingMessage object.
    res:           The HTTP response object.
    query:         The query string.
    preview:       true if the page is in the preview mode, false otherwise.
    previewData:   The preview data set by setPreviewData nextjs.org.






  2.PARAMETERS

There are two types of parameters , 
  There are 
  1.path paramters (params) - That are used to access a specific resourece
  2.Query Paramters (query) - they are used to filter resources based on certain condtions



--------->params: 

These are path parameters and are used when youre trying to access a specific resource. For example, in a blog application,
if you want to fetch a specific post, you might have a route like '/post/[id]', where id is the identifier of the post. 
  This id is a path parameter and is accessible through params.
  To access params in  next js 

export async function getServerSideProps(context) {
  const { params, query, req, res, cookies, preview } = context
  const {id} = params          //Accessing the 'id' parametere

  const response = await fetch('http://localhost/posts/${id}')




   const data = await response.json();
  return {
    props: { data }, // will be passed to the page component as props
  };

  
}


------->query:

These are query parameters that are often used to filter resources based on certain conditions.
  Queries refer to the key-value pairs that can be appended to the URL to provide additional information or filters. 
  They are typically represented by the ? symbol followed by key-value pairs separated by &
  For example, you might have a route like '/posts?author=john&tag=javascript' to fetch all posts written by John that are tagged with JavaScript.
  Here author=john and tag=javascript are query parameters and are accessible through query.


  export async function getServerSideProps(context) {
  const { params, query, req, res, cookies, preview } = context
  const {author,tag} =query

  const response = await fetch('http://localhost/posts?author=${author}&tag=${tag}')






   const data = await response.json();
  return {
    props: { data }, // will be passed to the page component as props
  };

  
}







3.Cookies

In Next.js, you can use cookies to store data that persists across multiple requests or sessions. Cookies can be used for various purposes like authentication, personalization, and tracking user behavior.
Cookies are small pieces of data that are stored in the user's browser. They are commonly used to store information about the user or their interactions with a website. In Next.js, you can use cookies to store data on the client-side and access them on subsequent requests.

To work with cookies in Next.js, you can use the cookies object available in the context parameter of getServerSideProps or getInitialProps. Here's an example:


export async function getServerSideProps(context) {
  // Set a cookie
  context.res.setHeader('Set-Cookie', 'cookieName=cookieValue');

  // Retrieve a cookie
  const cookieValue = context.req.cookies.cookieName;

  // ...
}
In the example above, context.res.setHeader('Set-Cookie', 'cookieName=cookieValue') is used to set a cookie named cookieName with the value cookieValue. The context.req.cookies object is used to retrieve the value of a cookie.

To remove a cookie, you can set an expiration date in the past or use the clearCookie method. Here's an example:

jsx
Copy code
export async function getServerSideProps(context) {
  // Remove a cookie by setting an expiration date in the past
  context.res.setHeader('Set-Cookie', 'cookieName=; Expires=Thu, 01 Jan 1970 00:00:00 GMT');

  // Alternatively, use clearCookie method
  context.res.clearCookie('cookieName');

  // ...
}
The clearCookie method is a convenience method provided by the http.ServerResponse object.

When working with cookies, keep the following points in mind:

Cookies are sent with every request to the server, so avoid storing sensitive information in cookies.
Each cookie has a maximum size limit (typically around 4KB), so avoid storing large amounts of data in cookies.
Cookies can have an expiration time, allowing them to persist for a specified duration or until the browser session ends. You can set an expiration date using the Expires attribute or use the Max-Age attribute to specify the number of seconds until the cookie expires.
Cookies can be set with additional attributes such as the Path, Domain, and Secure flags to control their behavior and scope.
Remember to handle cookie-related operations with caution and ensure that you comply with privacy regulations and best practices for handling user data.

























