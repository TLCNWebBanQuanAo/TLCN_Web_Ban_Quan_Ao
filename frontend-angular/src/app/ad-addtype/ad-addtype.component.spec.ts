import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdAddtypeComponent } from './ad-addtype.component';

describe('AdAddtypeComponent', () => {
  let component: AdAddtypeComponent;
  let fixture: ComponentFixture<AdAddtypeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdAddtypeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdAddtypeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
