import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { CardModel } from 'src/app/model/card-model';
import { CardService } from 'src/app/service/card.service';

@Component({
  selector: 'app-cards',
  templateUrl: './cards.component.html',
  styleUrls: ['./cards.component.css']
})
export class CardsComponent implements OnInit {


listCard:CardModel [] = [];
formCard:FormGroup = new FormGroup({});

constructor(private cardService:CardService){}

ngOnInit(): void {
  this.list();
  this.formCard = new FormGroup({
    id_card: new FormControl(''),
    name: new FormControl(''),
    number: new FormControl(''),
    type: new FormControl(''),
    cvv: new FormControl(''),
    status: new FormControl('1'),
  });
}
list(){
  this.cardService.getCards().subscribe(res=> {
    if(res){
      this.listCard = res;
    }
  })
}

}
