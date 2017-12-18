import { TestBed, inject } from '@angular/core/testing';

import { ListarJefesService } from './listar-jefes.service';

describe('ListarJefesService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ListarJefesService]
    });
  });

  it('should be created', inject([ListarJefesService], (service: ListarJefesService) => {
    expect(service).toBeTruthy();
  }));
});
