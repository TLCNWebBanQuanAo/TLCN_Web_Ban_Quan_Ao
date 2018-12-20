import { TestBed } from '@angular/core/testing';

import { UserproductService } from './userproduct.service';

describe('UserproductService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: UserproductService = TestBed.get(UserproductService);
    expect(service).toBeTruthy();
  });
});
