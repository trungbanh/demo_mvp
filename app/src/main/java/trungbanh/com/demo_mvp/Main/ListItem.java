package trungbanh.com.demo_mvp.Main;

import java.util.ArrayList;

import trungbanh.com.demo_mvp.R;

/**
 * Created by banhtrung on 1/6/2018.
 */

public class ListItem {
    private static final ListItem ourInstance = new ListItem();
    public ArrayList<ItemObject> itemObjects;

    public static ListItem getInstance() {
        return ourInstance;
    }

    private ListItem() {
        itemObjects = new ArrayList<>();
        itemObjects.add(new ItemObject(R.drawable.a,"phúc huy","buồn quá đi"));
        itemObjects.add(new ItemObject(R.drawable.a,"yon nguyễn","muốn nuôi mèo"));
        itemObjects.add(new ItemObject(R.drawable.a,"minh tâm","hôm nay tôi cô đơn quá"));
        itemObjects.add(new ItemObject(R.drawable.a,"phương thảo","happy new year" ));
        itemObjects.add(new ItemObject(R.drawable.a,"đứa nào đó","thả tim chúc ngủ ngon nàkk" ));
        itemObjects.add(new ItemObject(R.drawable.a,"yon nguyễn","bạn dành cả thanh xuân làm gì" ));
        itemObjects.add(new ItemObject(R.drawable.a,"trung bành","con muốn cưới cô ấy làm vợ" ));

    }
}
