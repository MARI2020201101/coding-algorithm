package perfectcoding.tree;

import java.time.LocalDateTime;

class Airplane {
    AirPlaneNode head;

    public AirPlaneNode insert(AirPlaneNode node, LocalDateTime element, Integer time){
        if(node == null){
            return new AirPlaneNode(element,time, null, null);
        }
        else if(element.plusMinutes(time).isBefore(node.element)){
            node.left = insert(node.left, element, time);
        }else if(element.isAfter(node.element.plusMinutes(node.time))){
            node.right = insert(node.right, element, time);
        }
        return null;
    }

}
class AirPlaneNode {
    LocalDateTime element;
    Integer time;
    AirPlaneNode left;
    AirPlaneNode right;

    public AirPlaneNode(LocalDateTime element,Integer time, AirPlaneNode left, AirPlaneNode right) {
        this.element = element;
        this.time = time;
        this.left = left;
        this.right = right;
    }
}