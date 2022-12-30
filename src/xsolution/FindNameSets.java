package xsolution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class FindNameSets {
    Map<String , NameSet> map = new HashMap<>();
    String[][] equipNames = {};
    static Map<String, NameSet> findNameSets(Map<String, NameSet> map, String[][] equipNames){
        Map<String , NameSet> result = new HashMap<>();
        for (int i = 0; i < equipNames.length; i++) {
            String name1 = equipNames[i][0];
            String name2 = equipNames[i][1];

            NameSet nameSet1 = map.get(name1);
            NameSet nameSet2 = map.get(name2);

            NameSet bigger = nameSet1.equipNames.size() >  nameSet2.equipNames.size() ? nameSet1 : nameSet2;
            NameSet smaller = bigger == nameSet1 ? nameSet2 : nameSet1;
            bigger.integrateNames(smaller);

        }
        }
    }
}

class NameSet {
    String rootName;
    Set<NameSet> equipNames = new HashSet<>();
    Integer frequency;

    public NameSet(String rootName, Set<NameSet> equipNames, Integer frequency) {
        this.rootName = rootName;
        this.equipNames = equipNames;
        this.frequency = frequency;
    }

    public NameSet integrateNames(NameSet smaller){
        this.frequency += smaller.frequency;
        equipNames.addAll(smaller.equipNames);
        return this;
    }
    public void acceptNames(NameSet bigger){
        this.equipNames = bigger.equipNames;
    }
}
