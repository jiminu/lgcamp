import { useContext } from "react";
import ctx from "./utill/contextMode";


const ContextFooter = () => {
  const { isMode, setIsMode } = useContext(ctx);

  const modeHandler = () => {
    setIsMode(!isMode);
  }

  return (
    <div>
      <footer style={{
        backgroundColor: isMode ? "red" : "black"
      }}>
        <button type="button" onClick={modeHandler}>
          모드 변경
        </button>
      </footer>
    </div>
  )
}


export default ContextFooter