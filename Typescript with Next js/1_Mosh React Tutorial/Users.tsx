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
