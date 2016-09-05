package beanmapper.mapstruct;

/**
 * Created by yhw on 08/17/2016.
 */
public class CarDto {
    public String manufacturer;
    public String seatCount;
    public String name;

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(String seatCount) {
        this.seatCount = seatCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
