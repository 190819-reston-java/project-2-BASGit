import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SingleUserAllStoriesComponent } from './single-user-all-stories.component';

describe('SingleUserAllStoriesComponent', () => {
  let component: SingleUserAllStoriesComponent;
  let fixture: ComponentFixture<SingleUserAllStoriesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SingleUserAllStoriesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SingleUserAllStoriesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
