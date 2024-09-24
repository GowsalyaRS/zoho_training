package com.solidprinciple.open_close_principle.bad;
class Vehical 
{
    float calculateTollGateFees(VehicalType typeOfVehicle)
    {
         if(typeOfVehicle.equals(VehicalType.CAR)) 
         {
            return 50.0f;
         } 
         else if(typeOfVehicle.equals(VehicalType.BIKE))
         {
            return 30.0f;
         }
         return 0.0f;
    }
}
