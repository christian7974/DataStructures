import Linked_List.LinkedList;

public class Main {

  public static void main(String[] args) {
    LinkedList list = new LinkedList(1, 2, 3, 5);
    System.out.println(list.getLength());
    list.insert(4, 3);
    System.out.println(list.getLength());
    list.printList();


    LinkedList list2 = new LinkedList();
    list2.push(4);
    System.out.println("The length is " + list2.getLength());
  }
}