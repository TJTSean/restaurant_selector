import { Restaurant } from "./restaurant";

export class RestaurantAppResponse {
    timeStamp: Date;
    statusCode: number;
    status: string;
    reason: string;
    message: string;
    logMessage: string;
    data: Map<string, Restaurant>
    //data: { restaurant?: Restaurant };
}