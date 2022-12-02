import {Plant} from "./plant";
import {Event} from "./event";

export interface Calendar{
  id: number;
  dateStart: string;
  dateEnd: string;
  plant: Plant;
  event: Event;
}
