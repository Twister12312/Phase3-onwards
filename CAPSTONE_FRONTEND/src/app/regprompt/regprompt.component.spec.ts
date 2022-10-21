import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegpromptComponent } from './regprompt.component';

describe('RegpromptComponent', () => {
  let component: RegpromptComponent;
  let fixture: ComponentFixture<RegpromptComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegpromptComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RegpromptComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
