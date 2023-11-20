import React, { useEffect, useState } from "react";
import UserService, { User } from "./UserService";
import { CanceledError } from "axios";

const UseUsers = () => {
  const [users, setUsers] = useState<User[]>([]);
  const [err, setError] = useState("");
  const [isLoading, setLoading] = useState(false);

  useEffect(() => {

    setLoading(true);


    const { request, cancel } = UserService.getAll();
    request
      .then((res) => {
        setLoading(false);
        setUsers(res.data);
      })
      .catch((err) => {
        if (err instanceof CanceledError) return; // We exit the code excution of return
        setError(err.message);
        setLoading(false); // For showing the loader
      });

    return () => cancel(); // This is the clean u that is excuted when user leavs the page
  }, []);

  return { users, err, isLoading, setError,setUsers,setLoading };
};

export default UseUsers;







HERE IS WHERE WE CONSUME THE HOOK
----------------------------------------------------------------
  import UserService, { User } from "./Expense/components/UserService";
import UseUsers from "./Expense/components/UseUsers";

function Users() {
  const { users, err, isLoading, setError, setUsers, setLoading } = UseUsers();

  const deleteUser = (user: User) => {
    const originalUsrs = [...users];
    setUsers(users.filter((u) => u.id !== user.id));
    UserService.delete(user.id).catch((err) => {
      setError(err.message);
      setUsers(originalUsrs);
    });
  };
  const createUser = () => {
    const originalUsers = [...users];
    const newUser = { id: 0, name: "Mosh" };
    setUsers([newUser, ...users]);

    UserService.create(newUser)
      .then(({ data: savedUser }) => setUsers([savedUser, ...users]))
      .catch((err) => {
        setError(err.message);
        setUsers(originalUsers);
      });
    const updateUser = (user: User) => {
      const originalUsers = [...users];
      const updateUser = { ...user, name: user.name + "!" };
      //setUsers(user.map((u) => (u.id === user.id ? updateUser:)))

      UserService.update(updateUser).catch((err) => {
        setError(err.message);
        setUsers(originalUsers);
      });
    };
  };

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
  );
}

export default Users;



















Your custom hook for managing the state in the `Users` component looks good! It encapsulates the logic for fetching users, handling loading states, and managing errors. However, I noticed a couple of points that can be improved:

1. **Error Handling:** It's a good practice to provide more detailed error messages or log errors for debugging purposes. You might want to consider logging the actual error message or status code received from the server.

2. **Cleaning Up Effect:** It seems like you're using the `cancel` function returned from the `UserService.getAll()` to abort the request when the component unmounts. Make sure that the `UserService.getAll()` method properly handles cancellations using the `AbortController`. If not, you might want to add explicit cleanup for the `AbortController` in the `UseUsers` hook.

Here's an updated version of your hook considering these points:

```javascript
import React, { useEffect, useState } from "react";
import UserService, { User } from "./UserService";
import { CanceledError } from "axios";

const useUsers = () => {
  const [users, setUsers] = useState<User[]>([]);
  const [err, setError] = useState<string | null>(null); // Using string type for error
  const [isLoading, setLoading] = useState<boolean>(false);

  useEffect(() => {
    const fetchData = async () => {
      setLoading(true);

      try {
        const { request, cancel } = UserService.getAll();
        const res = await request;
        setUsers(res.data);
      } catch (error) {
        if (error instanceof CanceledError) return;
        setError(error.message || "An error occurred");
      } finally {
        setLoading(false);
      }
    };

    fetchData();

    return () => {
      // Cleanup code if necessary (e.g., aborting requests or resetting state)
    };
  }, []);

  return { users, err, isLoading, setError, setUsers, setLoading };
};

export default useUsers;
```

In this version:
- I've changed the `err` state to be `string | null` to make it more explicit that it can hold an error message or be `null`.
- Added a more generic error message in case the server doesn't provide a specific error message.
- The cleanup function in the `useEffect` hook can be expanded based on your specific requirements, such as aborting requests or resetting state when the component unmounts.

Remember to adjust the cleanup code based on your specific use case and requirements.













