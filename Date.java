public class Date {
      private int day;
      private int month;
      private int year;


      Date() {
         this.day = 1;
         this.month = 1;
         this.year = 1000;
      }
      Date(int x, int y, int z){
         this.year = x;
         this.month = y;
         this.day = z;
      }

      public int getYear(){
         return year;
      }
      public int getMonth(){
         return month;
      }
      public int getDay(){
         return day;
      }
      public void setYear(int x){
         if(x >= 1000 && x <= 9999){
            this.year = x;
         }else
            throw new IllegalArgumentException("line 31");
      }
      public void setMonth(int x){
         if(x >= 1 && x <= 12){
            if(x == 2){
               if(this.day > 28)
                  throw new IllegalArgumentException("line 37");
            }else{
                  this.month = x;
               }
            if(x == 4 || x == 6 || x == 9 || x == 11){
               if(this.day > 30)
                  throw new IllegalArgumentException("line 43");
            }else{
                  this.month = x;
               }
      
         }else
            throw new IllegalArgumentException();
      }
      public void setDay(int x){
         if(x >= 1 && x <= 31){
            if(x == 31){
               if(this.month == 2 || this.month == 4 || this.month == 6 || this.month == 9 || this.month == 11)
                  throw new IllegalArgumentException("line 55");
            }else{
                  this.day = x;
               }
            if(x == 30 || x == 29){
               if(this.month == 2)
                  throw new IllegalArgumentException("line 61");
            }else{
                  this.day = x;
               }
         }else
            throw new IllegalArgumentException("line 66");
      }
      public String toString(){
         if(day<10 && month<10){
            String transform = String.format("0%d/0%d/%d",day,month,year);
            return transform;
         }else if(day<10 && month>=10){ 
            String transform = String.format("0%d/%d/%d",day,month,year);
            return transform;
         }else if(day>=10 && month<10){
            String transform = String.format("%d/0%d/%d",day,month,year);
            return transform;
         }else{
            String transform = String.format("%d/%d/%d",day,month,year);
            return transform;
         }
      }
      public void setDate(int x, int y, int z){
         setYear(x);
         setMonth(y);
         setDay(z);  
      }

   
}