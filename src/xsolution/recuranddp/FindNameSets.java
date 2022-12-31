package xsolution.recuranddp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class FindNameSets {
    public static void main(String[] args) {
        Map<String , Integer> map = new HashMap<>();
        map.put("John", 10);
        map.put("Jon", 3);
        map.put("Davis", 2);
        map.put("Kari", 3);
        map.put("Johnny",11);
        map.put("Carlton", 8);
        map.put("Carleton", 2);
        map.put("Jonathan", 9);
        map.put("Carrie", 5);

        String[][] equipNames = {
                {"Jonathan","John"},
                {"Jon","Johnny"},
                {"Johnny","John"},
                {"Kari","Cari"},
                {"Carleton","Carlton"},
        };
        Map<String, NameSet> nameSetMap = initNodes(map);
        Map<String, NameSet> integratedNameSetMap = findNameSets(nameSetMap, equipNames);
        integratedNameSetMap.forEach((k,v)-> System.out.println(k + " : " + v));
    }

    static Map<String, NameSet> initNodes(Map<String, Integer> map){
        Map<String, NameSet> groups = new HashMap<>();
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            String name = entry.getKey();
            Integer frequency = entry.getValue();
            NameSet nameSet = new NameSet(name, frequency);
            groups.put(name, nameSet);
        }
        return groups;
    }
    static Map<String, NameSet> findNameSets(Map<String, NameSet> map, String[][] equipNames){
        Map<String , NameSet> result = new HashMap<>(map);

        for (int i = 0; i < equipNames[0].length; i++) {
            String name1 = equipNames[0][i];
            String name2 = equipNames[1][i];

            NameSet nameSet1 = map.get(name1);
            NameSet nameSet2 = map.get(name2);

            NameSet bigger = nameSet1.equipNames.size() >  nameSet2.equipNames.size() ? nameSet1 : nameSet2;
            NameSet smaller = bigger == nameSet1 ? nameSet2 : nameSet1;
            bigger.integrateNames(smaller);
            result.put(bigger.rootName, bigger);
            }
        return result;
        }
    }


class NameSet {
    String rootName;
    Set<String> equipNames = new HashSet<>();
    Integer frequency;

    public NameSet(String rootName, Set<String> equipNames, Integer frequency) {
        this.rootName = rootName;
        this.equipNames = equipNames;
        this.frequency = frequency;
    }
    public NameSet(String rootName, Integer frequency) {
        this.rootName = rootName;
        equipNames.add(rootName);
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return "NameSet{" +
                "rootName='" + rootName + '\'' +
                ", equipNames=" + equipNames +
                ", frequency=" + frequency +
                '}';
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
