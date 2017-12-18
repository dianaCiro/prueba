import { TestBed, inject } from '@angular/core/testing';

import { SolicitudVacacionesService } from './solicitud-vacaciones.service';

describe('SolicitudVacacionesService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [SolicitudVacacionesService]
    });
  });

  it('should be created', inject([SolicitudVacacionesService], (service: SolicitudVacacionesService) => {
    expect(service).toBeTruthy();
  }));
});
