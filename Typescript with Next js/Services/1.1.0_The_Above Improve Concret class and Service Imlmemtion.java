THE REUSABLE  API CLIENT

import axios, { CanceledError } from 'axios';

export default function createApiClient(baseURL: string) {
 return axios.create({
   baseURL,
 });
}

export { CanceledError };













THE REUSABLE GENRC HTTP SERVICE CLASS
-----------------------------------------------------------------------------------------
import createApiClient from './Api-client';

const ApiClient = createApiClient('https://jsonplaceholder.typicode.com');


interface Entity {
    id:number
}


interface Entity {
 id: number;
}

class HttpService<T extends Entity> {
 endpoint: string;

 constructor(endpoint: string) {
   this.endpoint = endpoint;
 }

 getAll() {
   const controller = new AbortController();
   const request = ApiClient.get<T[]>(this.endpoint, {
     signal: controller.signal,
   });

   return { request, cancel: () => controller.abort() };
 }

 delete(id: number) {
   return ApiClient.delete(`${this.endpoint}/${id}`);
 }

 create(entity: T) {
   return ApiClient.post(this.endpoint, entity);
 }

 update(entity: T) {
   return ApiClient.patch(`${this.endpoint}/${entity.id}`, entity);
                            }}



export default HttpService;








THE USER SERVICE
-------------------------------------------------------------------

  

import HttpService from "./Http-Service";

export interface User {
 id: number;
 name: string;
}

export default new HttpService<User>('/users');








THE USER UI
-------------------------------------------------
  

  import React, { useEffect, useState } from "react";
import { CanceledError } from "./Expense/components/Api-client";
import UserService, { User } from "./Expense/components/UserService";

function Users() {
  const [users, setUsers] = useState<User[]>([]);
  const [err, setError] = useState("");
  const [isLoading, setLoading] = useState(false);

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
    // const controller = new AbortController();

    setLoading(true);

    // ApiClient
    //   .get<User[]>("https://jsonplaceholder.typicode.com/users", {
    //     signal: controller.signal, // Part of clean up code
    //   })
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






                             





















                             
 }
}

export default HttpService;
