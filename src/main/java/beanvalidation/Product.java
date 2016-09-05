package beanvalidation;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by yhw on 08/26/2016.
 */
@Data
public class Product {
    // 必须非空
    @NotEmpty
    private String productName;
    // 必须在 8000 至 10000 的范围内
    // @Price 是一个定制化的 constraint
    @Price
    private float price;

    @Price1
    private String price1;

}