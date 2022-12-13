import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CommentCardHolderComponent } from './comment-card-holder.component';

describe('CommentCardHolderComponent', () => {
  let component: CommentCardHolderComponent;
  let fixture: ComponentFixture<CommentCardHolderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CommentCardHolderComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CommentCardHolderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
