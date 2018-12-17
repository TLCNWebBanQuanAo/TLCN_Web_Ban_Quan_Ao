import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdsaleComponent } from './adsale.component';

describe('AdsaleComponent', () => {
  let component: AdsaleComponent;
  let fixture: ComponentFixture<AdsaleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdsaleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdsaleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
