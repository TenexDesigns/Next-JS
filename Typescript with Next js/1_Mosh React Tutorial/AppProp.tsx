"use client";
import React, { ReactNode } from "react";

interface text {
  children: ReactNode;
}

const AppProp = (props: text) => {
  return (
    <>
      <h1> {props.children}</h1>
    </>
  );
};

export default AppProp;
