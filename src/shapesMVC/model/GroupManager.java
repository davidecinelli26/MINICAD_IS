package shapesMVC.model;

import java.util.HashMap;
import java.util.List;

public class GroupManager {
    private static GroupManager instance;
    private static int gId = 0;
    private HashMap<String, Group> groups;

    private GroupManager() {
        groups = new HashMap<>();
    }

    public static synchronized GroupManager getInstance() {
        if (instance == null) {
            instance = new GroupManager();
        }
        return instance;
    }

    public synchronized String createGroup(List<GraphicObject> objects) {
        String groupId = "grp" + gId;
        gId++;
        Group group = new Group(groupId, objects);
        groups.put(groupId, group);
        return groupId;
    }

    public Group getGroup(String id) {
        return groups.get(id);
    }

    public void removeGroup(String id) {
        groups.remove(id);
    }

    public HashMap<String, Group> getGroups() {
        return groups;
    }
}

