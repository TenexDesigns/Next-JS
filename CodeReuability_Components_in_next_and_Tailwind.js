FOR CODE REUSABILITY , YOU CAN USE COMPONENTS IN NEXT .JS


1.Create a new file for your card component (e.g., Card.js in the components directory):


import Image from "next/image";

// components/Card.js

const Card = ({ title, imageUrl, description }) => {
    return (
      <div className="max-w-sm rounded overflow-hidden shadow-lg m-2">
        <Image priority   width={500}  height={300} className="rounded-lg" src={imageUrl} alt={title}/>
        <div className="px-6 py-4">
          <div className="font-bold text-xl mb-2">{title}</div>
          <p className="text-gray-700 text-base">{description}</p>
        </div>
      </div>
    );
  };
  
export default Card;
  
In this example, the Card component accepts title, imageUrl, and description props and creates a card with these details. The class names used are Tailwind CSS utility classes that style the card.
  





  
2.Use the Card component in your pages:
// pages/index.js
import Card from '../components/Card';

export default function Home() {
  return (
    <div className="flex flex-wrap justify-around">
      <Card title="Card 1" imageUrl="/path/to/image1.jpg" description="This is card 1." />
      <Card title="Card 2" imageUrl="/path/to/image2.jpg" description="This is card 2." />
      <!-- More cards... -->
    </div>
  );
}
In this example, the Card component is imported and used in the Home component. You can pass different props to each Card to create unique cards blog.logrocket.com.
























