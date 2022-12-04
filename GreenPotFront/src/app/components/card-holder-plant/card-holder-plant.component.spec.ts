import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardHolderPlantComponent } from './card-holder-plant.component';

describe('CardHolderPlantComponent', () => {
  let component: CardHolderPlantComponent;
  let fixture: ComponentFixture<CardHolderPlantComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CardHolderPlantComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CardHolderPlantComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
