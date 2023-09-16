
1
To use the Daisy UI Tabs component in Next.js and Tailwind CSS, you can follow these steps:

Install the daisyui package:

npm install daisyui
Add the daisyui package to your tailwind.config.js file:

JavaScript
module.exports = {
  theme: {
    extend: {
      colors: {
        primary: '#007bff',
        secondary: '#6c757d',
        success: '#28a745',
        info: '#17a2b8',
        warning: '#ffc107',
        danger: '#dc3545',
      },
    },
  },
  plugins: [
    require('@tailwindcss/typography'),
    require('@tailwindcss/forms'),
    require('@tailwindcss/daisyui'),
  ],
}
Use code with caution. Learn more
Import the Tabs and Tab components from the daisyui package:

JavaScript
import Tabs from '@daisyui/react/tabs';
import Tab from '@daisyui/react/tab';
Use code with caution. Learn more
Use the Tabs and Tab components in your Next.js page:

JavaScript
export default function Home() {
  const [activeTab, setActiveTab] = useState(0);

  // Update the active tab when the user clicks on a tab
  const handleClick = (tabIndex) => {
    setActiveTab(tabIndex);
  };

  return (
    <Tabs>
      <Tab active={activeTab === 0} onClick={() => handleClick(0)}>Tab 1</Tab>
      <Tab active={activeTab === 1} onClick={() => handleClick(1)}>Tab 2</Tab>
      <Tab active={activeTab === 2} onClick={() => handleClick(2)}>Tab 3</Tab>
    </Tabs>
  );
}
Use code with caution. Learn more
Variants

The Daisy UI Tabs component has the following variants:

Default: The default variant is a horizontal list of tabs.
Boxed: The boxed variant adds a box style to the tabs container.
Classes

The Daisy UI Tabs component has the following classes:

tabs: The container element.
tabs-boxed: Adds a box style to tabs container.
tab: A tab item.
tab-active: For the active tab.
tab-disabled: For a visually disabled tab.
tab-bordered: Adds bottom border to tab item.
tab-lifted: Adds lifted style to tab item.
tab-xs: Responsive, shows tab in extra small size.
tab-sm: Responsive, shows tab in small size.
tab-md: Responsive, shows tab in medium (default) size.
tab-lg: Responsive, shows tab in large size.
Managing state and determining which tab is active

To manage state and determine which tab is active, you can use the useState hook from React. For example, the code above shows how to create a simple Tabs component with state.

Taking the user to another page or tab

To take the user to another page or tab, you can use the next/router package. For example, the following code shows how to take the user to the /tab-2 page when they click on the second tab:

JavaScript
import { useRouter } from 'next/router';

const Home = () => {
  const router = useRouter();

  const handleClick = (tabIndex) => {
    if (tabIndex === 1) {
      router.push('/tab-2');
    }
  };

  return (
    <Tabs>
      <Tab active={activeTab === 0} onClick={() => handleClick(0)}>Tab 1</Tab>
      <Tab active={activeTab === 1} onClick={() => handleClick(1)}>Tab 2</Tab>
      <Tab active={activeTab === 2} onClick={() => handleClick(2)}>Tab 3</Tab>
    </Tabs>
  );
};

export default Home;
Use code with caution. Learn more
By following these steps, you can use the Daisy UI Tabs component to create a tabbed interface in your Next.js application.



  
