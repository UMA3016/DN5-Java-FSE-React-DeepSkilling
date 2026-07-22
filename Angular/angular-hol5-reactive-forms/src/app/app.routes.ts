import { Routes } from '@angular/router';

import { ReactiveEnrollment } 
from './pages/reactive-enrollment/reactive-enrollment';


export const routes: Routes = [


    {
        path:'',
        redirectTo:'enroll-reactive',
        pathMatch:'full'
    },


    {
        path:'enroll-reactive',
        component:ReactiveEnrollment
    },


    {
        path:'**',
        redirectTo:'enroll-reactive'
    }


];