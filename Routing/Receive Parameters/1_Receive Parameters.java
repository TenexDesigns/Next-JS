To receive parameters in Next.js app routing using TypeScript, you'll need to define the `Page` component with type annotations. Here's the modified code with TypeScript:

```typescript
import React from 'react';

interface PageProps {
  params: {
    slug: string;
  };
}

const Page: React.FC<PageProps> = ({ params: { slug } }) => {
  if (true) {
    return (
      <div>
        {slug}
      </div>
    );
  }
};

export default Page;
```

In this code, the `Page` component is now declared as a functional component with TypeScript's `React.FC<PageProps>` type annotation. The `PageProps` interface defines the shape of the `params` prop, ensuring that it contains a `slug` property of type `string`. This type checking helps prevent errors during development and improves code readability.
