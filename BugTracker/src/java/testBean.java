import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@Named(value = "testBean")
@RequestScoped
public class testBean {

    public testBean() {
    }
    
}
