import React from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import styled from "styled-components";
import MainPage from "./components/blog/page/MainPage";
import BlogWritePage from "./components/blog/page/BlogWritePage";
import BlogReadPage from "./components/blog/page/BlogReadPage";

const DivTitleText = styled.p`
  font-size: 24px;
  font-weight: bold;
  text-align : center;
`;

const BlogApp = () => {
  return (
    <BrowserRouter>
      <DivTitleText>
        AM Inspire Camp 3th
      </DivTitleText>
      <Routes>
        <Route path="/" element={ <MainPage /> }></Route>
        <Route path="/blog-write" element={ <BlogWritePage /> }></Route>
        <Route path="/blog-read/:blogId" element={ <BlogReadPage /> }></Route>
      </Routes>
    </BrowserRouter>
  );
}

export default BlogApp;