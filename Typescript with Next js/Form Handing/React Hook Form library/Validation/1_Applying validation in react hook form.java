
import React from "react";
import { FieldValues, useForm , isvalid } from "react-hook-form";

interface FormData {
  name: string;
  age: number;
}

function Form2() {
  const {
    register,
    handleSubmit,
    formState: { errors },
  } = useForm<FormData>();
  const onSubmit = (data: FieldValues) => console.log(data);
  console.log(errors);

  return (
    <>
      <form onSubmit={handleSubmit(onSubmit)}>
        <div className="mb-3">
          <label htmlFor="name" className="form-label">
            Name
          </label>
          <input
            {...register("name", { required: true, minLength: 3 })}
            id="name"
            type="text"
            className="form-control"
          />
          {errors.name?.type === "required" && (
            <p>The name field is required</p>
          )}
          {errors.name?.type === "minLength" && (
            <p>The name must be 3 characters long</p>
          )}
        </div>

        <div className="mb-3">
          <label htmlFor="age" className="form-label">
            Age
          </label>
          <input
            {...register("age", { required: true })}
            id="age"
            type="number"
            className="form-control"
          />
          {errors.age?.type === "required" && <p>The age field is required</p>}
        </div>

        <button disable={!isvalid} type="submit" className="btn btn-primary">
          Submit
        </button>
      </form>
    </>
  );
}

export default Form2;







EXPLANANTION
--------------------------------------------------------------------------------------------------------------
The issue with your code is in the way you're spreading the register function and the validation rules. The register function should be spread with the validation rules as its argument, not separately. Here's the corrected code:


  
The provided code is correct and effectively implements validation using React Hook Form. It defines a form component, registers form fields, applies validation rules, and handles validation errors. Here's a breakdown of the code:

1. **Importing React and React Hook Form:**

```javascript
import React from "react";
import { FieldValues, useForm } from "react-hook-form";
```

This imports React and the necessary components from React Hook Form.

2. **Defining the FormData Interface:**

```javascript
interface FormData {
 name: string;
 age: number;
}
```

This defines the structure of the form data, specifying that the 'name' field should be a string and the 'age' field should be a number.

3. **Creating the Form Component:**

```javascript
function Form2() {
 const {
  register,
  handleSubmit,
  formState: { errors },
 } = useForm<FormData>();
 const onSubmit = (data: FieldValues) => console.log(data);
 console.log(errors);
  ...
}
```

This creates a functional component named `Form2` that utilizes the `useForm` hook to handle form state and validation.

4. **Registering Form Fields and Applying Validation Rules:**

```javascript
<input
{...register("name", { required: true, minLength: 3 })}
id="name"
type="text"
className="form-control"
/>
<input
{...register("age")}
id="age"
type="number"
className="form-control"
/>
```

This registers the 'name' and 'age' fields using the `register` function. The `register` function takes the field name as the first argument and an object containing validation rules as the second argument. Here, the 'name' field is required to have a minimum length of 3 characters.

5. **Handling Validation Errors:**

```javascript
{errors.name?.type === "required" && (
  <p>The name field is required</p>
)}
{errors.name?.type === "minLength" && (
  <p>The name must be 3 characters long</p>
)}
```

This checks for specific types of errors for the 'name' field and displays corresponding error messages. The `errors` object contains error messages for all registered fields.

6. **Submitting the Form:**

```javascript
<button type="submit" className="btn btn-primary">
 Submit
</button>
```

This defines a submit button that triggers the `handleSubmit` function. The `handleSubmit` function takes a callback function that receives the form data upon successful form submission.

Overall, the provided code demonstrates how to effectively apply validations using React Hook Form, ensuring that user inputs meet the specified requirements.



  
