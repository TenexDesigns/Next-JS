To keep components pure , keep chanages out of the render phases


  Side effects
  - Store data in local storage
  - Call the server to fetch/save data
  - Manualy modify the dom


  UseEffect
  - To excute a piece of code after a component has rendred
 - After render

  We can have multiple useEffect, react will excute them in order


  -React renders each component because of stric mode in development


  React exutes effect after a render, and to make effect hook excute again, we can use a depency, which will recute the code in the useEffce hook if the depency chnages, the change can be caues by a change in satet of th depency



  Code Clean up
  - In the clean up our functions should undo or stop what ever whas happening in the effect hook , e.g  timer, connection to server, if subscribing, our clean up should unsubscribe, if our effect is feching data from server , in clean up it should abort the fetch 






promise - An object that holds the eventual result or failure of an asuncrous(or long running) operation

























  
