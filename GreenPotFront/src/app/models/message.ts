import {User} from "./user";

export interface Message{
  id?:number;
  content: string;
  date?: Date;
  sender?: User;
  receiver?: User;

}
