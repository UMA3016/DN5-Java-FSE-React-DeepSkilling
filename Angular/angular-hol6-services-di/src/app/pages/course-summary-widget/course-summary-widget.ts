import { Component, OnInit } from '@angular/core';
import { CourseService } from '../../services/course.service';


@Component({

selector:'app-course-summary-widget',

standalone:true,

imports:[],

templateUrl:'./course-summary-widget.html',

styleUrl:'./course-summary-widget.css'

})


export class CourseSummaryWidget implements OnInit {


totalCourses:number=0;



constructor(
 private courseService:CourseService
){}



ngOnInit():void{


this.totalCourses =
this.courseService.getCourses().length;


}



}