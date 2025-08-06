
const WeatherBox = ({weather}) => {
  console.log(weather);
  
  return (
    <div className="weather-box">
      <div>
        {weather?.name}
      </div>
      <div>
        {weather?.main.temp} C - {weather?.main.temp * 1.8 + 32} F
      </div>
      <div>
        {weather?.weather[0].description}
      </div>
    </div>
  )
}

export default WeatherBox;