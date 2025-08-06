import { useEffect, useState } from "react";
import "./components/openapi/css/weather.css";
import WeatherBox from "./components/openapi/weather/WeatherBox";
import WeatherButton from "./components/openapi/weather/WeatherButton";
import { ThreeDots } from "react-loader-spinner";

const WeatherApp = () => {

  const apiKey = process.env.REACT_APP_OPENAPI_KEY;
  // console.log(apiKey);

  const [weather, setWeather] = useState(null);
  const cityAry = ["Busan", "Paris", "New York", "seoul"];
  const [city, setCity] = useState("");
  const [visible, setVisible] = useState(false);

  // optional chaining
  // const obj = {name: "mindoo", age: 10};
  // console.log(`obj => ${obj?.addr}`);
  
  const getWeatherByCityName = async () => {
    let url = `https://api.openweathermap.org/data/2.5/weather?q=${city}&appid=${apiKey}&units=metric&lang=kr`;
    setVisible(true);
    const response = await fetch(url);
    const data = await response.json();
    // console.log(data);
    setWeather(data);
    setVisible(false);
  }
  
  const getCurrentLocation = () => {
    navigator.geolocation.getCurrentPosition((position) => {
      let lat = position.coords.latitude;
      let lon = position.coords.longitude;
      getWeatherByCurrentLocation(lat, lon);
    });
  };
  
  const getWeatherByCurrentLocation = async (lat, lon) => {
    let url = `https://api.openweathermap.org/data/2.5/weather?lat=${lat}&lon=${lon}&appid=${apiKey}&units=metric&lang=kr`;
    setVisible(true);
    const response = await fetch(url);
    const data = await response.json();
    // console.log(data);
    setWeather(data);
    setVisible(false);
  }

  useEffect(() => {
    if ( city === "") {
      getCurrentLocation();
    }
    else {
      getWeatherByCityName();
    }
  }, [city]);

  return (
    <div className="container">
      <ThreeDots
        height="80"
        width="80"
        radius="9"
        color="#4fa94d"
        ariaLabel="three-dots-loading"
        visible={visible}
      />

      <WeatherBox weather={weather}></WeatherBox>
      <WeatherButton cities={cityAry} btnHandler={setCity} city={city}></WeatherButton>
    </div>
  );
}

export default WeatherApp;