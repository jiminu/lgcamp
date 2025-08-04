import React from "react";

const styles = {
  wrapper: {
    border: "1px solid tomato",
    borderRadius: 16,
    display: "flex",
    flexDirection: "row",
    padding: 8,
    margin: 8,
  },
  msgTxt: {
    color: "red",
    fontSize: 16,
  },
};

class Notification extends React.Component {
  constructor(props) {
    super(props);
    this.state = {};
  }
  componentDidMount() {
    console.log("Mount");
  }
  componentDidUpdate() {
    console.log("Update");
  }
  componentWillUnmount() {
    console.log("Unmount");
  }
  shouldComponentUpdate(nextProps) {
    return nextProps.msg !== this.props.msg;
  }
  render() {
    return (
      <div style={styles.wrapper}>
        <span style={styles.msgTxt}>{this.props.msg}</span>
      </div>
    );
  }
}

export default Notification;
