import { useContext } from "react";
import ctx from "./utill/contextMode";

const ContextHeader = () => {
  const { isMode } = useContext(ctx);

  return (
    <div>
      <header style={{
        backgroundColor: isMode ? "red" : "black",
        color: isMode ? "black" : "red",
      }}>
        <h1>happy lg...</h1>
      </header>
    </div>
  );
}

export default ContextHeader;