import {User} from "./user";

export interface Comment{
  id?: number;
  content: string;
  date?: Date;
  authorCom?: User;
}
