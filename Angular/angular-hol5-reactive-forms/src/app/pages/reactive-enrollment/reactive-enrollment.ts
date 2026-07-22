import { Component, OnInit } from '@angular/core';

import {
  FormBuilder,
  FormGroup,
  FormArray,
  FormControl,
  Validators,
  AbstractControl,
  ValidationErrors
} from '@angular/forms';

import { ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';


// Custom Synchronous Validator

export function noCourseCode(
  control: AbstractControl
): ValidationErrors | null {


  const value = control.value;


  if(value && value.startsWith('XX')){

    return {
      noCourseCode:true
    };

  }


  return null;

}



// Custom Async Validator

export function simulateEmailCheck(
  control: AbstractControl
): Promise<ValidationErrors | null> {


  return new Promise((resolve)=>{


    setTimeout(()=>{


      if(control.value?.includes('test@')){


        resolve({

          emailTaken:true

        });


      }
      else{


        resolve(null);


      }


    },800);


  });


}





@Component({

  selector:'app-reactive-enrollment',

  standalone:true,

  imports:[
    CommonModule,
    ReactiveFormsModule
  ],

  templateUrl:'./reactive-enrollment.html',

  styleUrl:'./reactive-enrollment.css'

})


export class ReactiveEnrollment implements OnInit{


  enrollForm!:FormGroup;



  constructor(
    private fb:FormBuilder
  ){}




  ngOnInit(){



    this.enrollForm=this.fb.group({



      studentName:[

        '',

        [

          Validators.required,

          Validators.minLength(3)

        ]

      ],




      studentEmail:

      this.fb.control(

        '',

        [

          Validators.required,

          Validators.email

        ],

        [

          simulateEmailCheck

        ]

      ),





      courseId:[


        '',

        [

          Validators.required,

          noCourseCode

        ]

      ],





      preferredSemester:[

        'Odd',

        Validators.required

      ],




      agreeToTerms:[

        false,

        Validators.requiredTrue

      ],





      additionalCourses:

      this.fb.array([])



    });



  }







  // Typed getter for FormArray

  get additionalCourses(): FormArray<FormControl> {

  return this.enrollForm
    .get('additionalCourses') as FormArray<FormControl>;

}





  addCourse(){


    this.additionalCourses.push(


      new FormControl(

        '',

        Validators.required

      )


    );


  }







  removeCourse(index:number){


    this.additionalCourses.removeAt(index);


  }







  onSubmit(){



    console.log(

      "Form Value:",

      this.enrollForm.value

    );



    console.log(

      "Raw Value:",

      this.enrollForm.getRawValue()

    );



  }



}