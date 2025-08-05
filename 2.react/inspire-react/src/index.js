import React from "react";
import ReactDOM from "react-dom/client";
import "./index.css";
import reportWebVitals from "./reportWebVitals";

// import SignUpPage from "./components/form/SignUpPage";
// const root = ReactDOM.createRoot(document.getElementById("root"));
// root.render(
//     <SignUpPage />
// );

// import NotificationPage from "./pages/hook/NotificationPage";
// const root = ReactDOM.createRoot(document.getElementById("root"));
// root.render(<NotificationPage />);

// import StateSample from "./pages/state/StateSample";
// const root = ReactDOM.createRoot(document.getElementById("root"));
// root.render(
//   <React.StrictMode>
//     <StateSample />
//   </React.StrictMode>
// );

// import UserPage from "./pages/rendering/UserPage";
// const root = ReactDOM.createRoot(document.getElementById("root"));
// root.render(
//   <React.StrictMode>
//     <UserPage />
//   </React.StrictMode>
// );

// import TodosPage from "./pages/TodosPage";
// const root = ReactDOM.createRoot(document.getElementById("root"));
// root.render(
//   <React.StrictMode>
//     <TodosPage />
//   </React.StrictMode>
// );

// const root = ReactDOM.createRoot(document.getElementById("root"));
// root.render(
//   <React.StrictMode>
//     <CommentPage />
//   </React.StrictMode>
// );

// const root = ReactDOM.createRoot(document.getElementById('root'));
// root.render(
//   <React.StrictMode>
//     <LibraryPage />
//   </React.StrictMode>
// );

// import App from "./App.js";
// const root = ReactDOM.createRoot(document.getElementById('root'));
// root.render(
//     <App />
// );

import BlogApp from "./BlogApp.js";
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    <BlogApp />
);

// import ContextApp from "./pages/ContextApp";
// const root = ReactDOM.createRoot(document.getElementById('root'));
// root.render(
//     <ContextApp />
// );

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
