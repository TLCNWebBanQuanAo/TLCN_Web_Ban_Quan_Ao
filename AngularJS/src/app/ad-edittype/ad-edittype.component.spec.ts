import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdEdittypeComponent } from './ad-edittype.component';

describe('AdEdittypeComponent', () => {
  let component: AdEdittypeComponent;
  let fixture: ComponentFixture<AdEdittypeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdEdittypeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdEdittypeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
