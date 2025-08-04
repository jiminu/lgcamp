import logo from './logo.svg';
import './App.css';
import { BrowserRouter, Routes, Route } from "react-router-dom";
import SignUpPage from './components/form/SignUpPage';
import SignInPage from './components/form/SignInPage';
import TodoList from './components/form/TodoList';


function App() {
  return (
    <div >
      <BrowserRouter>
        <h2>페이지 이동을 위한 라우터</h2>
        <Routes>
          <Route path = "/" element          = {<SignUpPage/>}></Route>
          <Route path = "/loginForm" element = {<SignInPage/>}></Route>
          <Route path = "/todos/list" element = {<TodoList/>}></Route>
        </Routes>
      </BrowserRouter>
    </div>
  );
};

export default App;
