import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdListorderComponent } from './ad-listorder.component';

describe('AdListorderComponent', () => {
  let component: AdListorderComponent;
  let fixture: ComponentFixture<AdListorderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdListorderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdListorderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
