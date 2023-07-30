import logo from "./logo.svg";
import NormalBid from "./normalBid";
import "./App.css";
import dayjs from "dayjs";
import { useEffect, useState } from "react";

function TimeCheck() {
  const [day, setDay] = useState(); // 남은 시간 (단위: 초)
  const [hour, setHour] = useState(); // 남은 시간 (단위: 초)
  const [minute, setMinute] = useState(); // 남은 시간 (단위: 초)
  const [second, setSecond] = useState(); // 남은 시간 (단위: 초)
  const [date, setDate] = useState(); // 남은 시간 (단위: 초)
  const [time, setTime] = useState(); // 남은 시간 (단위: 초)
  const dateForm = "YYYY-MM-DD HH:mm:ss";

  useEffect(() => {
    const json = "2023-07-30 24:00:00";
    const dateJson = dayjs(json).format(dateForm);
    setDate(dateJson);
    setTime(date);
    // console.log(dayjs(date).format() + "");
  }, []);

  useEffect(() => {
    const timer = setInterval(() => {
      const temp = dayjs(date);
      setTime(temp.subtract(1, "s").format());
      const now = dayjs();
      let diff = Math.abs(now.diff(temp));
      console.log(diff);
      const diffDay = Math.floor(diff / (1000 * 60 * 60 * 24));
      setDay(diffDay);
      console.log("day: " + Math.floor(day));
      diff = diff - diffDay * (1000 * 60 * 60 * 24);
      const diffHour = Math.floor(diff / (1000 * 60 * 60));
      setHour(diffHour);
      console.log("hour : " + Math.floor(hour));
      diff = diff - diffHour * (1000 * 60 * 60);

      const diffMinute = Math.floor(diff / (1000 * 60));
      setMinute(diffMinute);
      console.log("minute : " + Math.floor(minute));
      diff = diff - diffMinute * (1000 * 60);

      const diffSecond = Math.floor(diff / 1000);
      setSecond(diffSecond);
      console.log("second : " + Math.floor(second));
    }, 1000);

    // console.log(time);

    return () => clearInterval(timer);
  }, [time]);

  return (
    <div>
      <h1>남은 시간</h1>
      <div>
        <span>
          {/* {date} */}
          {day}일 {hour}시간 {minute}분 {second}초
        </span>
        <span> : </span>
        {/* <span>{getSeconds(time)}</span> */}
      </div>
    </div>
  );
}

export default TimeCheck;
