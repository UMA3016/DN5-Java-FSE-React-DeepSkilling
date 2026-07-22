import { Component } from '@angular/core';

@Component({
  selector: 'app-student-profile',
  standalone: true,
  templateUrl: './student-profile.html',
  styleUrl: './student-profile.css'
})
export class StudentProfile {

  student = {

    id: 101,

    name: 'Uma Sri',

    branch: 'Computer Science',

    cgpa: 9.2

  };

}