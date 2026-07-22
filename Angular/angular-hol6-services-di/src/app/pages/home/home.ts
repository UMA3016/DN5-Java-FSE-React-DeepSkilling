import { Component, OnInit } from '@angular/core';
import { CourseService } from '../../services/course.service';
import { CourseSummaryWidget } 
from '../course-summary-widget/course-summary-widget';

@Component({

selector:'app-home',

standalone:true,

imports:[],

templateUrl:'./home.html',

styleUrl:'./home.css'

})


export class Home implements OnInit {


courseCount:number = 0;



constructor(
 private courseService: CourseService
){}



ngOnInit():void{


this.courseCount =
this.courseService.getCourses().length;


}



}