import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { TpRoutingModule } from './tp-routing.module';
import { TpRoot } from './component/root/tp.root';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FlexLayoutModule } from '@angular/flex-layout';
import { TpTableComponent } from './component/tp-table/tp-table.component';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    TpRoot,
    TpTableComponent
  ],
  imports: [
    BrowserModule,
    TpRoutingModule,
    FlexLayoutModule,
    BrowserAnimationsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [TpRoot]
})
export class TpModule { }
