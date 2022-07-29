import { HttpClient, HttpParams, HttpParamsOptions } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { OrderDetails } from '../Models/order-deatails';

@Injectable({
  providedIn: 'root'
})
export class OrderDetailsService {

  private baseurl='http://localhost:9002';
   orderDetails ?: OrderDetails;
  constructor(private http :HttpClient) { 


  }

   fetchOrderDetails(parmsData:any){

    const httpParams: HttpParamsOptions = { fromObject: parmsData } as HttpParamsOptions;

    const options = { params: new HttpParams(httpParams) };

    return this.http.get<OrderDetails>(this.baseurl+'/processdetail',options)

   }
   proceedToPayment(bodyData:any){

  
    return this.http.post(this.baseurl+'/completeprocessing',bodyData,{responseType: 'text'})

   }

saveOrderDetails(orderDetails: OrderDetails){
    this.orderDetails=orderDetails;
}

getDetailsForPayment(){
  return this.orderDetails;
}
 

}
