The `swap` component in Daisy UI is used to toggle the visibility of two elements. It's particularly useful for creating toggleable content, such as a password visibility toggle or a dark mode switch. 

The `swap` component has two main child elements: 

- `swap-on`: This element is visible when the `swap` component is active.
- `swap-off`: This element is visible when the `swap` component is not active.

Here's a basic example of how to use the `swap` component:

```jsx
<div class="swap">
  <input type="checkbox" class="swap-checkbox" />
  <div class="swap-on">Swap On</div>
  <div class="swap-off">Swap Off</div>
</div>
```

In this example, the "Swap On" text is shown when the checkbox is checked, and the "Swap Off" text is shown when the checkbox is unchecked.

Here are some classes that you can use with the `swap` component:

- `swap-indeterminate`: This class is used for the child element that should be visible when the checkbox is in the indeterminate state.
- `swap-active`: This class activates the swap without needing a checkbox.
- `swap-rotate`, `swap-flip`: These classes add a rotate or flip effect to the swap.

To control the state of the `swap` component, you can use the `useState` hook in your React component. Here's an example:

```jsx
import { useState } from 'react'

export default function HomePage() {
  const [isSwapActive, setIsSwapActive] = useState(false)

  return (
    <div>
      <button onClick={() => setIsSwapActive(!isSwapActive)} class="btn">
        Toggle Swap
      </button>

      <div class={`swap ${isSwapActive ? 'swap-active' : ''}`}>
        <div class="swap-on">Swap On</div>
        <div class="swap-off">Swap Off</div>
      </div>
    </div>
  )
}
```

In this example, we're using a state variable `isSwapActive` to control the state of the `swap` component. When the "Toggle Swap" button is clicked, `isSwapActive` is toggled, and the `swap-active` class is added or removed from the `swap` component accordingly.

Remember to install Daisy UI and include it in your Tailwind CSS configuration:

```javascript
// tailwind.config.js
module.exports = {
  plugins: [
    require('daisyui'),
  ],
}
```

And then install it via npm:

```bash
npm i daisyui
```

[Source 0](https://daisyui.com/components/)
[Source 1](https://daisyui.com/full/)
[Source 2](https://v1.daisyui.com/)
[Source 3](https://v2.daisyui.com/)
[Source 4](https://daisyui.com/docs/colors/)
[Source 5](https://daisyui.com/docs/customize/)
