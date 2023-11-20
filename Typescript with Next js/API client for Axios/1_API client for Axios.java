In the provided code, the ApiClient class is used to encapsulate reusable calls to the backend server. This helps to avoid repeating similar code for making API requests and provides a centralized location for managing API-related functionalities. Here's a breakdown of how the ApiClient is used:



import axios ,{CanceledError}from 'axios'


export default axios.create({
    baseURL:'https://jsonplaceholder.typicode.com' //Base url, where we can access the crud operations from
})


export {CanceledError}



  ----------  ----------  ----------  ----------  ----------  ----------  ----------  ----------  ----------  ----------  ----------  ----------  ----------


  
  import React, { useEffect, useState } from "react";
import ApiClient, { CanceledError } from "./Expense/components/Api-client";

interface User {
  id: number;
  name: string;
}

function Users() {
  const [users, setUsers] = useState<User[]>([]);
  const [err, setError] = useState("");
  const [isLoading, setLoading] = useState(false);
  const deleteUser = (user: User) => {
    const originalUsrs = [...users];
    setUsers(users.filter((u) => u.id !== user.id));
    ApiClient.delete("/users" + user.id).catch((err) => {
      setError(err.message);
      setUsers(originalUsrs);
    });
  };
  useEffect(() => {
    //Fetch data using async await
    // const fetchData = async () => {
    //   try {
    //     const res = await axios.get<User[]>(
    //       "https://jsonplaceholder.typicode.com/sers"
    //     );
    //     setUsers(res.data);
    //   } catch (error) {
    //     setError((error as AxiosError).message);
    //   }
    // };
    // fetchData();

    //Clean up
    const controller = new AbortController();
    setLoading(true);

    //Get Request
    ApiClient.get<User[]>("/users", {
      signal: controller.signal, // Part of clean up code
    })
      .then((res) => {
        setLoading(false);
        setUsers(res.data);
      })
      .catch((err) => {
        if (err instanceof CanceledError) return; // We exit the code excution of return
        setError(err.message);
        setLoading(false); // For showing the loader
      });

    return () => controller.abort(); // T
  }, []);

  return (
    <>
      {err && <p>{err}</p>}
      {isLoading && <div className="spiner-boader"></div>}
      {users.map((user) => (
        <li key={user.id}>
          {user.name}

          <button
            className="btn btn-outline-danger"
            onClick={() => deleteUser(user)}
          >
            Delete
          </button>
        </li>
      ))}
    </>




  ----------  ----------  ----------  ----------  ----------  ----------  ----------  ----------  ----------  ----------  ----------

In the provided code, the ApiClient class is used to encapsulate reusable calls to the backend server. This helps to avoid repeating similar code for making API requests and provides a centralized location for managing API-related functionalities. Here's a breakdown of how the ApiClient is used:

1. **Importing and Creating an Instance:**

```javascript
import ApiClient, { CanceledError } from "./Expense/components/Api-client";
```

This line imports the ApiClient class and the CanceledError type from the Api-client module. Then, an instance of the ApiClient class is created.

2. **Defining Base URL:**

```javascript
export default axios.create({
  baseURL: "https://jsonplaceholder.typicode.com", // Base url, where we can access the crud operations from
});
```

This code defines the base URL for all API requests made using the ApiClient instance. This eliminates the need to repeatedly specify the base URL in each API call.

3. **Encapsulating API Calls:**

```javascript
ApiClient.get<User[]>("/users").catch((err) => {
  setError(err.message);
  setUsers(originalUsrs);
});
```

This code demonstrates how to make a GET request using the ApiClient instance. The "/users" endpoint is specified, and the response data is expected to be an array of User objects. The catch block handles any errors that occur during the request.

4. **Error Handling with CanceledError:**

```javascript
if (err instanceof CanceledError) return; // We exit the code excution of return
setError(err.message);
```

This code checks if the error is an instance of CanceledError, which indicates that the request was canceled due to user navigation or other reasons. If so, the error handling code is skipped. Otherwise, the error message is set.

5. **Cleaning Up:**

```javascript
return () => controller.abort();
```

This code defines a cleanup function that is executed when the component is unmounted. It calls the abort() method on the AbortController instance, which cancels any pending API requests.

By encapsulating API calls using the ApiClient class, the code becomes more maintainable and reusable, reducing duplication and simplifying API interactions.


























            
  );
} //his is the clean u that is excuted when user leavs the page

export default Users;
