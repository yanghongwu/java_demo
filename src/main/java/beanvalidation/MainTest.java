package beanvalidation;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Date;
import java.util.Set;

/**
 * Created by yhw on 08/26/2016.
 */
public class MainTest {

    public static void main(String[] args) {
        Order order = new Order();
        order.setOrderId("11");
        order.setCustomer("test");
        order.setEmail("test@qunar.com");
        order.setAddress("beijing");
        order.setStatus("1");
        order.setCreateDate(new Date());
        Product product = new Product();
        product.setProductName("产品名称");
        product.setPrice(8100.1f);
        product.setPrice1("sdf");
        order.setProduct(product);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Order>> violations = validator.validate(order);
        if (violations.size() == 0) {
        }

    }
}
