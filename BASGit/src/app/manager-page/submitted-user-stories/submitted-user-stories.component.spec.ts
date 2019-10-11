import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SubmittedUserStoriesComponent } from './submitted-user-stories.component';

describe('SubmittedUserStoriesComponent', () => {
  let component: SubmittedUserStoriesComponent;
  let fixture: ComponentFixture<SubmittedUserStoriesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SubmittedUserStoriesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SubmittedUserStoriesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
