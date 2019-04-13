import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdAddproductComponent } from './ad-addproduct.component';

describe('AdAddproductComponent', () => {
  let component: AdAddproductComponent;
  let fixture: ComponentFixture<AdAddproductComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdAddproductComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdAddproductComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
