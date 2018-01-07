package trungbanh.com.demo_mvp.Push;

import trungbanh.com.demo_mvp.Main.ListItem;
import trungbanh.com.demo_mvp.Main.ItemObject;

/**
 * Created by banhtrung on 1/6/2018.
 */

public class Presenter_Pushstatus implements PushContract {

    ItemObject itemObject;
    public Presenter_Pushstatus() {
        itemObject = new ItemObject();
    }

    public boolean isStatusNull(String status) {
        return status.equals("");
    }

    public void Pusher(String Status) {
        itemObject.setStatus(Status);
        addToList();
    }
    private void addToList () {
        ListItem.getInstance().itemObjects.add(0,this.itemObject);
    }
}
