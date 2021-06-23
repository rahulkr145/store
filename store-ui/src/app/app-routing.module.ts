import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {StoreListComponent} from './store-list/store-list.component';


const routes: Routes = [
  {path: 'stores', component: StoreListComponent},
  {path: '**', redirectTo: 'stores'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
