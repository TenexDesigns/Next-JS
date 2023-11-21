import React, { useState } from "react";

function ArrayManipulationExample() {
  const [pizza, setPizza] = useState({
    name: "Spicy",
    toppings: ["shrooms"],
  });
  const add = () => {
    setPizza((prev) => ({
      ...prev,
      toppings: [...prev.toppings, "new shroom"],
    }));
  };

  const [game, setGame] = useState({
    id: 1,
    player: {
      name: "john",
    },
  });

  const multiply = (a: number, b: number) => a * b;
  multiply(3, 4);

  const update = () => {
    setGame((prev) => ({ ...prev, player: { ...prev.player, name: "kim" } }));
  };
  const [items, setItems] = useState(["Item 1", "Item 2", "Item 3"]);

  const removeItem = (indexToRemove: number) => {
    // Use the filter method to create a new array without the removed item
    const updatedItems = items.filter((_, index) => index !== indexToRemove);
    setItems(updatedItems);
  };

  return (
    <div>
      <ul>
        {items.map((item, index) => (
          <li key={index}>
            {item}
            <button onClick={() => removeItem(index)}>Remove</button>
          </li>
        ))}
      </ul>

      <div>
        <div></div>
        <p>
          <span></span>
          <br />
        </p>
        <h1></h1>
      </div>

      <div>
        <div></div>
        <p>
          <span></span>
          <div></div>
        </p>
        <h1></h1>
      </div>

      <input type="url" name="" id="" />

      <button type="submit"></button>
      <button type="button"></button>

      <button type="reset"></button>
      <button type="submit"></button>
      <button></button>
      <input type="image" src="" alt="" />
      <output></output>

      <tr></tr>
      <select name="" id=""></select>
    </div>
  );
}

export default ArrayManipulationExample;
