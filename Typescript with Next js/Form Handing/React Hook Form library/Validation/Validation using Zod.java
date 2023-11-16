import React from "react";
import { FieldValues, useForm } from "react-hook-form";
import { zodResolver } from "@hookform/resolvers/zod";
import { z } from "zod";

const schema = z.object({
  name: z.string().min(3, { message: "Name must be at least 3 characters" }),
  age: z
    .int()
    .positive({ message: "Age must be a positive number" }),
});
interface FormData {
  name: string;
  age: number;
}

function Form2() {
  const {
    register,
    handleSubmit,
    formState: { errors },
  } = useForm<FormData>({
    resolver: zodResolver(schema),
  });

  const onSubmit = (data: FieldValues) => {
    console.log(data);
  };

  return (
    <form onSubmit={handleSubmit(onSubmit)}>
      <div className="mb-3">
        <label htmlFor="name" className="form-label">
          Name
        </label>
        <input
          {...register("name")}
          type="text"
          className={`form-control ${errors.name ? "is-invalid" : ""}`}
        />
        {errors.name && (
          <div className="invalid-feedback">{errors.name.message}</div>
        )}
      </div>

      <div className="mb-3">
        <label htmlFor="age" className="form-label">
          Age
        </label>
        <input
          {...register("age")}
          type="number"
          className={`form-control ${errors.age ? "is-invalid" : ""}`}
        />
        {errors.age && (
          <div className="invalid-feedback">{errors.age.message}</div>
        )}
      </div>

      <button type="submit" className="btn btn-primary">
        Submit
      </button>
    </form>
  );
}

export default Form2;




...








[Zod](https://github.com/colinhacks/zod) is a TypeScript-first schema declaration and validation library. It is similar to Yup but designed with TypeScript in mind. Here's how you can use Zod for schema validation in a React Hook Form with custom error messages:

1. First, install Zod:

   ```bash
   npm install zod
   ```

2. Import Zod and define your schema:

   ```javascript
   import { z, object, string, number } from 'zod';

   const schema = object({
     name: string().min(3, { message: 'Name must be at least 3 characters' }),
     age: number().positive({ message: 'Age must be a positive number' }),
   });
   ```

3. Use Zod with React Hook Form:

   ```javascript
   import React from 'react';
   import { FieldValues, useForm } from 'react-hook-form';
   import { zodResolver } from '@hookform/resolvers/zod';

   function Form2() {
     const {
       register,
       handleSubmit,
       formState: { errors },
     } = useForm({
       resolver: zodResolver(schema),
     });

     const onSubmit = (data: FieldValues) => {
       console.log(data);
     };

     return (
       <form onSubmit={handleSubmit(onSubmit)}>
         <div className="mb-3">
           <label htmlFor="name" className="form-label">
             Name
           </label>
           <input
             {...register('name')}
             type="text"
             className={`form-control ${errors.name ? 'is-invalid' : ''}`}
           />
           {errors.name && (
             <div className="invalid-feedback">{errors.name.message}</div>
           )}
         </div>

         <div className="mb-3">
           <label htmlFor="age" className="form-label">
             Age
           </label>
           <input
             {...register('age')}
             type="number"
             className={`form-control ${errors.age ? 'is-invalid' : ''}`}
           />
           {errors.age && (
             <div className="invalid-feedback">{errors.age.message}</div>
           )}
         </div>

         <button type="submit" className="btn btn-primary">
           Submit
         </button>
       </form>
     );
   }

   export default Form2;
   ```

In this example, the `zodResolver` from `@hookform/resolvers/zod` is used to integrate Zod with React Hook Form. The error messages are accessed using `errors.name.message` and `errors.age.message`. Customize the error messages as needed in the Zod schema.

----------------------------------------------------------------------------------------------------------------------------------------








[Zod](https://github.com/colinhacks/zod) is a TypeScript-first schema declaration and validation library. It is similar to Yup but designed with TypeScript in mind. Here's how you can use Zod for schema validation in a React Hook Form with custom error messages:

1. First, install Zod:

   ```bash
   npm install zod
   ```

2. Import Zod and define your schema:

   ```javascript
   import { z, object, string, number } from 'zod';

   const schema = object({
     name: string().min(3, { message: 'Name must be at least 3 characters' }),
     age: number().positive({ message: 'Age must be a positive number' }),
   });
   ```

3. Use Zod with React Hook Form:

   ```javascript
   import React from 'react';
   import { FieldValues, useForm } from 'react-hook-form';
   import { zodResolver } from '@hookform/resolvers/zod';

   function Form2() {
     const {
       register,
       handleSubmit,
       formState: { errors },
     } = useForm({
       resolver: zodResolver(schema),
     });

     const onSubmit = (data: FieldValues) => {
       console.log(data);
     };

     return (
       <form onSubmit={handleSubmit(onSubmit)}>
         <div className="mb-3">
           <label htmlFor="name" className="form-label">
             Name
           </label>
           <input
             {...register('name')}
             type="text"
             className={`form-control ${errors.name ? 'is-invalid' : ''}`}
           />
           {errors.name && (
             <div className="invalid-feedback">{errors.name.message}</div>
           )}
         </div>

         <div className="mb-3">
           <label htmlFor="age" className="form-label">
             Age
           </label>
           <input
             {...register('age')}
             type="number"
             className={`form-control ${errors.age ? 'is-invalid' : ''}`}
           />
           {errors.age && (
             <div className="invalid-feedback">{errors.age.message}</div>
           )}
         </div>

         <button type="submit" className="btn btn-primary">
           Submit
         </button>
       </form>
     );
   }

   export default Form2;
   ```

In this example, the `zodResolver` from `@hookform/resolvers/zod` is used to integrate Zod with React Hook Form. The error messages are accessed using `errors.name.message` and `errors.age.message`. Customize the error messages as needed in the Zod schema.
















  
