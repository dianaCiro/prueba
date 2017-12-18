import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarJefesComponent } from './listar-jefes.component';

describe('ListarJefesComponent', () => {
  let component: ListarJefesComponent;
  let fixture: ComponentFixture<ListarJefesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListarJefesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListarJefesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
