import { Component, OnInit } from '@angular/core';
import { CourseService } from '../../services/course.service';
import { Course } from '../../models/course.model';
import { CourseCard } 
from '../course-card/course-card';

@Component({
  selector: 'app-course-list',
  standalone: true,
  imports: [],
  templateUrl: './course-list.html',
  styleUrl: './course-list.css'
})
export class CourseList implements OnInit {


  courses: Course[] = [];


  constructor(
    private courseService: CourseService
  ){}



  ngOnInit(): void {

    this.courses = this.courseService.getCourses();

  }


}