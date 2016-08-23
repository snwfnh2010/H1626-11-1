package test0820;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by snwfnh on 2016/8/20.
 */
public class ParserTools {
    private static ParserTools ourInstance = new ParserTools();

    public static ParserTools getInstance() {
        return ourInstance;
    }

    private ParserTools() {
    }
    private MyHandler mHander=new MyHandler();
    public List<Phone> pareXml(File file) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory=SAXParserFactory.newInstance();
        SAXParser parser=factory.newSAXParser();
        parser.parse(file,mHander);
        return mHander.getmList();
    }
}
