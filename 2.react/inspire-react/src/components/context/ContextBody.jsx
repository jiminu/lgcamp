import { useContext } from "react";
import ctx from "./utill/contextMode";


const ContextBody = () => {
  const { isMode } = useContext(ctx);

  return (
    <div style={{
        backgroundColor: isMode ? "red" : "black",
        color: isMode ? "black" : "red",
      }}>
        <h1>holy galy body</h1>
    </div>
  );
}

export default ContextBody;