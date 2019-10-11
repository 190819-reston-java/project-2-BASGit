import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SubmitStoryComponent } from './submit-story.component';

describe('SubmitStoryComponent', () => {
  let component: SubmitStoryComponent;
  let fixture: ComponentFixture<SubmitStoryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SubmitStoryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SubmitStoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
