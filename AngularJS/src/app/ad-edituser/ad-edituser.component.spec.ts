import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdEdituserComponent } from './ad-edituser.component';

describe('AdEdituserComponent', () => {
  let component: AdEdituserComponent;
  let fixture: ComponentFixture<AdEdituserComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdEdituserComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdEdituserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
