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

































