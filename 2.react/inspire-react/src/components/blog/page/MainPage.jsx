import { useNavigate } from "react-router-dom";
import styled from "styled-components";
import Button from "../ui/Button";
import api from "../../../api/axios";
import BlogList from "../list/BlogList";
import { useEffect, useState } from "react";

const Wrapper = styled.div`
padding        : 16px;
width          : calc(100% - 32px);
display        : flex;
flex-direction : column;
align-items    : center;
justify-content: center;
`;

const Container = styled.div`
width    : 100%;
max-width: 720px;

& > * {
:not(:last-child) {
margin-bottom: 16px;
}
}
`;


const MainPage = () => {
  const moveUrl = useNavigate();
  const [contentAry, setContentAry] = useState([]);


  const getData = async () => {
    await api.get("/blogs")
      .then(response => {
        setContentAry(response.data);
      })
      .catch(error => {
        console.log(error);
      })
  }

  useEffect(() => {
    getData();
  }, []);

  return (
    <Wrapper>
      <Container>

        <Button title="글 작성하기" btnHandler={() => {
          moveUrl("/blog-write");
        }} />

        <BlogList blogs={contentAry} ></BlogList>
      </Container>
    </Wrapper>
  );
}

export default MainPage;