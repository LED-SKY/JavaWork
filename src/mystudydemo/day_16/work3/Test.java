package mystudydemo.day_16.work3;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @program: Stage1
 * @description:
 * @author: 邓造坚
 * @create: 2021-06-28 00:28
 **/
public class Test {
    public static void main(String[] args) throws IOException {
        String[] words = {"verb:eat","verb:drink","verb:sleep","verb:play","noun:rice","noun:meat","noun:hand","noun:hair"};
        FileOutputStream verbTxt = new FileOutputStream("G:\\BaiduDownload\\TestDir\\TestDirClone\\verb.txt");
        FileOutputStream nounTxt = new FileOutputStream("G:\\BaiduDownload\\TestDir\\TestDirClone\\noun.txt");
        for (String word : words) {
            if (word.startsWith("verb")){
                verbTxt.write(word.getBytes());
                verbTxt.write("\n".getBytes());
            }else {
                nounTxt.write(word.getBytes());
                nounTxt.write("\n".getBytes());   
            }


        }
    }
}
