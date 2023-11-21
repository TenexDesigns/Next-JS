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
  );
} //his is the clean u that is excuted when user leavs the page

export default Users;
