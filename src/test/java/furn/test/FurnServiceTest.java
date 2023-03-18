package furn.test;

import com.andre.furn.bean.Furn;
import com.andre.furn.bean.Msg;
import com.andre.furn.service.FurnService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Andre Wang
 * @version 1.0
 */
public class FurnServiceTest {

    private ApplicationContext ioc;

    private FurnService furnService;

    @Before
    public void init() {
        ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        furnService = ioc.getBean(FurnService.class);
    }

    @Test
    public void save() {
        Furn furn =
                new Furn(null, "Chair", "Smith", new BigDecimal(180), 20,
                        70, "assets/images/product-image/1.jpg");

        furnService.save(furn);
        furnService.save(furn);
        Msg success = Msg.success();
        System.out.println("save okay!");
    }

     @Test
    public void findAll() {
         List<Furn> furns = furnService.findAll();
         for (Furn furn : furns) {
             System.out.println(furn);
         }

     }

     @Test
    public void delete(){
        furnService.del(23);
         System.out.println("delete okay!");
     }
}
