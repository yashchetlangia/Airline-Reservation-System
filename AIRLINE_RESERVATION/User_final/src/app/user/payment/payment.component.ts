import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { BookingService } from 'src/app/Service/booking.service';

import { Payment } from '../Payment';
import { ViewBookingComponent } from '../view-booking/view-booking.component';


@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {
  payment:Payment = new Payment();
  submitted = false;

  bId:any = localStorage.getItem('bookingId');
  bookingId:number = parseInt(this.bId);
  paymentForm: FormGroup;

  fid:any = localStorage.getItem('flightId');
  flightId:number = parseInt(this.fid);

  uid:any = localStorage.getItem('userId')
  userId:number = parseInt(this.uid);

  tC:any = localStorage.getItem('totalCost') 
  totalCost:string = "Rs. "+this.tC + " /-";
  p1:any;
  p2:Payment;
  constructor(private formBuilder: FormBuilder, private router:Router, private bookingService: BookingService,private _router : Router) { }

  ngOnInit(): void {
    this.paymentForm = this.formBuilder.group({
      cardHolderName: ['',Validators.required],
      cardNumber: ['',Validators.required],
      cvv: ['',Validators.required],
      expiryDate: ['',Validators.required],
    
  }
  );
  }

  onSubmit() {
    console.log("SUBMIT");
    this.submitted = true
    if(this.paymentForm.invalid)
    {
      return;
    }
  

    

    this.p1 ={"booking":{
      "bookingId": this.bookingId,
      "travelClass":"",
      "bookingDate":"",
      "bookingStatus":"not confirmed",
      "noOfPassengers":"",
      "totalCost": 0,
      "refundAmount":0,
      "user": {
        "userId": this.userId,
        "email": "",
        "password": "",
        "title": "",
        "firstName": "",
        "lastName": "",
        "phoneNumber": 0,
        "dob": ""
    },
    "flight": {
      "flightId": this.flightId,
      "adminId": 0,
      "flightName": "",
      "source": "",
      "destination": "",
      "departureDate": "",
      "departureTime": "",
      "arrivalDate": "",
      "arrivalTime": "",
      "economicSeats": 0,
      "businessSeats": 0,
      "economyCost": 0,
      "businessCost": 0,
      "eSeatsBooked": 0,
      "bSeatsBooked": 0
  }

      },
      "cardName":this.paymentForm.value.cardHolderName,
      "cardNumber": this.paymentForm.value.cardNumber,
      "totalCost": 0
 
  }

    

    this.bookingService.payBill(this.p1).subscribe((data:any)=>
    {
      this.p2 = data;
      console.log(this.p2);
      console.log("here");
      this.router.navigateByUrl('userDash')

    })

    alert("Successfully Paid")
  
 }

 viewBooking()
  {
    this.router.navigateByUrl("viewBooking")
  }

}