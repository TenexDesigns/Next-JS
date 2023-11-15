"use client";
import React from "react";
import { MouseEvent, useState } from "react";
import "bootstrap/dist/css/bootstrap.min.css";

interface Props {
  items: String[];
  heading: String;
  onSelectItem: (item: String) => void;
}

function ListGroup({ items, heading, onSelectItem }: Props) {
  let [selectedIndex, setIndex] = useState(-1);


  return (
    <>
      <h1> Helllo From Command prompts </h1>
      <ul className="list-group ">
        {items.map((i, index) => (
          <li
            onClick={() => {
              setIndex(index);
              console.log(i, index);
              onSelectItem(i);
            }}
            className={
              selectedIndex === index
                ? "list-group-item active"
                : "list-group-item"
            }
            key={index}
          >
            {i}
          </li>
        ))}
      </ul>
      <h1>{items[1]}</h1>
    </>
  );
}

export default ListGroup;








HERE IS WHERE WE SEND THE DATA OF THE PROPS
-----------------------------------------------------------------------------------------------------------------------------------------------------------

  "use client";
import React from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import ListGroup from "../components/ListGroup";
import AppProp from "../components/AppProp";

function page() {
  let items = ["kim", "Los Angelies", "Tokyo", "Okinawa", "Kyto", "Tel"];
  let handleSelectItem = (item: String) => {
    console.log(item);
  };

  return (
    <div>
      <div className="text-danger">Clddass Name</div>
      <div className="btn btn-primary">Click me!</div>

      <ListGroup
        items={items}
        heading={"Citites"}
        onSelectItem={handleSelectItem}
      />

   
    </div>
  );
}

export default page;
































