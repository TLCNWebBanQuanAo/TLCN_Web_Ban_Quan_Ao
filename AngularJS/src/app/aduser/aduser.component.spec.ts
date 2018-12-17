import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AduserComponent } from './aduser.component';

describe('AduserComponent', () => {
  let component: AduserComponent;
  let fixture: ComponentFixture<AduserComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AduserComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AduserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
