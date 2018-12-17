import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdEditproductComponent } from './ad-editproduct.component';

describe('AdEditproductComponent', () => {
  let component: AdEditproductComponent;
  let fixture: ComponentFixture<AdEditproductComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdEditproductComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdEditproductComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
