// import { FieldValues, useForm } from 'react-hook-form';
// const MyForm = () => {
//     const { control, register,handleSubmit, formState: { errors } } = useForm();

//     const onSubmit = (data :FieldValues) => {
//       // Handle form submission
//       console.log(data);
//     };

//     return (
//       <form onSubmit={handleSubmit(onSubmit)}>
//         <label>
//           Email:
//           <input name="name" type="text" {...register('name', { required: true } )} />

//           {errors.email && <p>{errors.email.message}</p>}
//         </label>

//         {/* Other form fields with validation go here */}

//         <button type="submit">Submit</button>
//       </form>
//     );
//   };
