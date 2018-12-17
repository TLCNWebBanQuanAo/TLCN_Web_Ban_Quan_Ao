import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdAddsaleComponent } from './ad-addsale.component';

describe('AdAddsaleComponent', () => {
  let component: AdAddsaleComponent;
  let fixture: ComponentFixture<AdAddsaleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdAddsaleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdAddsaleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
