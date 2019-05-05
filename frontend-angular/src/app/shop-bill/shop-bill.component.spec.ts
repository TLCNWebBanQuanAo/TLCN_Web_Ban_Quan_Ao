import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShopBillComponent } from './shop-bill.component';

describe('ShopBillComponent', () => {
  let component: ShopBillComponent;
  let fixture: ComponentFixture<ShopBillComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShopBillComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShopBillComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
