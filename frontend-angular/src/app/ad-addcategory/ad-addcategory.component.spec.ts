import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdAddcategoryComponent } from './ad-addcategory.component';

describe('AdAddcategoryComponent', () => {
  let component: AdAddcategoryComponent;
  let fixture: ComponentFixture<AdAddcategoryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdAddcategoryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdAddcategoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
