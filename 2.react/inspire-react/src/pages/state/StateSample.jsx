import { useState, useEffect, use } from "react";
import useCounter from "../../components/hook/useCounter";

const StateSample = () => {
  const CAPACITY = 10;

  const [cnt, upCntHandler, downCntHandler] = useCounter();
  const [isFull, setIsFull] = useState(false);
  const [isEmpty, setIsEmpty] = useState(true);

  useEffect(() => {
    console.log("CNT COUNT = ", cnt);
    setIsFull(cnt >= CAPACITY);
    setIsEmpty(cnt === 0);
  }, [cnt]);

  return (
    <div>
      <p>entered member : {cnt} </p>
      <button type="button" onClick={upCntHandler} disabled={isFull}>
        enter
      </button>
      <button type="button" onClick={downCntHandler} disabled={isEmpty}>
        exit
      </button>

      {isFull && <p style={{ color: "red" }}>member is full.</p>}
    </div>
  );
};

// const StateSample = () => {
//   const CAPACITY = 10;
//   const [cnt, setCnt] = useState(0);
//   const [isFull, setIsFull] = useState(false);
//   const [isEmpty, setIsEmpty] = useState(true);

//   const cntUpHandler = () => {
//     setCnt((cnt) => cnt + 1);
//   };
//   const cntDownHandler = () => {
//     setCnt((cnt) => cnt - 1);
//   };

//   useEffect(() => {
//     console.log("CNT COUNT = ", cnt);
//     setIsFull(cnt >= CAPACITY);
//     setIsEmpty(cnt === 0);
//   }, [cnt]);
//   return (
//     <div>
//       <p>entered member : {cnt} </p>
//       <button type="button" onClick={cntUpHandler} disabled={isFull}>
//         enter
//       </button>
//       <button type="button" onClick={cntDownHandler} disabled={isEmpty}>
//         exit
//       </button>

//       {isFull && <p style={{ color: "red" }}>member is full.</p>}
//     </div>
//   );
// };

export default StateSample;
