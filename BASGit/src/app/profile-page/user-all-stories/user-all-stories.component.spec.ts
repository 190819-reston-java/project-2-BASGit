import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserAllStoriesComponent } from './user-all-stories.component';

describe('UserAllStoriesComponent', () => {
  let component: UserAllStoriesComponent;
  let fixture: ComponentFixture<UserAllStoriesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserAllStoriesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserAllStoriesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
