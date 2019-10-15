import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagerUserAllStoriesComponent } from './manager-user-all-stories.component';

describe('ManagerUserAllStoriesComponent', () => {
  let component: ManagerUserAllStoriesComponent;
  let fixture: ComponentFixture<ManagerUserAllStoriesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManagerUserAllStoriesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagerUserAllStoriesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
