import {User} from "./user";

export interface Post{
  id?: number;
  title: string;
  content: string;
  image: string;
  date?: Date;
  authorPost?: User;

}
