build a expandiple componet in react typescript , where user clicks buttton to see mor or less, where less is a max of 100 charcters





--------------------------------------------------------------------------------------------------
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



How to use it
------------------------------------------

function page() {
  let [isVisible, setVisible] = useState(false);
  return (
    <>
      <Expand>
        ctetur quo luptas consequun quo luptas consequun quo luptas consequun
        quo luptas consequun quo luptas consequun quo luptas consequun quo
        luptas consequun quo luptas consequun tur harum nemo.
      </Expand>
    </>






ANOTHER SOLUTION
    -------------------------------------------------------------------------------------------------------------------------------

    Certainly! You can create an expandable component in React with TypeScript where the user can click a button to see more or less text, with a limit of 100 characters. Here's an example:

```tsx
import React, { useState } from 'react';

interface ExpandableTextProps {
  initialText: string;
  maxLength: number;
}

const ExpandableText: React.FC<ExpandableTextProps> = ({ initialText, maxLength }) => {
  const [expanded, setExpanded] = useState(false);

  const truncatedText = initialText.slice(0, maxLength);
  const shouldTruncate = initialText.length > maxLength;

  const toggleExpand = () => {
    setExpanded(!expanded);
  };

  return (
    <div>
      <p>{expanded ? initialText : truncatedText}</p>
      {shouldTruncate && (
        <button onClick={toggleExpand}>{expanded ? 'Show Less' : 'Show More'}</button>
      )}
    </div>
  );
};

export default ExpandableText;
```

In this example:

- The `ExpandableText` component takes two props: `initialText` (the full text to display) and `maxLength` (the maximum number of characters to show initially).
- The text is truncated to the specified `maxLength` if it exceeds that length.
- If the text is truncated, a button is rendered that allows the user to toggle between showing more or less text.
- Clicking the button updates the `expanded` state, which controls whether the full text or truncated text is displayed.

You can then use this component in your application like this:

```tsx
import React from 'react';
import ExpandableText from './ExpandableText';

const App: React.FC = () => {
  const longText =
    'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.';

  return (
    <div>
      <h1>Expandable Text Example</h1>
      <ExpandableText initialText={longText} maxLength={100} />
    </div>
  );
};

export default App;
```

This example demonstrates how to use the `ExpandableText` component with a long text, and the button allows the user to expand or collapse the text.














