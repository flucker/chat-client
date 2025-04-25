package academy.prog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JsonMessages {
    private final List<Message> list = new ArrayList<>();

    public JsonMessages(List<Message> sourceList, int fromIndex, String fromLogin, String toLogin) {
        for (int i = fromIndex; i < sourceList.size(); i++) {
            Message msg = sourceList.get(i);
            if (msg.getFrom().equals(fromLogin) && msg.getTo().equals(toLogin)) {
                list.add(sourceList.get(i));
            }
        }
    }

    public List<Message> getList() {
        return Collections.unmodifiableList(list);
    }
}
