import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MemuAdminComponent } from './memu-admin.component';

describe('MemuAdminComponent', () => {
  let component: MemuAdminComponent;
  let fixture: ComponentFixture<MemuAdminComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MemuAdminComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MemuAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
