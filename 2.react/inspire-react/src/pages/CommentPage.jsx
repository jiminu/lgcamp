import CommentComponent from "../components/CommentComponent";

const comments = [
  {
    name: "imm",
    comment: "react good~",
  },
  {
    name: "ji",
    comment: "html good~",
  },
  {
    name: "ggya",
    comment: "css good~",
  },
];

function CommentPage() {
  return (
    <div>
      {comments.map((comment) => {
        return <CommentComponent data={comment} />;
      })}
    </div>
  );
}

export default CommentPage;
