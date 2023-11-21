"use client";

// Import the necessary components from Material-UI
import { Button, TextField, Typography } from "@mui/material";

// Your React component using Material-UI components
function MyComponent() {
  return (
    <div>
      <Typography variant="h1">Hello Material-UI!</Typography>
      <Button variant="contained" color="primary">
        Click me
      </Button>
      <TextField label="Enter text" variant="outlined" />

      <Button variant="contained" color="success" size="large">
        Click me
      </Button>
    </div>
  );
}

export default MyComponent;
