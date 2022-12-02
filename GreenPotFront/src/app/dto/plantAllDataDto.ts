import {Plant} from "../models/plant";
import {SubCategory} from "../models/subCategory";
import {Image} from "../models/image";
import {Calendar} from "../models/calendar";

export interface PlantAllDataDto{
  plant: Plant;
  subCategoriesList: SubCategory[];
  imagesList: Image[];
  calendarList: Calendar[];
}
