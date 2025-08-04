import { useState } from "react";
import api from "../../api/axios.js";
import { useNavigate } from "react-router-dom";

const SiginInPage = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  const moveUrl = useNavigate();


  const emailHandler = (e) => {
    setEmail(e.target.value);
    console.log(e.target.value);
  }
  const passwordHandler = (e) => {
    setPassword(e.target.value);
    console.log(e.target.value);
  }
  const submitHandler = async (email, password) => {
    // const response = await api.get(`/users?email=${email}&password=${password}`);
    const response = await api.get(`/users`);
    console.log(response);

    await api.get("/todos")
      .then( response => {
        moveUrl('/todos/list', {
          state: response.data
        })
      })
      .catch(error => {
        console.log(error);
      })

    // if ( response.status === 201) {
    //   moveUrl("todos/list",
    //     {state: response.data}
    //   );
    // }

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

export default SiginInPage;