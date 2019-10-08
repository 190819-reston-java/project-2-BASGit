import { TestBed } from '@angular/core/testing';

import { SubmitNewsServiceService } from './submit-news-service.service';

describe('SubmitNewsServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: SubmitNewsServiceService = TestBed.get(SubmitNewsServiceService);
    expect(service).toBeTruthy();
  });
});
