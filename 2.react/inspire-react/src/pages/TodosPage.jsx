import { use, useState } from "react";

export default function TodosPage() {
  // let txt = "";

  const [txt, setTxt] = useState("");

  const btnHandler = (msg) => {
    console.log(msg);
  };
  const txtHandler = (e) => {
    setTxt(e.target.value);
  };

  return (
    <div class="container">
      <h2>to-do list</h2>
      <form class="d-flex">
        <div class="flex-grow-1 me-2">
          <input
            class="form-control"
            type="text"
            value={txt}
            placeholder="enter a todo"
            onChange={txtHandler}
          />
        </div>
        <div>
          <button
            type="button"
            class="btn btn-primary"
            onClick={() => btnHandler(txt)}
          >
            add
          </button>
        </div>
      </form>
      data output
    </div>
  );
}

// const TodosPage = () => {
//   return (
//     <div class="container">
//       <h2>to-do list</h2>
//       <form class="d-flex">
//         <div class="flex-grow-1 me-2">
//           <input type="text" />
//         </div>
//         <div>
//           <button type="submit" class="btn btn-primary">
//             add
//           </button>
//         </div>
//       </form>
//       data output
//     </div>
//   );
// };

// export default TodosPage;
