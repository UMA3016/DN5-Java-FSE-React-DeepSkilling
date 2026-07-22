import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './home.html',
  styleUrl: './home.css'
})
export class Home {

  studentName = 'Uma Sri';

  portalName = 'Student Course Portal';

  today = new Date();

  fees = 25000;

  gpa = 3.8456;

}