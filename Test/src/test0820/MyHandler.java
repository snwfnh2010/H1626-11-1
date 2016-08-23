package test0820;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by snwfnh on 2016/8/20.
 */
public class MyHandler extends DefaultHandler {
    private List<Phone> mList;
    private Phone mPhone;
    private StringBuilder mStringBuilder;

    public List<Phone> getmList() {
        return mList;
    }

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        mList=new ArrayList<>();
        mStringBuilder=new StringBuilder();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        if(qName.equals("result"))
             mPhone=new Phone();
        mStringBuilder.setLength(0);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        switch (qName){
            case "phone":
                mPhone.setPhone(mStringBuilder.toString());
                break;
            case "style_simcall":
                mPhone.setStyle_simcall(mStringBuilder.toString());
                break;
            case "result":
                mList.add(mPhone);
                break;
            default:
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        mStringBuilder.append(ch,start,length);
    }
}
