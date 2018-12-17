import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdEditsaleComponent } from './ad-editsale.component';

describe('AdEditsaleComponent', () => {
  let component: AdEditsaleComponent;
  let fixture: ComponentFixture<AdEditsaleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdEditsaleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdEditsaleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
