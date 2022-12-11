import {Category} from "./category";
import {User} from "./user";
import {Image} from "./image";
import {SubCategory} from "./subCategory";
import {Calendar} from "./calendar";

export interface Plant{
  id?: number;
  name: string;
  description: string;
  requirements: string;
  planting: string;
  growing: string;
  date?: Date;
  category: Category;
  author: User

//   adding plant

  images?: Image[]
  subCategories?: SubCategory[]
  calendar?: Calendar[]
}
