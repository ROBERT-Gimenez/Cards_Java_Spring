import { Component, OnInit } from '@angular/core';
import { CardModel } from 'src/app/model/card-model';
import { CardService } from 'src/app/service/card.service';

@Component({
  selector: 'app-cards',
  templateUrl: './cards.component.html',
  styleUrls: ['./cards.component.css']
})
export class CardsComponent implements OnInit {


listCard:CardModel [] = [];
constructor(private cardService:CardService){}

ngOnInit(): void {
  this.list();
}
list(){
  this.cardService.getCards().subscribe(res=> {
    if(res){
      this.listCard = res;
    }
  })
}

}
