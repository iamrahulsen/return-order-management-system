import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { OrderDetails } from '../../Models/order-deatails';
import { AuthenticationService } from '../../Service/auth.service';
import { OrderDetailsService } from '../../Service/details.service';

@Component({
  selector: 'app-order-form',
  templateUrl: './order-form.component.html',
  styleUrls: ['./order-form.component.css']
})
export class OrderFormComponent implements OnInit {
  jwt;
  orderDetails?: OrderDetails;
  errorMessage?: string;
  constructor(private orderservice: OrderDetailsService, private route: Router, private authservice: AuthenticationService) {
    this.jwt = AuthenticationService.jwt;
    console.log(this.jwt)
  }

  ngOnInit(): void {
  }

  onSubmit(orderform: NgForm) {
    console.log(orderform.value);
    this.orderservice.fetchOrderDetails(orderform.value).subscribe(
      data => {
        console.log(data);
        data.totalCharge = data.packagingAndDeliveryCharge + data.processingCharge;
        this.orderDetails = {
          'dateOfDelivery': data.dateOfDelivery,
          'packagingAndDeliveryCharge': data.packagingAndDeliveryCharge,
          'processingCharge': data.processingCharge,
          'requestId': data.requestId,
          'totalCharge': 0 + data.processingCharge + data.packagingAndDeliveryCharge
        };
        console.log(this.orderDetails)
        this.orderservice.saveOrderDetails(this.orderDetails);
      },
      error => {
        console.log(error)
        switch (error.status) {

          case 401:
            this.errorMessage = "user forbidden";
            break;
          case 400:
            this.errorMessage = "Invalid input details";
            break;
          case 403:
            {
              this.errorMessage = "User Not Authorized";
              this.authservice.logout();
            }
            break;
          default:
            this.errorMessage = "Something went wrong";
        }
      }
    )
  }

  cancel() {
    this.orderDetails = undefined
  }

  proceedToPay() {

    this.route.navigate(['payment']);
  }




}


