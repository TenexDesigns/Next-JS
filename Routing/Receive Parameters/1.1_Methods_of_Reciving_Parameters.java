import {FC} from 'react';
import { PageProps } from '../../../.next/types/app/(auth)/login/page';

interface PageProps {
  params: {
    slug: string;
  };
}

const Page= async  ({ params}:PageProps) => {
  if (true) {
    return (
      <div>
        {}
      </div>
    );
  }
};






export default Page;



// Method 2
const page: FC<PageProps> = ({params}) =>{
  return <div>{params.slug}</div>
}


Method 3 - Data Fetching

const age = async ({params}: PageProps) => {

  // db fetching

  return  <div> {params.slug}</div>
}





Method 4 - Get Search Params
post/1?food=4
const ge = async (props:any) => {
  console.log(props)


  //We will  the search params
  console.log(props) -> gives us this
  {
    params{
      slug:1
    }
    searchParams{
      food:2
    }
  }

  return  <div> {props.params.slug}</div>
}





Method 5 - Catch all segment

[...postId]
post/1/blue/green/yello


const ge = async (props:any) => {
  console.log(props)


  We will receiver all parmas 
  {
    params{
      slug:[1,blue, grenn, yellow],  -> Array is  separated by slashes in url

    }
    searchParams{
      
    }
  }

  return  <div> {props.params.slug}</div>
}

