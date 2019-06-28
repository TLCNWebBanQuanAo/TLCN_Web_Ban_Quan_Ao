import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdListorderDetailComponent } from './ad-listorder-detail.component';

describe('AdListorderDetailComponent', () => {
  let component: AdListorderDetailComponent;
  let fixture: ComponentFixture<AdListorderDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdListorderDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdListorderDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
