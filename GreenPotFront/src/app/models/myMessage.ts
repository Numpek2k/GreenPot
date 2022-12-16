import {User} from "./user";

export interface MyMessage {
  id?:number;
  content: string;
  date?: Date;
  sender?: User;
  receiver?: User;

}
