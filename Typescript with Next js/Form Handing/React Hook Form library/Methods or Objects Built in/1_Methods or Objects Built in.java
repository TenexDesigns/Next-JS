React Hook Form is a powerful library for managing form state and validation in React. It provides a custom hook, `useForm`, which returns an object with several methods and properties that you can use to manage your form [Source 2](https://react-hook-form.com/docs).

Here are some of the key methods and properties provided by `useForm`:

1. **register**: This function is used to register input/select Ref (reference) and validation rules into React Hook Form. You can register an input field by passing the field name and options to the `register` function.

2. **handleSubmit**: This function is used to handle form submission. It takes a callback function as an argument, which will be called with the form data when the form is submitted.

3. **watch**: This function allows you to watch specified inputs and return their values. It's useful when you want to watch specific inputs and react to changes.

4. **formState**: This object contains information about the form state, such as whether the form is valid, whether it's being submitted, and any errors that occurred.

5. **setValue**: This function allows you to programmatically set the value of specific fields.

6. **reset**: This function resets the form values and errors.

7. **clearErrors**: This function allows you to clear errors for specified fields.

8. **trigger**: This function triggers validation for specified fields.

Here's an example of how to use these methods in a form:

```jsx
import React from 'react';
import { useForm } from 'react-hook-form';

function Form() {
 const { register, handleSubmit, watch, formState: { errors } } = useForm();
 const onSubmit = data => console.log(data);

 return (
   <form onSubmit={handleSubmit(onSubmit)}>
     <input {...register("firstName", { required: true })} />
     {errors.firstName && <span>This field is required</span>}

     <input {...register("lastName", { required: true })} />
     {errors.lastName && <span>This field is required</span>}

     <input type="submit" />
   </form>
 );
}
```
[Source 1](https://blog.logrocket.com/react-hook-form-complete-guide/)

In this example, the `register` function is used to register the input fields and their validation rules. The `handleSubmit` function is used to handle form submission. The `watch` function is used to watch the form fields for changes. The `formState` object is used to access the form state and errors.

React Hook Form is a great choice for managing forms in React because it reduces the amount of code you need to write, improves performance by reducing re-renders, and provides a seamless experience for developers [Source 3](https://react-hook-form.com/).
