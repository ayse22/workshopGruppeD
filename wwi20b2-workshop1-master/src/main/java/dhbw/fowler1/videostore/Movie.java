package dhbw.fowler1.videostore;

public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String _title;
    private int _priceCode;

    public Movie(String title, int priceCode) {
        _title = title;
        _priceCode = priceCode;
    }

    public int getPriceCode() {
        return _price.getPriceCode();
    }

    public void setPriceCode(int arg) {
        switch (arg) {
            case REGULAR:
                _price = new RegularPrice();
                break;
            case CHILDRENS:
                _price = new ChildrensPrice();
                break;
            case NEW_RELEASE:
                _price = new NewReleasePrice();
            break;
        default:
            throw new
    IllegalArgumentException
            ("Incorrect Price Code");
        }
    }
    
private Price _price;

    public String getTitle() {
        return _title;
    }

    double getCharge(int daysRented){
        double result = 0;
        switch (getMovie().getPriceCode()) {
            case Movie.REGULAR: result += 2;
            if (getDaysRented() > 2)
            result += (getDaysRented() - 2) * 1.5;
            break;
            case Movie.NEW_RELEASE:
            result += getDaysRented() * 3;
            break;
            case Movie.CHILDRENS:
            result += 1.5;
            if (getDaysRented() > 3)
            result += (getDaysRented() - 3) * 1.5;
            break;    
        }
        return result;
    }
}
