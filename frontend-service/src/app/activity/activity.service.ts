import { Injectable } from '@angular/core';
import { ActivityModel } from './activity';

@Injectable({
  providedIn: 'root'
})
export class ActivityService {
  private activityModel: ActivityModel
  constructor(
  ) { 
    this.activityModel = new ActivityModel();
  }

  
}
