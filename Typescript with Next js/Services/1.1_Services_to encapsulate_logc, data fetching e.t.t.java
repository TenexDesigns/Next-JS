The Api Cleint

import axios ,{CanceledError}from 'axios'


export default axios.create({
    baseURL:'https://jsonplaceholder.typicode.com' //Base url, where we can access the crud operations from
})


export {CanceledError}





THE USER SERVICE

import ApiClient from "./Api-client";


export  interface User {
    id: number;
    name: string;
  }


class UserService {
    getAllUsers(){
        const controller = new AbortController();
       const request =   ApiClient
        .get<User[]>("/users", {
          signal: controller.signal, // Part of clean up code
        })


        return {request, cancel: ()=> controller.abort()}
        

    }

    deleteUser(id:number){

       return  ApiClient.delete("/users/"+id)

    }

    createUser(user:User){
       return  ApiClient.post("/users",user)


    }

    updateUser(user:User){

      return  ApiClient.patch("/users/"+ user.id , user)

    }

    
}

export default new  UserService()







PERFORM CRUD WITH THE USER SERVICE AND HANDLE ERRORS 


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
    UserService.deleteUser(user.id).catch((err) => {
      setError(err.message);
      setUsers(originalUsrs);
    });
  };
  const createUser = () => {
    const originalUsers = [...users];
    const newUser = { id: 0, name: "Mosh" };
    setUsers([newUser, ...users]);

    UserService.createUser(newUser)
      .then(({ data: savedUser }) => setUsers([savedUser, ...users]))
      .catch((err) => {
        setError(err.message);
        setUsers(originalUsers);
      });
    const updateUser = (user: User) => {
      const originalUsers = [...users];
      const updateUser = { ...user, name: user.name + "!" };
      //setUsers(user.map((u) => (u.id === user.id ? updateUser:)))

      UserService.updateUser(updateUser).catch((err) => {
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
    const { request, cancel } = UserService.getAllUsers();
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

















