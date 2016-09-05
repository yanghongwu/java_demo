package beanmapper.dozer;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

/**
 * Created by yhw on 08/17/2016.
 */
public class TargetBean {
    private String pk;

    private String name;

    private String binaryData;

    public void setPk(String pk) {
        this.pk = pk;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Mapper mapper = new DozerBeanMapper();

        SourceBean sourceBean = new SourceBean();
        sourceBean.setId(11l);
        sourceBean.setData("source-data");
        sourceBean.setName("source-name");
        TargetBean destObject = mapper.map(sourceBean, TargetBean.class);
        System.out.println(destObject);
    }
}
