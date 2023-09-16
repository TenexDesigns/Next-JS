In a next js and tailwind applications, Explain with code samples , the   menu  component in daisy ui,How to use  menu componet in daisy Ui, what are its different variants,, what classes are avialabe to it  like, what each do and which are the most important to coniseder like"Menu
Menu is used to display a list of links vertically or horizontally.

prefix–
Class name
Type	
menu	Component	Container <ul> element
menu-title	Component	Specifies the title of menu
disabled	Modifier	Sets <li> as disabled
active	Modifier	Applies actives style to the element inside <li>
focus	Modifier	Applies focus style to the element inside <li>
menu-dropdown-toggle	Component	Class name for the toggle to show/hide the `menu-dropdown` using JS
menu-dropdown	Component	Class name for the collapsible <ul> if you want to show it using JS
menu-dropdown-show	Modifier	Shows the `menu-dropdown-toggle` and `menu-dropdown` collapsible submenu using JS
menu-xs	Responsive	Extra small size
menu-sm	Responsive	Small size
menu-md	Responsive	Medium size (default)
menu-lg	Responsive	Large size
menu-vertical	Responsive	Vertical menu (default)
menu-horizontal	Responsive	Horizontal menu
# Menu
# Responsive: vertical on small screen, horizontal on large screen
<ul className="menu menu-vertical lg:menu-horizontal bg-base-200 rounded-box">
  <li><a>Item 1</a></li>
  <li><a>Item 2</a></li>
  <li><a>Item 3</a></li>
</ul>
# Menu with icon only
<ul className="menu bg-base-200 rounded-box">
  <li>
    <a>
      <svg xmlns="http://www.w3.org/2000/svg" className="h-5 w-5" fill="none" viewBox="0 0 24 24" stroke="currentColor"><path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M3 12l2-2m0 0l7-7 7 7M5 10v10a1 1 0 001 1h3m10-11l2 2m-2-2v10a1 1 0 01-1 1h-3m-6 0a1 1 0 001-1v-4a1 1 0 011-1h2a1 1 0 011 1v4a1 1 0 001 1m-6 0h6" /></svg>
    </a>
  </li>
  <li>
    <a>
      <svg xmlns="http://www.w3.org/2000/svg" className="h-5 w-5" fill="none" viewBox="0 0 24 24" stroke="currentColor"><path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M13 16h-1v-4h-1m1-4h.01M21 12a9 9 0 11-18 0 9 9 0 0118 0z" /></svg>
    </a>
  </li>
  <li>
    <a>
      <svg xmlns="http://www.w3.org/2000/svg" className="h-5 w-5" fill="none" viewBox="0 0 24 24" stroke="currentColor"><path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M9 19v-6a2 2 0 00-2-2H5a2 2 0 00-2 2v6a2 2 0 002 2h2a2 2 0 002-2zm0 0V9a2 2 0 012-2h2a2 2 0 012 2v10m-6 0a2 2 0 002 2h2a2 2 0 002-2m0 0V5a2 2 0 012-2h2a2 2 0 012 2v14a2 2 0 01-2 2h-2a2 2 0 01-2-2z" /></svg>
    </a>
  </li>
</ul>"How do we manage state in Menu and  determine which is active or which is clickde.g cjhange its color



  
