import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardPostProfileComponent } from './card-post-profile.component';

describe('CardPostProfileComponent', () => {
  let component: CardPostProfileComponent;
  let fixture: ComponentFixture<CardPostProfileComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CardPostProfileComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CardPostProfileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
