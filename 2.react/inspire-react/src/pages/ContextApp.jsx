import { useState } from "react";
import ContextPage from "./context/ContextPage";
import ctx from "../components/context/utill/contextMode";

const ContextApp = () => {
  const [isMode, setIsMode] = useState(false);

  return (
    <div>
      <ctx.Provider value={{isMode, setIsMode}}>
        <ContextPage />
      </ctx.Provider>
    </div>
  )
  
}


export default ContextApp;