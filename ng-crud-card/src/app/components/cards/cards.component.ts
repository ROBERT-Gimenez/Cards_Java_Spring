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
isUpdate:boolean =false;
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

newCard(){
  this.isUpdate=false;
  this.formCard.reset();
}

selectItem(item:any){
  this.isUpdate =true;
  this.formCard.controls['id_card'].setValue(item.id_card);
  this.formCard.controls['name'].setValue(item.name);
  this.formCard.controls['number'].setValue(item.number);
  this.formCard.controls['type'].setValue(item.type);
  this.formCard.controls['cvv'].setValue(item.type);
}

}
