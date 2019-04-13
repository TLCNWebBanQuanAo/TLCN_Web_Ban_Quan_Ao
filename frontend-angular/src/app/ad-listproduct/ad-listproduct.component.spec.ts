import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdListproductComponent } from './ad-listproduct.component';

describe('AdListproductComponent', () => {
  let component: AdListproductComponent;
  let fixture: ComponentFixture<AdListproductComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdListproductComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdListproductComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
