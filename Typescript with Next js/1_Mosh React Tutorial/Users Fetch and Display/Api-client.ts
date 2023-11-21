// import axios ,{CanceledError}from 'axios'


// export default axios.create({
//     baseURL:'https://jsonplaceholder.typicode.com' //Base url, where we can access the crud operations from
// })


// export {CanceledError}

import axios, { CanceledError } from 'axios';

export default function createApiClient(baseURL: string) {
 return axios.create({
   baseURL,
 });
}

export { CanceledError };

