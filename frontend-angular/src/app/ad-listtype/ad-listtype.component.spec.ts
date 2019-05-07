import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdListtypeComponent } from './ad-listtype.component';

describe('AdListtypeComponent', () => {
  let component: AdListtypeComponent;
  let fixture: ComponentFixture<AdListtypeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdListtypeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdListtypeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
