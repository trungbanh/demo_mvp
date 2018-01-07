package trungbanh.com.demo_mvp.Main;

/**
 * Created by banhtrung on 1/5/2018.
 */

public class ItemObject {
    private int avata ;
    private String name ;
    private String status ;
    private Boolean isLike = false ;
    public ItemObject(){
        this.avata = 0;
        this.name = "trung banh" ;
        this.status = "" ;
    }

    public ItemObject(int avata, String name, String status) {
        this.avata = avata;
        this.name = name ;
        this.status = status ;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getAvata() {
        return avata;
    }

    public void setAvata(int avata) {
        this.avata = avata;
    }

    public Boolean getLike() {
        return isLike;
    }

    public void setLike(Boolean like) {
        isLike = like;
    }
}
