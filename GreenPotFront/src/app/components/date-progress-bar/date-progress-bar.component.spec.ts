import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DateProgressBarComponent } from './date-progress-bar.component';

describe('DateProgressBarComponent', () => {
  let component: DateProgressBarComponent;
  let fixture: ComponentFixture<DateProgressBarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DateProgressBarComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DateProgressBarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
