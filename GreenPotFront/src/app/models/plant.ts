import {Category} from "./category";
import {User} from "./user";

export interface Plant{
  id: number;
  name: string;
  description: string;
  category: Category;
  author: User
}
