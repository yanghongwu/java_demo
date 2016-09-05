package beanmapper.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * Created by yhw on 08/17/2016.
 */

//@Mapper
public interface CarMapper {

//    public static CarMapper mapper = Mappers.getMapper( CarMapper.class );
//
//    @Mappings({
//            @Mapping(source = "make", target = "manufacturer"),
//            @Mapping(source = "numberOfSeats", target = "seatCount")
//    })
//    CarDto carToCarDto(Car car);

    public static void main(String[] args) {
//        Car car = new Car();
//        car.setName("carName");
//        car.setMake("car  make");
//        car.setNumberOfSeats("car number of seat");
//        CarDto carDato = CarMapper.mapper.carToCarDto(car);
//        System.out.println(carDato);

        System.out.println(System.getProperty("java.library.path"));
    }


}
