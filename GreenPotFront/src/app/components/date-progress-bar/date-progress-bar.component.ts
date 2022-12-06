import {Component, Input, OnInit} from '@angular/core';
import {Calendar} from "../../models/calendar";

interface Percentage {
  startDate: number;
  endDate: number;
  isInRange: boolean;
}

@Component({
  selector: 'app-date-progress-bar',
  templateUrl: './date-progress-bar.component.html',
  styleUrls: ['./date-progress-bar.component.css']
})
export class DateProgressBarComponent implements OnInit {

  constructor() {
  }

  @Input() calendar!: Calendar[]
  todayPercentage?: any;
  percent: Array<Percentage> = [];

  ngOnInit(): void {
    this.todayPercentage = this.dateToPercentage(new Date())
    for (let cal of this.calendar) {
      this.calcDate(cal)
      this.trimDates(cal)
    }
  }

  dateToPercentage(date: Date) {
    return Math.floor((date.getTime() - new Date(date.getFullYear(), 0, 0).getTime()) / 1000 / 60 / 60 / 24 / 365 * 100)
  }

  calcDate(calendar: Calendar) {
    let start = new Date(calendar.dateStart)
    let end = new Date(calendar.dateEnd)
    let today = new Date

    if (today > start && today < end) {
      this.percent[calendar.id] = {
        startDate: this.dateToPercentage(start),
        endDate: this.dateToPercentage(end),
        isInRange: true
      }
      return;
    }

    this.percent[calendar.id] = {
      startDate: this.dateToPercentage(start),
      endDate: this.dateToPercentage(end),
      isInRange: false
    }
  }

  trimDates(calendar: Calendar) {
    calendar.dateStart = calendar.dateStart.substring(5, 10)
    calendar.dateEnd = calendar.dateEnd.substring(5, 10)
  }

}
