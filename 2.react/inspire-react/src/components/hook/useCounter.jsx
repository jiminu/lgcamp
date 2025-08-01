import { useState } from "react";

export default function useCounter() {
  const [cnt, setCnt] = useState(0);
  function upCntHandler() {
    setCnt((cnt) => cnt + 1);
  }
  function downCntHandler() {
    setCnt((cnt) => Math.max(cnt - 1), 0);
  }

  return [cnt, upCntHandler, downCntHandler];
}
