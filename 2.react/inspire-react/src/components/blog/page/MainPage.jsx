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

const WelcomeMessage = styled.div`
    font-size: 18px;
    font-weight: bold;
    margin-bottom: 16px;
    color: #333;
`;


const MainPage = () => {
  const moveUrl = useNavigate();
  const [contentAry, setContentAry] = useState([]);
  const [username, setUsername] = useState("");

  const getData = async () => {
    
    console.log("[TEST] >>> api base URL : ", api);
    console.log("[TEST] >>> access token : ", localStorage.getItem("accessToken"));
    
    const token = localStorage.getItem("accessToken");
    
    await api.get("/auth/api/v2/blog/blogs", {
      headers: {
        Authorization: token ? `${token}` : ""
      }
    })
      .then(response => {
        console.log("[db] >>> blog : ", response.data);
        setContentAry(response.data);
      })
      .catch(error => {
        console.log(error);
      })
  }

  useEffect(() => {
    getData();
    
    const user = localStorage.getItem("userInfo");
    if(user) {
      setUsername(user);
    }
    
  }, []);

  return (
    <Wrapper>
      <Container>
        {username && <WelcomeMessage>{username}님 환영합니다.</WelcomeMessage>}
        <Button title="글 작성하기" btnHandler={() => {
          moveUrl("/blog-write");
        }} />

        <BlogList blogs={contentAry} ></BlogList>
      </Container>
    </Wrapper>
  );
}

export default MainPage;