import Linked_List.LinkedList;

public class Main {

  public static void main(String[] args) {
    LinkedList list = new LinkedList(1, 2, 3, 4);

    int valueToFind = 5;
    System.out.println(list.deleteValue(2) ? 2 + " deleted" : 2 + " Not deleted");

    list.printList();

    LinkedList list2 = new LinkedList();
    System.out.println(list2.search(valueToFind) ? valueToFind + " Found" : valueToFind + " Not Found");
  }
}