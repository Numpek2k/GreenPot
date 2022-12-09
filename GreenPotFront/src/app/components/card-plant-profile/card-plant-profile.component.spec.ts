import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardPlantProfileComponent } from './card-plant-profile.component';

describe('CardPlantProfileComponent', () => {
  let component: CardPlantProfileComponent;
  let fixture: ComponentFixture<CardPlantProfileComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CardPlantProfileComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CardPlantProfileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
