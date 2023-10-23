export class Activity {
    constructor(
        public id: number,
        public title: string,
        public price: number,
        public currency: string,
        public rating: number,
        public specialOffer: boolean,
        public supplierId: number
        ) {

        }
    
}


export class ActivityModel {
    private activities: Activity[];
    constructor() {
        this.activities = new Array<Activity>();
    }

    addActivity(activity: Activity) {
        this.activities.push(activity);
    }

    filterActivityByTitle(title: string){
        title = title.toUpperCase();
        return this.activities.filter(activity => {
            let titleToFilter = activity.title.toUpperCase();
            if (titleToFilter == title ||
                titleToFilter.startsWith(title) ||
                titleToFilter.endsWith(title) ||
                titleToFilter.includes(title))
                return true;
            else
                return false;
                }
        );
    }
}