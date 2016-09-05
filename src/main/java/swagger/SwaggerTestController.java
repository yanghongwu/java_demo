package swagger;

import com.mangofactory.swagger.controllers.DefaultSwaggerController;
import com.mangofactory.swagger.models.dto.ResourceListing;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by yhw on 09/05/2016.
 */
@Controller
@RequestMapping("/swg")
public class SwaggerTestController extends DefaultSwaggerController {

    public SwaggerTestController() {
        super();
    }

    @RequestMapping(value = "a.qunar")
    public
    @ResponseBody
    ResponseEntity<ResourceListing> getResourceListing(
            @RequestParam(value = "group",  required = false) String swaggerGroup) {

        return super.getResourceListing(swaggerGroup);
    }

}
