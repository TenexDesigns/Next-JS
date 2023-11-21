import React, { FormEvent, useRef, useState } from "react";

function Form() {
  const [person1, setPerson] = useState({
    name: "",
    age: "",
  });
  const person = { name: "", age: 0 };
  const nameRef = useRef<HTMLInputElement>(null);
  const ageRef = useRef<HTMLInputElement>(null);
  const handleSubmit = (event: FormEvent) => {
    event.preventDefault();
    if (nameRef.current !== null) {
      person.name = nameRef.current.value;
      console.log(nameRef.current.value);
    }
    if (ageRef.current !== null) {
      person.name = ageRef.current.value;

      console.log(ageRef.current.value);
    }
    console.log(person);
  };
  return (
    <>
      <form onSubmit={handleSubmit}>
        <div className="mb-3">
          <label htmlFor="name" className="form-label">
            Name
          </label>
          <input
            ref={nameRef}
            id="name"
            type="text"
            className="form-control"
            onChange={(event) =>
              setPerson({ ...person1, name: event.target.value })
            }
            value={person1.name}
          />
        </div>

        <div className="mb-3">
          <label htmlFor="age" className="form-label">
            Age
          </label>
          <input
            onChange={(event) =>
              setPerson({ ...person1, age: event.target.value })
            }
            value={person1.age}
            id="age"
            type="number"
            className="form-control"
          />
        </div>

        <button type="submit" className="btn btn-primary">
          Submit
        </button>
      </form>
    </>
  );
}

export default Form;
