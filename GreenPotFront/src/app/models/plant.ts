import {Category} from "./category";
import {User} from "./user";

export interface Plant{
  id: number;
  name: string;
  description: string;
  requirements: string;
  planting: string;
  growing: string;
  date: Date;
  category: Category;
  author: User
}
