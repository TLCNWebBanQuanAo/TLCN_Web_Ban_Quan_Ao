import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShopWishlistComponent } from './shop-wishlist.component';

describe('ShopWishlistComponent', () => {
  let component: ShopWishlistComponent;
  let fixture: ComponentFixture<ShopWishlistComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShopWishlistComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShopWishlistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
