package modx;

import java.util.ArrayList;
import util.TestUtils;
/**
 * Created by Mirshe on 12.03.2018.
 */
public class ModXStart {
    public static void main(String[] args) {
        TestUtils ese = new TestUtils();
        ArrayList<String> arr = new ArrayList<String>();
        //change file URL
        ese.leer("D:\\move_to_griz\\selenium\\src\\txts\\MigXImages.txt", arr);
        //insert URL
        ese.initialize("url");
        ese.pageLoaded();
        for (String anArr : arr) {
            //CODE HERE
        }
    }
}
