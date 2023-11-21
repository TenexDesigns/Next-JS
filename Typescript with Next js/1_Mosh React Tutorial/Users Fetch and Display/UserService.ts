// import create from "./Http-Service";


// export  interface User {
//     id: number;
//     name: string;
//   }
// export default create('/users')





// import HttpService from "./Http-Service";

// export interface User {
//  id: number;
//  name: string;
// }

// export default new HttpService<User>('/users');


// import HttpService from "./Http-Service";
// import createApiClient from "./Api-client";

// const ApiClient = createApiClient('https://jsonplaceholder.typicode.com');


// export interface User {
//  id: number;
//  name: string;
// }

// export default new HttpService<User>('/users', ApiClient);


// import HttpService from "./Http-Service";
// import createApiClient from "./Api-client";

// const ApiClient = createApiClient("https://jsonplaceholder.typicode.com");

// export interface User {
//   id: number;
//   name: string;
// }

// const UserService = new HttpService<User>("/users", ApiClient);

// export default UserService;
import HttpService from "./Http-Service";

export interface User {
 id: number;
 name: string;
}

export default new HttpService<User>('/users');













// class UserService {
//     getAllUsers(){
//         const controller = new AbortController();
//        const request =   ApiClient
//         .get<User[]>("/users", {
//           signal: controller.signal, // Part of clean up code
//         })


//         return {request, cancel: ()=> controller.abort()}
        

//     }

//     deleteUser(id:number){

//        return  ApiClient.delete("/users/"+id)

//     }

//     createUser(user:User){
//        return  ApiClient.post("/users",user)


//     }

//     updateUser(user:User){

//       return  ApiClient.patch("/users/"+ user.id , user)

//     }

    
// }

// export default new  UserService()
