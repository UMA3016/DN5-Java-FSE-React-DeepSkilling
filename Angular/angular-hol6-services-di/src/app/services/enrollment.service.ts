import { Injectable } from '@angular/core';
import { CourseService } from './course.service';
import { Course } from '../models/course.model';


@Injectable({
  providedIn:'root'
})
export class EnrollmentService {


  private enrolledCourseIds:number[] = [];



  constructor(
    private courseService:CourseService
  ) {}



  // Enroll a course

  enroll(courseId:number):void{

    if(!this.enrolledCourseIds.includes(courseId)){

      this.enrolledCourseIds.push(courseId);

    }

  }



  // Remove enrollment

  unenroll(courseId:number):void{

    this.enrolledCourseIds =
    this.enrolledCourseIds.filter(
      id => id !== courseId
    );

  }



  // Check enrollment status

  isEnrolled(courseId:number):boolean{

    return this.enrolledCourseIds.includes(courseId);

  }



  // Get full course details

  getEnrolledCourses():Course[]{


    return this.enrolledCourseIds

    .map(id =>
      this.courseService.getCourseById(id)
    )

    .filter(
      (course):course is Course =>
      course !== undefined
    );


  }



}