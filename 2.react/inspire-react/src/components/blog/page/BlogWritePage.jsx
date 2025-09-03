import { useNavigate } from "react-router-dom";
import styled from "styled-components";
import Button from "../ui/Button";
import TextArea from "../ui/TextArea";
import { useState } from "react";
import api from "../../../api/axios";

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

const BlogWritePage = () => {
  const [title, setTitle] = useState("");
  const [content, setContent] = useState("");

  const moveUrl = useNavigate();

  const saveHandler = async (title, content) => {
    const data = {
      title,
      content
    }
    try {
      const response = await api.post("/api/v1/blog/register", data);
      // console.log(response);
      if (response.status === 201) {
        moveUrl("/");
      }

    } catch (error) {

    } finally {

    }
  }

  return (
    <Wrapper>
      <Container>
        <TextArea value={title}
                  changeHandler={(e) => {
                    setTitle(e.target.value);
                  }}
                  height={20}
                  placeholder={"제목"}>
          
        </TextArea>
        <TextArea value={content}
                  changeHandler={(e) => {
                    setContent(e.target.value)
                  }}
                  height={480}
                  placeholder={"본문"}>

        </TextArea>
        <Button title="저장하기"
                btnHandler={() => {
                  saveHandler(title, content);
                }}/>
      </Container>
    </Wrapper>
  );
}

export default BlogWritePage;