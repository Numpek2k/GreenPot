import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GeoLocComponent } from './geo-loc.component';

describe('GeoLocComponent', () => {
  let component: GeoLocComponent;
  let fixture: ComponentFixture<GeoLocComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GeoLocComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GeoLocComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
