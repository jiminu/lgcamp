import React, { useState } from "react";
import styled from "styled-components";

// Container
const Container = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  background-color: #f2f2f2;
`;

// Form Box
const FormWrapper = styled.div`
  background-color: white;
  padding: 40px;
  border-radius: 10px;
  box-shadow: 0px 8px 16px rgba(0,0,0,0.1);
  width: 400px;
`;

// Title
const Title = styled.h2`
  text-align: center;
  margin-bottom: 20px;
  color: #333;
`;

// Input
const Input = styled.input`
  width: 100%;
  padding: 12px;
  margin-bottom: 15px;
  border-radius: 6px;
  border: 1px solid #ccc;
  font-size: 16px;

  &:focus {
    outline: none;
    border-color: #007bff;
    box-shadow: 0 0 5px rgba(0,123,255,0.3);
  }
`;

// Button
const Button = styled.button`
  width: 100%;
  padding: 12px;
  background-color: #007bff;
  color: white;
  border: none;
  font-size: 16px;
  border-radius: 6px;
  cursor: pointer;
  margin-top: 10px;

  &:hover {
    background-color: #0056b3;
  }

  &:disabled {
    background-color: #aaa;
    cursor: not-allowed;
  }
`;

// SignUp Component
const SignUpPage = () => {
  const [email, setEmail] = useState('');
  const [passwd, setPasswd] = useState('');
  const [confirmPasswd, setConfirmPasswd] = useState('');
  const [name, setName] = useState('');


  const handleChange = (e) => {

  };

  const handleSubmit = (e) => {
    e.preventDefault();
    if (passwd !== confirmPasswd) {
      alert("비밀번호가 일치하지 않습니다.");
      return;
    }
    // console.log("회원가입 정보:", form);
    // 여기서 API 호출 가능
  };

  return (
    <Container>
      <FormWrapper>
        <Title>회원가입</Title>
        <form onSubmit={handleSubmit}>

          <Input
            type="email"
            name="email"
            placeholder="이메일"
            value={email}
            onChange={handleChange}
            required
          />
          <Input
            type="password"
            name="passwd"
            placeholder="비밀번호"
            value={passwd}
            onChange={handleChange}
            required
          />
          <Input
            type="password"
            name="confirmPasswd"
            placeholder="비밀번호 확인"
            value={confirmPasswd}
            onChange={handleChange}
            required
          />
          <Input
            type="text"
            name="name"
            placeholder="이름"
            value={name}
            onChange={handleChange}
            required
          />
          <Button type="submit">가입하기</Button>
        </form>
      </FormWrapper>
    </Container>
  );
};

export default SignUpPage;