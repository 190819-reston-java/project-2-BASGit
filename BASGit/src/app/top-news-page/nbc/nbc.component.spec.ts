import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NbcComponent } from './nbc.component';

describe('NbcComponent', () => {
  let component: NbcComponent;
  let fixture: ComponentFixture<NbcComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NbcComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NbcComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
