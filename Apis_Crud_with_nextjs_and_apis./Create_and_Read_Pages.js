// components/CreateBook.js
import { Field, Form, Formik } from 'formik';
import axios from 'axios';
import { toast } from 'react-toastify';


const CreateBook = ({ onSuccess }) => {
  const initialValues = { title: '', author: '', pages: 0 };


  // ...
  
  const onSubmit = async (values, { resetForm }) => {
    try {
      const response = await axios.post('http://localhost:9002/books', values);
      resetForm();
      onSuccess(response.data); // Call the onSuccess function with the new book data.
      
      // Display a success toast notification
      toast.success('Book created successfully', { position: 'top-right' });
    } catch (error) {
      console.error('Error creating book:', error);
      // Handle the error and display an error message if needed
      toast.error('Error creating book', { position: 'top-right' });
    }
  };
  


  return (
    <div>
      <h2>Create Book</h2>
      <Formik initialValues={initialValues} onSubmit={onSubmit}>
        <Form>
          <div>
            <label>Title</label>
            <Field type="text" name="title" />
          </div>
          <div>
            <label>Author</label>
            <Field type="text" name="author" />
          </div>
          <div>
            <label>Pages</label>
            <Field type="number" name="pages" />
          </div>
          <button type="submit">Create</button>
        </Form>
      </Formik>
    </div>
  );
};

export default CreateBook;














---------------------------------------------------------------------------------------------------------------------------------------------------------------
// components/ReadBooks.js
import { useEffect, useState } from 'react';
import axios from 'axios';

const ReadBooks = () => {
  const [books, setBooks] = useState([]);

  useEffect(() => {
    const fetchBooks = async () => {
      try {
        const response = await axios.get('http://localhost:9002/books');
        setBooks(response.data);
      } catch (error) {
        console.error('Error fetching books:', error);
      }
    };

    fetchBooks();
  }, []);

  return (
    <div>
      <h2>Read Books</h2>
      <ul>
        {books.map((book) => (
          <li key={book.id}>
            Title: {book.title}, Author: {book.author}, Pages: {book.pages}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default ReadBooks;





----------------------------------------------------------------------------------------------------------------------------------------------------------


























