import { Component, Input, OnInit } from '@angular/core';
import { OrderDetails } from '../../Models/order-deatails';
import { OrderDetailsService } from '../../Service/details.service';

@Component({
  selector: 'app-confirmation',
  templateUrl: './confirmation.component.html',
  styleUrls: ['./confirmation.component.css']
})
export class ConfirmationComponent implements OnInit {

  requestId: string = 'ABCD!@#';
  ProcessingCharge: number = 250;
  pandCharge: number = 100;
  deliveryDate?: Date;
  totalCharge: number = this.ProcessingCharge + this.pandCharge;
  @Input()
  order!: OrderDetails;

  constructor() { }

  ngOnInit(): void {
    this.requestId = this.order.requestId;
    this.ProcessingCharge = this.order.processingCharge
    this.pandCharge = this.order.packagingAndDeliveryCharge
    this.deliveryDate = this.order.dateOfDelivery
    this.totalCharge = this.order.totalCharge
  }

}

