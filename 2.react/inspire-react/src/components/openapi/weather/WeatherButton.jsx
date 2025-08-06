import { Button } from "react-bootstrap";

const WeatherButton = ({ cities, btnHandler, city }) => {
  return (
    <div className="weather-btn">
      <Button variant={`${city == "" ? "outline-warning" : "warning"}`} className="btn" onClick={() => btnHandler("")}>
        Current Location
      </Button>

      {
        cities.map((item, idx) => {
          return (
            <Button key={idx} className="btn" onClick={() => btnHandler(item)}
                    variant={`${city == item? "outline-warning" : "warning" }`}>
              {item}
            </Button>
          )
        })
      }

    </div>
  )
}

export default WeatherButton;