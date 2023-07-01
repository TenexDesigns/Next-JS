React vs NextJs
By default , Next  js pre-renders every page in the application

What does pre-rendering mean
Pre-Rending means -Next js generates HTML for  each page in adavance instead of having it all done by client side javascript.



Why Pre-Rendeing in next js

1. Pre-rendering improves performance
   - In a react app , you need to wait for javascript to be excuted, perharps fetch data from an external api and then rendeer the UI. This cause a wait  time for the user
   - With a pre-rendered pages in next js, The HTML is already generated and loads faster

2.Pre-rendering helps with SEO
-If you are building a blog or e-commerce site, SEO is a concern, the pre-rendering is what you want as it helps search engine clawwlers.
 


STATIC GENERATION

A method of pre-rendering where HTMl pages are generated at build time
The HTML with all the data that make up the conetent of the web pages are generated in advance when you build your application
This is the recommended method to pre-render pages when ever possible- since pages can be built once,cached by a cdn and served to the client almost instantly

This method is GOOD For
Blog pages
E-Commerce productpages
Doccumenatation
Marketing pages


STAIC GENERATION -HOW TO IMPLEMENT IT
Next js by default automaticaly  staticaly generates every page in our app when we build our application
So every app is alrady staticlay generated when we build it.



Staticaly Generate Pages -After Fetching Some Data

















