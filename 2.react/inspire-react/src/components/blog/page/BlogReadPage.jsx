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
  const [comment, setComment] = useState("");
  const [comments, setComments] = useState([]);
  // const id = blogId;
  const moveUrl = useNavigate();
  
  const getBlog = async () => {
    // await api.get(`/blogs/${blogId}`, {
    // await api.get(`/blogs?_embed=comments`, {
    // await api.get(`/api/v1/blog/readById/`, {
    //   params: {
    //     id: blogId
    //   }
    // })
    
    const token = localStorage.getItem("accessToken");
    console.log("[BLOG GET TOKEN TEST] : ", token);
    console.log("[BLOG GET BLOGID] : ", blogId);
    
    await api.get(`/auth/api/v2/blog/read/${blogId}`, {
      headers: {
        Authorization: token ? `${token}` : ""
      }
    })
      .then(response => {
        console.log("[DEBUG] response : ", response);
        console.log("[DEBUG] comments : ", response.data.comments);
        setBlog(response.data);
        // setBlog({
        //   blogId: response.data.blogId,
        //   title: response.data.title,
        //   content: response.data.content
        // });
        setComments(response.data.comments || []);
      })
      .catch(error => {
        console.log(error);
      })
  };
                     

                        
  const commentHandler = async (blogId, comment) => {
    const token = localStorage.getItem("accessToken");
    const data = {
      blogId,
      comment
    }
    console.log("data : " , data);
    
    await api.post(`/auth/api/v2/blog/comment/register`, data, {
      headers: {
        Authorization: token ? `${token}` : ""
      }
    })
      .then(response => {
        console.log(response.data);
        console.log("comments : ", response);
        const newComment = response.data[response.data.length-1];
        console.log("newComment : " , newComment);
        setComments((ary) => {
          return [...ary, newComment];
        })
        setComment("");
        // getBlog();
      })
      .catch(error => {
        console.log(error);
      })
  };
  
  const commentDelete = async (blogId, commentId) => {
    const token = localStorage.getItem("accessToken");

    console.log(">>>>>>>> comment delete function blog id", blogId);
    console.log(">>>>>>>> comment delete function comment id", commentId);
    
    await api.delete(`auth/api/v2/blog/comment/delete/${blogId}/${commentId}`, {
      headers: {
        Authorization: token ? `${token}` : ""
      }
    })
    .then( response => {
      if (response.status === 204) {
        setComments((ary) => {
          return ary.filter((c) => c.commentId !== commentId);
        })
        setComment('');
      }
    })
    .catch( error => {
      console.log("[db] >>>>> " , error)
    })
  }

  useEffect(() => {
    getBlog();
  }, []);

  return (
    <Wrapper>
      { !blog.blogId && <Spinner />}
      {blog.blogId &&
        <Container>
          <Button title="메인페이지로" btnHandler={() => {
            moveUrl("/");
          }}></Button>

          <PostContainer>
            <TitleText>{blog.title}</TitleText>
            <ContentText>{blog.content}</ContentText>
          </PostContainer>


          <CommentLabel>댓글</CommentLabel>

          <BlogCommentList comments={comments || []}
                           commentDeleteHandler={commentDelete}></BlogCommentList>

          
          <TextArea height={40} value={comment} changeHandler={(e) => {
            setComment(e.target.value);
          }}></TextArea>
          
          <Button title="댓글 작성" btnHandler={() => commentHandler(blog.blogId, comment)}></Button>


        </Container>
      }
    </Wrapper>
  );

}

export default BlogReadPage;