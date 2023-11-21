// import React from "react";
// import { FieldValues, useForm } from "react-hook-form";

// interface FormData {
//   name: string;
//   age: number;
// }

// function Form2() {
//   const {
//     register,
//     handleSubmit,
//     formState: { errors },
//   } = useForm<FormData>();
//   const onSubmit = (data: FieldValues) => console.log(data);
//   console.log(errors);

//   return (
//     <>
//       <form onSubmit={handleSubmit(onSubmit)}>
//         <div className="mb-3">
//           <label htmlFor="name" className="form-label">
//             Name
//           </label>
//           <input
//             {...(register("name"), { required: true, minLength: 3 })}
//             id="name"
//             type="text"
//             className="form-control"
//           />
//           {errors.name?.type === "required" && (
//             <p>The name field is required</p>
//           )}
//           {errors.name?.type === "minLength" && (
//             <p>The name must be 3 characters long</p>
//           )}
//         </div>

//         <div className="mb-3">
//           <label htmlFor="age" className="form-label">
//             Age
//           </label>
//           <input
//             {...register("age")}
//             id="age"
//             type="number"
//             className="form-control"
//           />
//         </div>

//         <button type="submit" className="btn btn-primary">
//           Submit
//         </button>
//       </form>
//     </>
//   );
// }

// export default Form2;
"use client";

// import React from "react";
// import { FieldValues, useForm } from "react-hook-form";

// interface FormData {
//   name: string;
//   age: number;
// }

// function Form2() {
//   const {
//     register,
//     handleSubmit,
//     formState: { errors },
//   } = useForm<FormData>();
//   const onSubmit = (data: FieldValues) => console.log(data);
//   console.log(errors);

//   return (
//     <>
//       <form onSubmit={handleSubmit(onSubmit)}>
//         <div className="mb-3">
//           <label htmlFor="name" className="form-label">
//             Name
//           </label>
//           <input
//             {...register("name", { required: true, minLength: 3 })}
//             id="name"
//             type="text"
//             className="form-control"
//           />
//           {errors.name?.type === "required" && (
//             <p>The name field is required</p>
//           )}
//           {errors.name?.type === "minLength" && (
//             <p>The name must be 3 characters long</p>
//           )}
//         </div>

//         <div className="mb-3">
//           <label htmlFor="age" className="form-label">
//             Age
//           </label>
//           <input
//             {...register("age", { required: true })}
//             id="age"
//             type="number"
//             className="form-control"
//           />
//           {errors.age?.type === "required" && <p>The age field is required</p>}
//         </div>

//         <button type="submit" className="btn btn-primary">
//           Submit
//         </button>
//       </form>
//     </>
//   );
// }

// // export default Form2;

import React from "react";
import { FieldValues, useForm } from "react-hook-form";
import { zodResolver } from "@hookform/resolvers/zod";
import { z } from "zod";

const schema = z.object({
  name: z.string().min(3, { message: "Name must be at least 3 characters" }),
  age: z
    .string()
    .min(1)
    .regex(/^\d+$/, { message: "Age must be a positive number" }),
});
interface FormData {
  name: string;
  age: number;
}

function Form2() {
  const {
    register,
    handleSubmit,
    reset,
    formState: { errors },
  } = useForm<FormData>({
    resolver: zodResolver(schema),
  });

  const onSubmit = (data: FieldValues) => {
    console.log(data);
  };

  return (
    <form
      onSubmit={handleSubmit((data) => {
        onSubmit(data);
        reset();
      })}
    >
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
