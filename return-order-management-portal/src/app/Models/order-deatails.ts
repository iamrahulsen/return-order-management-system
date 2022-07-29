// Model to capturing the details of the order
export interface OrderDetails{
    requestId : string;
    processingCharge : number;
    packagingAndDeliveryCharge :number;
    totalCharge:number;
    dateOfDelivery : Date
}