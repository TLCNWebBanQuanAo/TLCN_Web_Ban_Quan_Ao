import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminFramesComponent } from './admin-frames.component';

describe('AdminFramesComponent', () => {
  let component: AdminFramesComponent;
  let fixture: ComponentFixture<AdminFramesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminFramesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminFramesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
