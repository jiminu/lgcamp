import { useState } from "react";
import api from "../../api/axios.js";
import { useNavigate } from "react-router-dom";

const SignUpPage = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  const moveUrl = useNavigate()

  const emailHandler = (e) => {
    setEmail(e.target.value);
    console.log(e.target.value);
  }
  const submitHandler = async (email, password) => {

    /*
    post: 입력
    get : 데이터 읽기

    //  204 : 요청 성공, 서버로부터 전달되는 컨텐츠는 없을 때
    put   : 데이터 수정(리소스 전체를 수정하거나 새로 생성)
    delete: 데이터 삭제
    patch : 데이터 일부 수정
    */
    
    const data = {
      email,
      password,
      
    };

    try {
      const response = await api.post("users", data);
      // console.log(response);
      if (response.status === 201) {
        moveUrl("/loginForm");
      }

    } catch (error) {

    } finally {

    }
  }

  return (
    <div>
      <form action="">
        <label htmlFor="">
          이메일 :
          <input type="text"
                 placeholder="email@email.com"
                 value={email}
                 onChange={(e) => {
                  setEmail(e.target.value);
                  console.log(e.target.value);
                }} /> <br />
          비밀번호 :
          <input type="password"
                 placeholder="password" 
                 value={password}
                 onChange={(e) => {
                   setPassword(e.target.value);
                   console.log(e.target.value);
                 }} /><br />
          
        </label> <br />
        <button type="button"
                onClick={() => submitHandler(email, password)}>로그인</button>
      </form>
    </div>
  );
}

export default SignUpPage;