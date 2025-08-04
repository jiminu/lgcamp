import { Link, useLocation } from "react-router-dom";


const TodoList = () => {
  const location = useLocation();
  const ary = location.state;
  console.log(ary);

  return (
    <div>
      <Link to="/">back in the day~ </Link>
      <hr />
      <ol>
        {
          ary.map((todo, idx) => {
            return <li key={idx}>{todo.content}</li>
          })
        }
      </ol>
    </div>
  )
}

export default TodoList;