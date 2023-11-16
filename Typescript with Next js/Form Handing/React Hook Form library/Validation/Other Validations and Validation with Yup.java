React Hook Form supports a wide range of validations out of the box, including:

- **Required Fields**: Ensures that a field is not left empty.
- **Minimum and Maximum Length**: Validates the length of a string or array.
- **Minimum and Maximum Value**: Validates the numerical value of a field.
- **Pattern Matching**: Validates a field against a regular expression.
- **Email Validation**: Validates that a field contains a valid email address.
- **URL Validation**: Validates that a field contains a valid URL.
- **Numeric Validation**: Validates that a field contains a numeric value.
- **Custom Validations**: You can also define your own custom validation rules.

In addition to these, React Hook Form also supports schema-based validation with libraries like Yup and Zod. A validation schema is a predefined set of rules that your form data must adhere to. If the data does not match the schema, the validation fails.

Yup is a JavaScript schema builder for value parsing and validation. It allows you to create a schema that describes the shape of your data, and it can be used to validate that your data matches this schema. It supports a wide range of validations, including string, number, date, boolean, array, and object validations.

Here's an example of how you can use Yup with React Hook Form:

```jsx
import { useForm } from "react-hook-form";
import { yupResolver } from "@hookform/resolvers/yup";
import * as yup from "yup";

const schema = yup.object().shape({
 firstName: yup.string().required(),
 age: yup.number().positive().integer().required(),
});

function Form() {
 const { register, handleSubmit, formState: { errors } } = useForm({
   resolver: yupResolver(schema),
 });

 const onSubmit = (data) => console.log(data);

 return (
   <form onSubmit={handleSubmit(onSubmit)}>
     <input {...register("firstName")} />
     <p>{errors.firstName?.message}</p>
     <input {...register("age")} />
     <p>{errors.age?.message}</p>
     <input type="submit" />
   </form>
 );
}
```

In this example, the `yupResolver` is used to connect Yup with React Hook Form. The `schema` is a Yup object that describes the shape of the data. The `firstName` field is required and must be a string, and the `age` field is required, must be a positive integer, and must be a number. If the data does not match this schema, the `errors` object will contain the validation errors [Source 5](https://react-hook-form.com/get-started).

For custom validations, you can use the `validate` property in the `register` function. This property accepts a function that takes the field value as an argument and returns `true` if the validation passes and `false` if it fails. Here's an example:

```jsx
<input
 {...register('customField', {
   validate: value => value === 'customValue' || 'Invalid value',
 })}
/>
```

In this example, the `validate` function checks if the field value is equal to 'customValue'. If it's not, it returns the error message 'Invalid value' [Source 23](https://www.carlrippon.com/custom-validation-rules-in-react-hook-form/).
                                                                                                                                                                    
                                                                                                                                                                    
                                                                                                                                                                    
                                                                                                                                                                    
                                                                                                                                                                    ....
