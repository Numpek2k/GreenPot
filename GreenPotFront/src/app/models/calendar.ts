import {Plant} from "./plant";
import {Events} from "./events";

export interface Calendar{
  id: number;
  dateStart: string;
  dateEnd: string;
  plant: Plant;
  event: Events;
}
