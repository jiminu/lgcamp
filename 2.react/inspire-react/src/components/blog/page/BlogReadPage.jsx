import { useNavigate, useParams } from "react-router-dom";
import styled, {keyframes} from "styled-components";
import Button from "../ui/Button";
import { useEffect, useState } from "react";
import api from "../../../api/axios";
import TextArea from "../ui/TextArea";
import BlogCommentList from "../list/BlogCommentList";

const Wrapper = styled.div`
padding: 16px;
width: calc(100% - 32px);
display: flex;
flex-direction: column;
align-items: center;
justify-content: center;
`;

const Container = styled.div`
width: 100%;
max-width: 720px;

& > * {
:not(:last-child) {
margin-bottom: 16px;
}
}
`;

const PostContainer = styled.div`
padding: 8px 16px;
border: 1px solid grey;
border-radius: 8px;
`;

const TitleText = styled.p`
font-size: 28px;
font-weight: 500;
`;

const ContentText = styled.p`
font-size: 20px;
line-height: 32px;
white-space: pre-wrap;
`;

const CommentLabel = styled.p`
font-size: 16px;
font-weight: 500;
`;

const spin = keyframes`
0% { transform: rotate(0deg); }
100% { transform: rotate(360deg); }
`;

const Spinner = styled.div`
border: 6px solid #f3f3f3;
border-top: 6px solid #3498db;
border-radius: 50%;
width: 48px;
height: 48px;
animation: ${spin} 1s linear infinite;
margin: 100px auto;
`;

const BlogReadPage = () => {
  const { blogId } = useParams();
  const [blog, setBlog] = useState({});

  const moveUrl = useNavigate();
  const getBlog = async () => {
    // await api.get(`/blogs/${blogId}`, {
    await api.get(`/blogs`, {
      params: {
        id: blogId
      }
    })
      .then(response => {
        console.log(response.data[0]);
        setBlog(response.data[0]);
      })
      .catch(error => {
        console.log(error);
      })
  };
  useEffect(() => {
    getBlog();
  }, []);

  console.log(blogId);

  return (
    <Wrapper>
      { !blog.id && <Spinner />}
      {blog.id &&
        <Container>
          <Button title="메인페이지로" btnHandler={() => {
            moveUrl("/");
          }}></Button>

          <PostContainer>
            <TitleText>{blog.title}</TitleText>
            <ContentText>{blog.content}</ContentText>
          </PostContainer>


          <CommentLabel>댓글</CommentLabel>

          <BlogCommentList comments={blog.comments}></BlogCommentList>
          <TextArea height={40}></TextArea>
          <Button title="댓글 작성"></Button>


        </Container>
      }
    </Wrapper>
  );

}

export default BlogReadPage;