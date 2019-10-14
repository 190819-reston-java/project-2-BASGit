import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FoxComponent } from './fox.component';

describe('FoxComponent', () => {
  let component: FoxComponent;
  let fixture: ComponentFixture<FoxComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FoxComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FoxComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
