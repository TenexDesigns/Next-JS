Yup is a JavaScript schema builder for value parsing and validation. It allows you to define a schema for your data and apply various validations. Here are some common types of validations that Yup provides:

1. **Type Checks:**
   - `string()`: Validates that the value is a string.
   - `number()`: Validates that the value is a number.
   - `boolean()`: Validates that the value is a boolean.
   - `date()`: Validates that the value is a date.
   - `array()`: Validates that the value is an array.
   - `object()`: Validates that the value is an object.

2. **String Checks:**
   - `min(length: number)`: Specifies the minimum length of a string.
   - `max(length: number)`: Specifies the maximum length of a string.
   - `matches(regex: RegExp, message?: string)`: Validates a string against a regular expression.

3. **Number Checks:**
   - `min(limit: number, message?: string)`: Specifies the minimum value for a number.
   - `max(limit: number, message?: string)`: Specifies the maximum value for a number.
   - `positive(message?: string)`: Validates that the number is positive.
   - `negative(message?: string)`: Validates that the number is negative.

4. **Date Checks:**
   - `min(date: Date | string, message?: string)`: Specifies the minimum date.
   - `max(date: Date | string, message?: string)`: Specifies the maximum date.

5. **Array Checks:**
   - `min(limit: number, message?: string)`: Specifies the minimum length of an array.
   - `max(limit: number, message?: string)`: Specifies the maximum length of an array.
   - `of(type: Schema): Validates the items of an array against a specified schema.

6. **Object Checks:**
   - `shape(fields: Object, noSortEdges?: boolean): Validates the shape of an object against a specified schema.

7. **Mixed Type Checks:**
   - `oneOf(arrayOfValues: Array<any>, message?: string)`: Validates that the value is one of the specified values.
   - `notOneOf(arrayOfValues: Array<any>, message?: string)`: Validates that the value is not one of the specified values.

8. **Custom Checks:**
   - `test(name: string, message: string | function, test: function)`: Allows you to define custom validations.

These are just some examples, and Yup provides many more methods and options for defining complex validation logic. It's a powerful library that is often used with form libraries in React, such as `react-hook-form`.


            









------------------------------------------------------------------------------------------------------------------------------------------------------------------------------







Yup is a powerful JavaScript schema builder for value parsing and validation. It provides a wide range of validations out of the box, including:

1. **String Validations**: These include `.required()`, `.length()`, `.min()`, `.max()`, `.email()`, `.url()`, `.matches()`, and `.defined()` among others. For instance, `.min()` sets a minimum length limit for the string value [Source 2](https://github.com/jquense/yup).

2. **Number Validations**: These include `.min()`, `.max()`, `.positive()`, `.negative()`, `.integer()`, and `.defined()`, etc. For instance, `.positive()` ensures the number is a positive value [Source 2](https://github.com/jquense/yup).

3. **Boolean Validations**: Yup provides `.required()`, `.defined()`, and `.oneOf()` for boolean validations [Source 2](https://github.com/jquense/yup).

4. **Date Validations**: These include `.min()`, `.max()`, `.required()`, and `.defined()` among others. For instance, `.min()` ensures the date is not earlier than the specified limit [Source 2](https://github.com/jquense/yup).

5. **Array Validations**: These include `.of()`, `.required()`, `.min()`, `.max()`, `.defined()`, and `.ensure()`. For instance, `.of()` allows you to specify the schema for the array elements [Source 2](https://github.com/jquense/yup).

6. **Object Validations**: These include `.shape()`, `.noUnknown()`, `.required()`, and `.defined()`. For instance, `.shape()` allows you to specify the schema for the properties of the object [Source 2](https://github.com/jquense/yup).

Yup also allows you to create custom validations using the `.test()` method. This method takes a name, an error message, and a validation function that returns `true` if the validation passes and `false` otherwise [Source 2](https://github.com/jquense/yup).

Yup also supports conditional validations using the `.when()` method. This allows you to change the validation schema based on the values of other fields. For example, you can make a field required only when another field has a certain value [Source 1](https://stackoverflow.com/questions/49394391/conditional-validation-in-yup).

In summary, Yup provides a wide range of validations out of the box and also gives you the flexibility to define your own custom validations. It's a versatile library for validating data in JavaScript applications.
















------------------------------------------------------------------------------------------------------------------------------------------------------------------------------




Yup is a powerful validation library for JavaScript that provides a variety of validation types, including:

**Basic Validations**

* `required`: Ensures the field is not empty.
* `type`: Checks the data type of the field.
* `min`: Validates that the value is greater than or equal to the specified minimum.
* `max`: Validates that the value is less than or equal to the specified maximum.
* `length`: Checks the length of the field value.
* `email`: Validates that the field value is a valid email address.
* `url`: Validates that the field value is a valid URL.

**Advanced Validations**

* `when`: Conditionally applies validation rules based on the value of another field.
* `oneOf`: Validates that the field value matches one of the specified values.
* `notOneOf`: Validates that the field value does not match any of the specified values.
* `matches`: Validates the field value against a regular expression.
* `test`: Allows you to define custom validation logic using a callback function.

**Schema-Based Validations**

Yup allows you to define complex schema-based validations for your forms. You can use Yup's schema builder to create nested objects and arrays, defining validation rules for each level of the schema. This approach ensures that your form data adheres to a predefined structure and constraints.

**Examples of Yup Validations**

Here are some examples of how to use Yup to validate form fields:

```javascript
yup.string().required().min(3) // Validates that the field is a non-empty string with a minimum length of 3 characters

yup.number().integer().min(18).max(100) // Validates that the field is an integer between 18 and 100

yup.array().min(2).max(5).of(yup.string().required()) // Validates that the field is an array of at least 2 but no more than 5 non-empty strings

yup.object({
  name: yup.string().required().min(3),
  email: yup.string().email().required(),
  age: yup.number().min(18).max(100),
}) // Validates a complex object with multiple fields and their respective validation rules
```

Yup's comprehensive validation capabilities make it a valuable tool for ensuring the integrity and consistency of user input in web applications.













  
