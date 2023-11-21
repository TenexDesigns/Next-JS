import React, { useState } from "react";

interface props {
  children: string;
  maxChar?: number;
}

function Expand({ children, maxChar = 103 }: props) {
  const [isExpanded, setExpanded] = useState(false);

  const text = isExpanded ? children : children.substring(0, maxChar);
  const shouldTruncate = children.length > maxChar;
  return (
    <p>
      {text}...{" "}
      {shouldTruncate && (
        <button onClick={() => setExpanded(!isExpanded)}>
          {" "}
          {isExpanded ? "Less" : "More"}
        </button>
      )}
    </p>
  );
}

export default Expand;
