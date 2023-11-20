
the api client

  import axios ,{CanceledError}from 'axios'


export default axios.create({
    baseURL:'https://jsonplaceholder.typicode.com' //Base url, where we can access the crud operations from
})


export {CanceledError}



the http serveice
----------------------------------

  import ApiClient from "./Api-client";


interface Entity {
    id:number
}


class HttpService {

    enpoint: string

    constructor ( endpoint: string){
        this.enpoint = endpoint
    }
    getAll<T>(){
        const controller = new AbortController();
       const request =   ApiClient
        .get<T[]>(this.enpoint, {
          signal: controller.signal, // Part of clean up code
        })


        return {request, cancel: ()=> controller.abort()}
        

    }

    delete(id:number){

       return  ApiClient.delete(this.enpoint+"/"+id)

    }

    create<T>(entity:T){
       return  ApiClient.post(this.enpoint,entity)


    }

    updateUser<T extends Entity>(entity:T){

      return  ApiClient.patch(this.enpoint+ "/" +entity.id , entity)

    }

    
}

const create = (endpoint: string)  => new HttpService(endpoint);

export default create;





USER SERVICE
----------------------------------


  import create from "./Http-Service";


export  interface User {
    id: number;
    name: string;
  }
export default create('/users')



USING THE USER SERVICE
--------------------------------------

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
    const { request, cancel } = UserService.getAll<User>();
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












  
