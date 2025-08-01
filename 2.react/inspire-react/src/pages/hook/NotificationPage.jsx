import React from "react";
import Notification from "../../components/hook/Notification";

const lst = [
  { id: 1, msg: "well done" },
  { id: 2, msg: "good job" },
  { id: 3, msg: "bad job" },
];

var timer;

class NotificationPage extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      notifications: [],
    };
  }

  componentDidMount() {
    console.log("NotificationPage appear~");
    const { notifications } = this.state;
    timer = setInterval(() => {
      // if (notifications.length < lst.length) {
      //   notifications.push(lst[notifications.length]);
      //   this.setState({
      //     notifications: notifications,
      //   });
      // } else {
      //   this.setState({
      //     notification: [],
      //   });
      //   clearInterval(timer);
      // }
      this.setState((pre) => {
        const next = [...pre.notifications];
        if (next.length < lst.length) {
          next.push(lst[next.length]);
          return { notifications: next };
        } else {
          clearInterval(timer);
          return { notifications: [] };
        }
      });
    }, 5000);
  }
  componentWillUnmount() {
    console.log("NotificationPage disappear~");
    if (timer) {
      clearInterval(timer);
    }
  }
  render() {
    return (
      <div>
        {this.state.notifications.map((notification) => {
          return (
            <Notification
              key={notification.id}
              id={notification.id}
              msg={notification.msg}
            />
          );
        })}
      </div>
    );
  }
}

export default NotificationPage;
