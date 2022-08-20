import { Component, HostListener, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router, RouteReuseStrategy } from '@angular/router';
import { OrderDetails } from '../../Models/order-deatails';
import { AuthenticationService } from '../../Service/auth.service';
import { OrderDetailsService } from '../../Service/details.service';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})

export class PaymentComponent implements OnInit {

  totalCharge?: number;
  requestId?: string;
  od?: OrderDetails;
  errorMessage?: string;
  isPaymentCompleted: boolean = false;
  constructor(private route: Router, private orderservice: OrderDetailsService,
    private authservice: AuthenticationService) {

    this.od = this.orderservice.getDetailsForPayment();
    if (!this.od) {
      this.route.navigate(['orderform']);
    }
    this.totalCharge = this.od?.totalCharge;
    this.requestId = this.od?.requestId;

  }

  ngOnInit(): void {
  }

  onSubmit(paymentForm: NgForm) {

    console.log(paymentForm.value);
    const body = {
      cardNumber: paymentForm.value.creditCardNumber,
      cvv: paymentForm.value.cvv,
      amount: this.totalCharge,
      requestId: this.requestId
    }
    console.log(body);
    this.orderservice.proceedToPayment(body).subscribe(
      data => {
        console.log(data);
        this.isPaymentCompleted = true
      },
      error => {
        console.log(error);
        paymentForm.resetForm();
        switch (error.status) {

          case 401:
            this.errorMessage = "The User is not allowed";
            break;
          case 400:
            this.errorMessage = "Please check your Credit Card Detials and limit!";
            break;
          case 403:
            {
              this.errorMessage = "Unauthrorized User!";
              this.authservice.logout();
            }
            break;
          default:
            this.errorMessage = "Something went wrong";
        }

      }
    );

  }
  @HostListener("window:beforeunload", ["$event"]) unloadHandler(event: Event) {
    console.log("Processing beforeunload...", 'Data not saved on reload');
    event.returnValue = false;
  }

}
