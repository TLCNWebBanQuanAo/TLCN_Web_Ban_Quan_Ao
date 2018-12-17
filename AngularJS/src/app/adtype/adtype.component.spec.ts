import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdtypeComponent } from './adtype.component';

describe('AdtypeComponent', () => {
  let component: AdtypeComponent;
  let fixture: ComponentFixture<AdtypeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdtypeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdtypeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
