import { Component, Input } from '@angular/core';
import { Course } from '../../models/course.model';
import { EnrollmentService } from '../../services/enrollment.service';


@Component({

selector:'app-course-card',

standalone:true,

imports:[],

templateUrl:'./course-card.html',

styleUrl:'./course-card.css'

})


export class CourseCard {


@Input()
course!:Course;



constructor(
 private enrollmentService:EnrollmentService
){}



toggleEnrollment(){


if(this.enrollmentService
.isEnrolled(this.course.id)){


this.enrollmentService
.unenroll(this.course.id);


}
else{


this.enrollmentService
.enroll(this.course.id);


}


}



isEnrolled():boolean{


return this.enrollmentService
.isEnrolled(this.course.id);


}



}