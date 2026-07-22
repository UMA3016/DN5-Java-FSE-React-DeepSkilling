import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CourseCard } from '../../components/course-card/course-card';

@Component({
  selector: 'app-course-list',
  standalone: true,
  imports: [CommonModule, CourseCard],
  templateUrl: './course-list.html',
  styleUrl: './course-list.css'
})
export class CourseList implements OnInit {

  isLoading = true;

  selectedCourseId: number | null = null;

  courses = [
    {
      id: 1,
      name: 'Angular',
      code: 'ANG101',
      credits: 4,
      gradeStatus: 'passed',
      enrolled: true
    },
    {
      id: 2,
      name: 'Java',
      code: 'JAVA201',
      credits: 3,
      gradeStatus: 'pending',
      enrolled: false
    },
    {
      id: 3,
      name: 'Spring Boot',
      code: 'SPR301',
      credits: 4,
      gradeStatus: 'failed',
      enrolled: false
    },
    {
      id: 4,
      name: 'React',
      code: 'REA401',
      credits: 3,
      gradeStatus: 'passed',
      enrolled: true
    },
    {
      id: 5,
      name: 'SQL',
      code: 'SQL501',
      credits: 2,
      gradeStatus: 'pending',
      enrolled: false
    }
  ];

  ngOnInit(): void {

    setTimeout(() => {

      this.isLoading = false;

    }, 1500);

  }

  onEnroll(courseId: number) {

    console.log('Enrolling in course:', courseId);

    this.selectedCourseId = courseId;

  }

  // trackBy improves performance by reusing DOM elements
  // instead of recreating every item whenever the array changes.
  trackByCourseId(index: number, course: any) {

    return course.id;

  }

}