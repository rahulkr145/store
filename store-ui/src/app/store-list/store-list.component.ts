import { Component, OnInit } from '@angular/core';
import {RequestService} from '../services/request.service';

@Component({
  selector: 'app-store-list',
  templateUrl: './store-list.component.html',
  styleUrls: ['./store-list.component.scss']
})
export class StoreListComponent implements OnInit {

  stores;
  page = 4;
  pageSize = 40;
  searchText: string;

  constructor(private requestService: RequestService) { }

  ngOnInit() {
    this.requestService.get(`store`).subscribe( data => {
      this.stores = data;
      this.stores.forEach(data => data.editable = false);
      return this.stores
    });
  }

  edit(store: any) {
    this.stores.forEach(data => data.editable = false);
    store.editable = true;
  }

  save(store: any) {
    store.editable = false;
    this.requestService.post(`store`, store).subscribe();
  }
}
