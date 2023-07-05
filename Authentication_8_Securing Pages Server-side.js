

Modify the above code to secure the pages on the server side, so that we user is not signed in the user is redireted to the sign in page, also explain what th permanet:false and callback:url mean in this context and in this code
*************************************************************************************




Sure, you can modify the getServerSideProps function to redirect the user to the sign-in page if they are not signed in. Here's how you can do it:

import { getServerSession } from 'next-auth/react'

function Blog({data}) {
  return (
    <div>Blog Pages - {data}</div>
  )
}

export default Blog

export async function getServerSideProps(context) {
  const session = await getServerSession(context.req)

  if (!session) {
    return {
      redirect: {
        destination: '/signin',
        permanent: false,
      },
    }
  }

  const data = 'List of 100 blogs available to signed in users'

  return {
    props: {
        data
    }
  }
}


In this code, if no session is found (i.e., the user is not signed in), getServerSideProps returns an object with a redirect property.
  This property is an object that specifies the URL to redirect to (destination: '/signin') and whether the redirect is permanent 
  (permanent: false) blog.logrocket.com.


  permanent:
  false is an option that can be used in the redirect function to indicate that the redirection is temporary.
  It corresponds to an HTTP status code of 307 (Temporary Redirect) rather than a permanent redirect (HTTP status code 301 or 308).
  It may be useful when you want to redirect the user temporarily for authentication purposes.


callbackUrl: 
    CallbackUrl is a parameter that can be used with certain authentication flows to specify the URL to redirect the user back to after authentication is completed. 
    It is commonly used in OAuth-based authentication flows where the user is redirected to an external authentication providers login page and then redirected back
    to your applications callback URL after successful authentication.


Here is how to use callback

export async function getServerSideProps(context) {
  const session = await getServerSession(context.req)

  if (!session) {
    return {
      redirect: {
        destination: 'google/signin?callbackUrl=http:localhost:3000/blog',
        permanent: false,
      },
    }
  }



































