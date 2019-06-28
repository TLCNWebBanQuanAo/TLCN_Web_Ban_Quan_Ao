import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShopBillDetailComponent } from './shop-bill-detail.component';

describe('ShopBillDetailComponent', () => {
  let component: ShopBillDetailComponent;
  let fixture: ComponentFixture<ShopBillDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShopBillDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShopBillDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
