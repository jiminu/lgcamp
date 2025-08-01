import { useState } from "react";
import Greeting from "../../components/rendering/Greeting";
import LoginButton from "../../components/rendering/LoginButton";
import LogoutButton from "../../components/rendering/LogoutButton";

const UserPage = () => {
  const [isFlag, setIsFlag] = useState(false);
  return (
    <div>
      <Greeting isFlag={isFlag} />
      {isFlag ? (
        <LogoutButton login={setIsFlag} />
      ) : (
        <LoginButton login={setIsFlag} />
      )}
    </div>
  );
};

export default UserPage;
