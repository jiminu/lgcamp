const LoginButton = (props) => {
  const loginHandler = (setIsFlag) => {
    console.log("login handler");
    setIsFlag((isFlag) => (isFlag = true));
  };

  return (
    <button type="button" onClick={() => loginHandler(props.login)}>
      login
    </button>
  );
};

export default LoginButton;
