import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { Router } from '@angular/router';
import { first } from 'rxjs/operators';
import * as moment from 'moment';
import * as $ from 'jquery';
import { AdminServiceService } from '../_service/admin-service/admin-service.service';
@Component({
  selector: 'app-statistics',
  templateUrl: './statistics.component.html',
  styleUrls: ['./statistics.component.css']
})
export class StatisticsComponent implements OnInit {
  statisticsDTOs: any[];
  dateStart: string;
  dateEnd: string;
  total:number = 0;
  dataTable: any;
  income: number = 0;
  constructor(private router: Router, private adminservice:AdminServiceService,
    private chRef: ChangeDetectorRef) { }

  ngOnInit() {
    this.dateStart = moment(new Date()).format("YYYY-MM-DD").toString();
    this.dateEnd = moment(new Date()).format("YYYY-MM-DD").toString();
    this.statistics();
  }
  statistics(){
    if(this.dateStart > this.dateEnd){
    alert("Date end can't be less than Date start!!!");
    }
    else{
      this.total = 0;
      this.adminservice.getProductStatistics(this.dateStart, this.dateEnd).pipe(first()).subscribe(res => {
        if(res.success == "true")
        this.statisticsDTOs = res.data;
        for(var i=0; i<this.statisticsDTOs.length ; i++){
          this.total += this.statisticsDTOs[i].quantity*this.statisticsDTOs[i].price;
        }
        this.income= this.total*20/100;
  
        // You'll have to wait that changeDetection occurs and projects data into 
        // the HTML template, you can ask Angular to that for you ;-)
      },err =>{
        console.log("errr")
      });
    }
    
  }


}
