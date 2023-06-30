// Узел связанного списка
class Node
{
    int data;
    Node next;
 
    Node(int data)
    {
        this.data = data;
        this.next = null;
    }
}
 
class main
{
    // Вспомогательная функция для печати заданного связанного списка
    public static void printList(Node head)
    {
        Node ptr = head;
        while (ptr != null)
        {
            System.out.print(ptr.data + " —> ");
            ptr = ptr.next;
        }
 
        System.out.println("null");
    }
 
    // Наивная функция для реализации связанного списка, содержащего три узла
    public static Node constructList()
    {
        // строим узлы связанного списка
        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
 
        // переставляем ссылки для создания списка
        Node head = first;
        first.next = second;
        second.next = third;
        third.next = fourth;
 
        // возвращаем ссылку на первый узел в списке
        return head;
    }
 
    public static void main(String[] args)
    {
        // `head` указывает на головной узел связанного списка
        Node head = constructList();
 
        // распечатать связанный список
        printList(head);
    }
}