import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardHolderPostComponent } from './card-holder-post.component';

describe('CardHolderPostComponent', () => {
  let component: CardHolderPostComponent;
  let fixture: ComponentFixture<CardHolderPostComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CardHolderPostComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CardHolderPostComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
