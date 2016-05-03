package demo.com.getmyphonenumber;

/**
 * Created by dell on 2016/5/3.
 */
public class phoneInfo  {

    private String name;
    private String number;


    public phoneInfo(String name,String number){
        setName(name);
        setNumber(number);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
