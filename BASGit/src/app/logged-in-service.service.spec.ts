import { TestBed } from '@angular/core/testing';

import { LoggedInServiceService } from './logged-in-service.service';

describe('LoggedInServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: LoggedInServiceService = TestBed.get(LoggedInServiceService);
    expect(service).toBeTruthy();
  });
});
