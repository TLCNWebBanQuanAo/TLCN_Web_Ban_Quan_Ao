import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import * as $ from 'jquery';
import 'datatables.net';
import 'datatables.net-bs4';

@Component({
  selector: 'app-admin-frames',
  templateUrl: './admin-frames.component.html',
  styleUrls: ['./admin-frames.component.css']
})
export class AdminFramesComponent implements OnInit {

    // Our array of clients
    clients: any[];
    dataTable: any;

  constructor(private http: HttpClient, private chRef: ChangeDetectorRef) { }

  ngOnInit(){
    this.http.get('https://5a5a9e00bc6e340012a03796.mockapi.io/clients')
      .subscribe((data: any[]) => {
        this.clients = data;

        // You'll have to wait that changeDetection occurs and projects data into 
        // the HTML template, you can ask Angular to that for you ;-)
        this.chRef.detectChanges();

        // Now you can use jQuery DataTables :
        const table: any = $('table');
        this.dataTable = table.DataTable();
      });
  }

}
