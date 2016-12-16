import org.junit.Before;

/**
 * Created by graf on 28.11.2016.
 */
public class MyImplementationALTest extends AbstractMyImplementationListTest {

    @Before
    public void setUp(){
        sal = new MyImplementationArrayList();
    }
}
