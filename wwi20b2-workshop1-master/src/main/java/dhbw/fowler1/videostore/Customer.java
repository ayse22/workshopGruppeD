package dhbw.fowler1.videostore;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
private String _name;
private Vector _rentals = new Vector();

public Customer(String name) {
_name = name;
}

public String statement() {
    return new TextStatement().value(this);
}

class Statement {
    public String value(Customer aCustomer) {
        Enumeration rentals = aCustomer.getRentals();
        String result = headerString(aCustomer);
            while (rentals.hasMoreElements()) {
                Rental each = (Rental) rentals.nextElement();
                result += eachRentalString(each);
             }
        result += footerString(aCustomer);
    return result;
            }
    String eachRentalString (Rental aRental) {
        return "\t" + aRental.getMovie().getTitle()+ "\t" +
        String.valueOf(aRental.getCharge()) + "\n"; 
        }
        String footerString (Customer aCustomer) { 
            return "Amount owed is " +
        String.valueOf(aCustomer.getTotalCharge()) + "\n" +
        "You earned " + String.valueOf(aCustomer.getTotalFrequentRenterPoints()) + " frequent renter points";
        }
    String headerString(Customer aCustomer) {
        return "Rental Record for " + aCustomer.getName() + "\n";
    }
}

abstract class TextStatement {
    abstract String headerString(Customer aCustomer); 
    abstract String eachRentalString (Rental aRental); 
    abstract String footerString (Customer aCustomer);
}


public String htmlStatement() {
    return new HtmlStatement().value(this);
}

class HtmlStatement {
    public String value(Customer aCostumer){
        Enumeration rentals = _rentals.elements();
    String result = "<H1>Rentals for <EM>" + getName() + "</EM></H1><P>\n"; 
    while (rentals.hasMoreElements()) {
        Rental each = (Rental) rentals.nextElement(); //show figures for each rental
        result += each.getMovie().getTitle()+ ": " +
        String.valueOf(each.getCharge()) + "<BR>\n";
    }
    result += "<P>You owe <EM>" + 
    String.valueOf(getTotalCharge()) + "</EM><P>\n";
    result += "On this rental you earned <EM>" +
    String.valueOf(getTotalFrequentRenterPoints()) +
    "</EM> frequent renter points<P>"; 
    return result;
    }
    String headerString(Customer aCustomer) {
        return "<H1>Rentals for <EM>" + aCustomer.getName() + "</EM></H1><P>\n";
    }
}


public void addRental(Rental arg) {
_rentals.addElement(arg);
}

public String getName() {
return _name;
}

private double getTotalCharge() { 
    double result = 0;
    Enumeration rentals = _rentals.elements();
    while (rentals.hasMoreElements()) {
        Rental each = (Rental) rentals.nextElement();
        result += each.getCharge(); 
    }
    return result;
}
private int getTotalFrequentRenterPoints(){ 
    int result = 0;
    Enumeration rentals = _rentals.elements(); 
    while (rentals.hasMoreElements()) {
        Rental each = (Rental) rentals.nextElement();
        result += each.getFrequentRenterPoints(); 
    }
    return result;
}
}