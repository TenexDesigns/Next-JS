In Daisy UI, the Progress component is used to display progress bars, and the Radial Progress component is used to display radial progress indicators. Below, I'll explain how to use these components, their different variants, and important classes with code samples. Typically, you use state to control the progress or radial progress.

**Using the Progress Component**:

To use the Progress component in your Next.js and Tailwind CSS application, follow these steps:

1. **Import the Progress Component**:

   Import the Progress component at the beginning of your Vue.js component or page file:

   ```vue
   import { DProgress } from 'daisyui';
   ```

2. **Use the Progress Component**:

   In your template, you can use the `d-progress` component to display different types of progress bars. You can conditionally set the progress value based on your application's logic.

   ```vue
   <template>
     <div>
       <!-- Primary Progress Bar -->
       <d-progress class="progress progress-primary" :value="progressValue" />

       <!-- Secondary Progress Bar -->
       <d-progress class="progress progress-secondary" :value="progressValue" />
     </div>
   </template>
   ```

   In this example, `progressValue` is a variable that determines the progress value. You can update this variable based on your application's logic.

**Available Variants for Progress**:

Here are some common variants for the Progress component:

- `progress-primary`: Adds a primary color to the progress bar.
- `progress-secondary`: Adds a secondary color to the progress bar.
- `progress-accent`: Adds an accent color to the progress bar.
- `progress-info`: Adds an info color to the progress bar.
- `progress-success`: Adds a success color to the progress bar.
- `progress-warning`: Adds a warning color to the progress bar.
- `progress-error`: Adds an error color to the progress bar.

You can choose the appropriate variant based on your application's design and preferences.

**Using State for Progress**:

To display and update the progress value, you typically use state management. For example, you can use a Vuex store or local component state to track the progress of an ongoing operation.

Here's an example of using local component state to control the progress:

```vue
<template>
  <div>
    <!-- Primary Progress Bar -->
    <d-progress class="progress progress-primary" :value="progressValue" />

    <!-- Secondary Progress Bar -->
    <d-progress class="progress progress-secondary" :value="progressValue" />
  </div>
</template>

<script>
export default {
  data() {
    return {
      progressValue: 0, // Initial progress value
    };
  },
  mounted() {
    // Simulate progress update (e.g., fetching data)
    this.updateProgress();
  },
  methods: {
    updateProgress() {
      // Simulate progress updates (e.g., fetching data)
      const interval = setInterval(() => {
        this.progressValue += 10; // Update the progress value
        if (this.progressValue >= 100) {
          clearInterval(interval); // Stop when progress reaches 100
        }
      }, 1000);
    },
  },
};
</script>
```

In this example, we use the `progressValue` data property to control the progress value. The `updateProgress` method simulates progress updates, but you should replace it with your application's logic for updating the progress value based on actual operations.

**Using the Radial Progress Component**:

The Radial Progress component works similarly to the Progress component but displays a radial progress indicator instead of a linear progress bar. The usage is similar to the Progress component, but you can customize the appearance and behavior based on your requirements.

You can use the `d-radial-progress` component to display radial progress.

```vue
<template>
  <div>
    <!-- Radial Progress -->
    <d-radial-progress class="progress" :value="progressValue" />
  </div>
</template>
```

Again, you should control the `progressValue` based on your application's logic.

The same principles of using state apply to Radial Progress as well. Use state management to control and update the progress value as needed.
