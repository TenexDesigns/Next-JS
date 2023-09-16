To use the breadcrumbs component in Daisy UI, you can follow these steps:

1. Install Daisy UI by running the following command in your project directory:
   ```
   npm install daisyui
   ```

2. Import the necessary CSS styles in your project. You can do this by adding the following line to your main CSS file:
   ```css
   @import 'daisyui/dist/full.css';
   ```

3. Use the breadcrumbs component in your code. Here are some examples of how to use it:

   - Breadcrumbs without icons:
     ```jsx
     <div className="text-sm breadcrumbs">
       <ul>
         <li><a>Home</a></li> 
         <li><a>Documents</a></li> 
         <li>Add Document</li>
       </ul>
     </div>
     ```

   - Breadcrumbs with icons:
     ```jsx
     <div className="text-sm breadcrumbs">
       <ul>
         <li>
           <a>
             <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" className="w-4 h-4 mr-2 stroke-current"><path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M3 7v10a2 2 0 002 2h14a2 2 0 002-2V9a2 2 0 00-2-2h-6l-2-2H5a2 2 0 00-2 2z"></path></svg>
             Home
           </a>
         </li> 
         <li>
           <a>
             <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" className="w-4 h-4 mr-2 stroke-current"><path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M3 7v10a2 2 0 002 2h14a2 2 0 002-2V9a2 2 0 00-2-2h-6l-2-2H5a2 2 0 00-2 2z"></path></svg>
             Documents
           </a>
         </li> 
         <li>
           <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" className="w-4 h-4 mr-2 stroke-current"><path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M9 13h6m-3-3v6m5 5H7a2 2 0 01-2-2V5a2 2 0 012-2h5.586a1 1 0 01.707.293l5.414 5.414a1 1 0 01.293.707V19a2 2 0 01-2 2z"></path></svg>
           Add Document
         </li>
       </ul>
     </div>
     ```

   - Breadcrumbs with max-width:
     ```jsx
     <div className="max-w-xs text-sm breadcrumbs">
       <ul>
         <li>Long text 1</li>
         <li>Long text 2</li>
         <li>Long text 3</li>
         <li>Long text 4</li>
         <li>Long text 5</li>
       </ul>
     </div>
     ```

4. Customize the breadcrumbs component as needed. Daisy UI provides various utility classes that you can use to modify the appearance of the breadcrumbs. For example, you can change the color of the active or clicked breadcrumb by adding a specific class to it.

   To manage the state and determine the active/clicked breadcrumb, you can add event handlers to the breadcrumb links and update the state accordingly. Here's an example using React hooks:

   ```jsx
   import { useState } from 'react';

   function Breadcrumbs() {
     const [activeBreadcrumb, setActiveBreadcrumb] = useState('');

     const handleBreadcrumbClick = (breadcrumb) => {
       setActiveBreadcrumb(breadcrumb);
     };

     return (
       <div className="text-sm breadcrumbs">
         <ul>
           <li>
             <a
               className={activeBreadcrumb === 'Home' ? 'text-blue-500' : ''}
               onClick={() => handleBreadcrumbClick('Home')}
             >
               Home
             </a>
           </li>
           <li>
             <a
               className={activeBreadcrumb === 'Documents' ? 'text-blue-500' : ''}
               onClick={() => handleBreadcrumbClick('Documents')}
             >
               Documents
             </a>


