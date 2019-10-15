import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FeaturedUserStoriesComponent } from './featured-user-stories.component';

describe('FeaturedUserStoriesComponent', () => {
  let component: FeaturedUserStoriesComponent;
  let fixture: ComponentFixture<FeaturedUserStoriesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FeaturedUserStoriesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FeaturedUserStoriesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
