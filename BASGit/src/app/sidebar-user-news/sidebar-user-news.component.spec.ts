import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SidebarUserNewsComponent } from './sidebar-user-news.component';

describe('SidebarUserNewsComponent', () => {
  let component: SidebarUserNewsComponent;
  let fixture: ComponentFixture<SidebarUserNewsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SidebarUserNewsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SidebarUserNewsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
