import { TestBed } from '@angular/core/testing';

import { NewsServiceService } from './news-service.service';

describe('NewsServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: NewsServiceService = TestBed.get(NewsServiceService);
    expect(service).toBeTruthy();
  });
});
