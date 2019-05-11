import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdListuserComponent } from './ad-listuser.component';

describe('AdListuserComponent', () => {
  let component: AdListuserComponent;
  let fixture: ComponentFixture<AdListuserComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdListuserComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdListuserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
