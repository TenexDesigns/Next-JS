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

  return { users, err, isLoading, setError, setUsers, setLoading };
};

export default UseUsers;
