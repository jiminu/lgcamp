function BookComponent(props) {
  return (
    <div>
      <div>
        책 이름 : {props.name}, 가격 : {props.price}
      </div>
      <div>{`책 이름 : ${props.name}, 가격 : ${props.price}`}</div>
    </div>
  );
}

export default BookComponent;
