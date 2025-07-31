import Book from "../components/BookComponent";

const books = [
  { name: "A", price: "10000" },
  { name: "B", price: "10001" },
  { name: "C", price: "10002" },
  { name: "D", price: "10003" },
  { name: "E", price: "10004" },
];

function LibraryPage(props) {
  return (
    <div class="container">
      <div align="center">
        끼얏호우
        <button type="button" class="btn btn-primary">
          check
        </button>
      </div>
      <hr />
      {books.map((book) => {
        return <Book data={book} />;
      })}
    </div>
  );
}
export default LibraryPage;
