import { TestBed } from '@angular/core/testing';

import { GpsDataService } from './gps-data.service';

describe('GpsDataService', () => {
  let service: GpsDataService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GpsDataService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
