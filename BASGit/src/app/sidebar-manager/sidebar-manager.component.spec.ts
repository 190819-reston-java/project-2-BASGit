import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SidebarManagerComponent } from './sidebar-manager.component';

describe('SidebarManagerComponent', () => {
  let component: SidebarManagerComponent;
  let fixture: ComponentFixture<SidebarManagerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SidebarManagerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SidebarManagerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
