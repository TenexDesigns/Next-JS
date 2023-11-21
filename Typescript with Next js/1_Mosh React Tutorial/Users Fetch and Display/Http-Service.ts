// import createApiClient from './Api-client';

// const ApiClient = createApiClient('https://jsonplaceholder.typicode.com');


// interface Entity {
//     id:number
// }


// interface Entity {
//  id: number;
// }

// class HttpService<T extends Entity> {
//  endpoint: string;
 

//  constructor(endpoint: string) {
//    this.endpoint = endpoint;
//  }

//  getAll() {
//    const controller = new AbortController();
//    const request = ApiClient.get<T[]>(this.endpoint, {
//      signal: controller.signal,
//    });

//    return { request, cancel: () => controller.abort() };
//  }

//  delete(id: number) {
//    return ApiClient.delete(`${this.endpoint}/${id}`);
//  }

//  create(entity: T) {
//    return ApiClient.post(this.endpoint, entity);
//  }

//  update(entity: T) {
//    return ApiClient.patch(`${this.endpoint}/${entity.id}`, entity);
//  }
// }

// export default HttpService;


// import ApiClient from "./Api-client";

// interface Entity {
//  id: number;
// }

// class HttpService<T extends Entity> {
//  endpoint: string;
//  apiClient: typeof ApiClient;

//  constructor(endpoint: string, apiClient: typeof ApiClient) {
//   this.endpoint = endpoint;
//   this.apiClient = apiClient;
//  }

//  getAll() {
//   const controller = new AbortController();
//   const request = this.apiClient.get<T[]>(this.endpoint, {
//     signal: controller.signal,
//   });

//   return { request, cancel: () => controller.abort() };
//  }

//  delete(id: number) {
//   return this.apiClient.delete(`${this.endpoint}/${id}`);
//  }

//  create(entity: T) {
//   return this.apiClient.post(this.endpoint, entity);
//  }

//  update(entity: T) {
//   return this.apiClient.patch(`${this.endpoint}/${entity.id}`, entity);
//  }
// }

// export default HttpService;

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