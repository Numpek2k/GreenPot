import {Plant} from "../models/plant";
import {Calendar} from "../models/calendar";

export interface MyCalendarDTO{
  plant: Plant;
  calendarList: Calendar[];
}
