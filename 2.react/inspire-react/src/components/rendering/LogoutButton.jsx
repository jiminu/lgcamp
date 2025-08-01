const LogoutButton = (props) => {
  const logoutHandler = (setIsFlag) => {
    console.log("login handler");
    setIsFlag((isFlag) => (isFlag = false));
  };
  return (
    <button type="button" onClick={() => logoutHandler(props.login)}>
      logout
    </button>
  );
};

export default LogoutButton;
