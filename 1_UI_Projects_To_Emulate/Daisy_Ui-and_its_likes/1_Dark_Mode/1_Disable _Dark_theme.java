To disable dark mode in your Next.js application with Daisy UI and Tailwind CSS, you have to modify the Daisy UI configuration in your `tailwind.config.js` file.

Daisy UI uses themes to set the color scheme of your application. By default, Daisy UI includes light and dark themes. If you want to disable the dark theme, you can set the themes configuration to only include the light theme.

Here is how you can do it:

```javascript
// tailwind.config.js
module.exports = {
  //...
  daisyui: {
    themes: ['light']
  },
}
```

In the above configuration, we're telling Daisy UI to only include the light theme. As a result, the dark theme will be disabled.

Another way to disable the dark theme is by setting the `darkTheme` configuration to `false`:

```javascript
// tailwind.config.js
module.exports = {
  //...
  daisyui: {
    darkTheme: false,
  },
}
```

This configuration tells Daisy UI to not use any theme as the default dark mode theme, effectively disabling dark mode.

Finally, if you want to disable all themes, you can set the `themes` configuration to `false`:

```javascript
// tailwind.config.js
module.exports = {
  //...
  daisyui: {
    themes: false,
  },
}
```

This configuration disables all Daisy UI themes, leaving you with the base styles to design your own look and feel.

Remember to restart your development server after making changes to the `tailwind.config.js` file for the changes to take effect.

[Source 0](https://daisyui.com/docs/config/)
[Source 2](https://daisyui.com/docs/themes/)
[Source 3](https://github.com/tailwindlabs/tailwindcss/discussions/6351)


