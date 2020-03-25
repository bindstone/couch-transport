import {Component, OnDestroy, OnInit} from '@angular/core';
import {TransportService} from "../../service/transport.service";
import {Observable, Subscription} from "rxjs";
import {debounce, throttleTime} from "rxjs/operators";

@Component({
  selector: 'tp-table',
  templateUrl: './tp-table.component.html',
  styleUrls: ['./tp-table.component.sass'],
  providers: [TransportService]
})
export class TpTableComponent implements OnInit, OnDestroy {
  private transportObservable: Observable<any>;
  private transportSubscription: Subscription;

  constructor(private transportService:TransportService) {
    this.transportObservable = transportService.getAll()
      .pipe(debounce(100));
  }

  ngOnInit(): void {
    this.transportSubscription = this.transportObservable.subscribe(value => {
      console.table(value);
    })
  }

  ngOnDestroy() {
    if (this.transportSubscription) {
      this.transportSubscription.unsubscribe();
    }
  }

}
