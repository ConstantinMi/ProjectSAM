package run;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;

import javax.annotation.Resource;
import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Created by Claudiu on 2/27/2017.
 */
public class Input {

    @Value("classpath:arial.ttf")
    private File file;

    public static void main(String...args) throws URISyntaxException{
//        System.out.println(file);
        URL url = Input.class.getClassLoader().getResource("arial.ttf");
        String path = new File(url.toURI()).getAbsolutePath();
        System.out.println(path);
        new Input().print();
    }

    private void print() {
        System.out.println(file.exists());
    }
}
