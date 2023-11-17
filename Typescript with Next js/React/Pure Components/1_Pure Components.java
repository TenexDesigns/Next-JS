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
