package main.java.dhbw.fowler1.videostore;

abstract class Price{
    abstract double getCharge(int daysRented);
}
class ChildrensPrice extends Price {
    double getCharge(int daysRented){
        double result = 1.5; 
        if (daysRented > 3)
            result += (daysRented - 3) * 1.5; 
        return result;
    }
}
class NewReleasePrice extends Price { 
    double getCharge(int daysRented) {
        return daysRented * 3;
    }
}
class RegularPrice extends Price {
    double getCharge(int daysRented){
        double result = 2; 
        if (daysRented > 2)
            result += (daysRented - 2) * 1.5; 
        return result;
    }
}