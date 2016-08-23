package test0820;

/**
 * Created by snwfnh on 2016/8/20.
 */
public class Phone {
    private String phone;
    private String style_simcall;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStyle_simcall() {
        return style_simcall;
    }

    public void setStyle_simcall(String style_simcall) {
        this.style_simcall = style_simcall;
    }

    public Phone() {
    }

    public Phone(String phone, String style_simcall) {
        this.phone = phone;
        this.style_simcall = style_simcall;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "phone='" + phone + '\'' +
                ", style_simcall='" + style_simcall + '\'' +
                '}';
    }
}
