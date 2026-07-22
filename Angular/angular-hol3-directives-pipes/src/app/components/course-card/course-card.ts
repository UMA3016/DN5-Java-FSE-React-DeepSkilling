import {
  Component,
  Input,
  Output,
  EventEmitter,
  OnChanges,
  SimpleChanges
} from '@angular/core';

import { CommonModule } from '@angular/common';
import { CreditLabelPipe } from '../../pipes/credit-label-pipe';
@Component({
  selector: 'app-course-card',
  standalone: true,
  imports: [CommonModule, CreditLabelPipe],
  templateUrl: './course-card.html',
  styleUrl: './course-card.css'
})
export class CourseCard implements OnChanges {

  @Input()
  course!: any;

  @Output()
  enrollRequested = new EventEmitter<number>();

  isExpanded = false;

  ngOnChanges(changes: SimpleChanges): void {

    console.log(
      'Course Changed',
      changes
    );

  }

  enroll() {

    this.enrollRequested.emit(this.course.id);

    this.course.enrolled = true;

  }

  toggleDetails() {

    this.isExpanded = !this.isExpanded;

  }

  get cardClasses() {

    return {

      'card--enrolled': this.course.enrolled,

      'card--full': this.course.credits >= 4,

      'expanded': this.isExpanded

    };

  }

}