import GuestGreeting from "./GuestGreeting";
import UserGreeting from "./UserGreeting";

export default function Greeting(props) {
  const isFlag = props.isFlag;
  if (isFlag) {
    return <UserGreeting />;
  } else {
    return <GuestGreeting />;
  }
}
