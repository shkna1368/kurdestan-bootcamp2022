
public class CaloriesBurnCalculator {


//refrence https://captaincalculator.com/health/calorie/calories-burned-cycling-calculator/
    public double convertKmToMile(double km){
double mile=1.60934;
return km/mile;

    }

    public double convertMileToKm(double miles){
double mile=1.60934;
return miles*mile;

    }

    public double calculateBurnCalories(double avgSpeedInKm,double weight,double durationInMinute){
      double avgSpeedInMiles= convertKmToMile(avgSpeedInKm);

      double MET=0;
      if(avgSpeedInMiles<5.6){
          MET=3.5;

      }

      if(avgSpeedInMiles>=5.6&&avgSpeedInMiles<9.4){
          MET=4;

      }

if(avgSpeedInMiles>=9.4&&avgSpeedInMiles<10){

    MET=5.8;
      }

if(avgSpeedInMiles>=10&&avgSpeedInMiles<12){
    MET=6.8;

      }

if(avgSpeedInMiles>=12&&avgSpeedInMiles<14){

    MET=8;
      }

if(avgSpeedInMiles>=14&&avgSpeedInMiles<16){

    MET=10;
      }


if(avgSpeedInMiles>=16 && avgSpeedInMiles<20){

    MET=10;
      }

if(avgSpeedInMiles>=20){


    MET=15.8;
      }



      double  caloriesBurnedFromClisthenicsPerMinute = (MET * weight * 3.5) / 200;
      double  totalCaloriesBurnedFromClisthenics=caloriesBurnedFromClisthenicsPerMinute*durationInMinute;

return totalCaloriesBurnedFromClisthenics;
    }

    public static void main(String[] args) {
        CaloriesBurnCalculator   caloriesBurnCalculator=new CaloriesBurnCalculator();
       double cal= caloriesBurnCalculator.calculateBurnCalories(12.6,112.7,1);
        System.out.println(cal);
    }

}
