import { TestBed } from '@angular/core/testing';

import { UpdateProfileServiceService } from './update-profile-service.service';

describe('UpdateProfileServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: UpdateProfileServiceService = TestBed.get(UpdateProfileServiceService);
    expect(service).toBeTruthy();
  });
});
