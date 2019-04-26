import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdMenuComponent } from './ad-menu.component';

describe('AdMenuComponent', () => {
  let component: AdMenuComponent;
  let fixture: ComponentFixture<AdMenuComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdMenuComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdMenuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
