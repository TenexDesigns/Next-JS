

/src
  doc
   [[...params]]



  import { useRouter } from 'next/router'
import { root } from 'postcss'
import React from 'react'


function Doc(){

    
const router = useRouter()
const {params =[]} = router.query
console.log(params)
if (params.length ===2 ){
    return (
        <h1>
            Viewing docs for feature {params[0]} and concept {params[1]}
        </h1>
    )
}
else if (params.length ===1){
    return <h1> Viewing docs for feature {params[0]}</h1>
}


return <h1>Docs Home page</h1>


}



export default Doc










for this path  http://localhost:3000/docs/1/2

we get this ---> Viewing docs for feature 1 and concept 2




for this path   http://localhost:3000/docs/products/cars

we get this --->  Viewing docs for feature products and concept cars
  





for this path  http://localhost:3000/docs/products/cars/bmw

we get this ---> Docs Home page




for this path  http://localhost:3000/docs/products

we get this --->Viewing docs for feature products



  for this path  http://localhost:3000/docs

we get this ---> Docs Home page
  










  
