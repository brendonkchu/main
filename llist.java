import java.util.*;
public class llist{
  Node head;
  Node tail;
  
  static class Node{ 
    int value; //current node
    Node next,prev,doub; //node pointers
    Node(int x){//Constructor
      value=x;
      next=prev=doub=null;}}
  
  public static void main(String[] args){
    llist list = new llist();
    /*list.head=new Node(1);
    Node second=new Node(2);//initiallizes 2nd and 3rd pointers
    Node third=new Node(3);
    list.head.next=second;//assigns the next pointer of head to second
    second.next=third;//assigns the next point of second to third
    third.prev=second;
    second.prev=list.head;*/
    list.append(1);
    list.append(2);
    list.append(3);
    list.append(5);
    
    list.printList(); //calls function to print list
    //System.out.println(list.head.value); //prints head value
    //System.out.println(list.head.next.next.value); //prints 3rd value in list
    list.push(0);
    list.insert(list.head.next.next,7);
    list.printList();
    System.out.println(list.doub(2).value);
    list.del(list.tail.prev);
    //list.circle();
    list.traversal();
  }
 
  public void printList(){
    Node i=head; //confused on why head can only be used here with using list.head
    while(i!=null){
      System.out.print(i.value + " ");
      i=i.next;}
    System.out.println();}
  
  /*public static void append(llist list, int j){//Method of llist to append
    Node nnode= new Node(j);//creates new end node
    nnode.next=null;//initializes
    if(list.head==null){//if no head
      list.head=nnode;
    }else{
      Node last=list.head;
      while(last.next != null){//moves down list to find the last node
        last=last.next;
      }last.next=nnode;}}*/ //Assigns j value to new node at end of list
  
  public void append(int j){//Method of llist to append
    Node nnode=new Node(j);//creates new end node
    if(head==null){//if no head, create head
      nnode.prev=null;
      head=tail=nnode;
      return;
    }nnode.next=null;//initializes
    Node last=head;
    while(last.next!=null){//moves down list to find the last node
      last=last.next;//Assigns j value to new node at end of list
    }last.next=nnode;
    nnode.prev=last;
    tail=nnode;}
  
  /*public static void push(llist list, int k){ //adds new head and pushes down all values
    Node nnode=new Node(k);
    nnode.next=list.head;
    list.head=nnode;}*/
  
  public void push(int k){//adds new head and pushes down all values
    Node nnode=new Node(k);
    nnode.next=head;
    nnode.prev=null;
    if(head!=null){
    head.prev=nnode;}
    head=nnode;}
  
  public void insert(Node pnode, int m){
    if(pnode==null){
      System.out.println("error no pnode");
      return;
    }Node nnode= new Node(m);
    nnode.next=pnode.next;
    pnode.next=nnode;
    nnode.prev=pnode;
    if(nnode.next!=null){
     nnode.next.prev=nnode;}}
        
  public void circle(){
    tail.next=head;
    head.prev=tail;
  }
  
  public void del(Node del){
    if(head==null||del==null){
      return;
    }if(head==del){
      head=del.next;
    }if(del.next!=null){
      del.next.prev=del.prev;
    }if(del.prev!=null){
      del.prev.next=del.next;
    }return;}
  
  public void traversal(){
   Node i=head; //confused on why head can only be used here with using list.head
   while(i!=null){
     System.out.print(i.value + " ");
     i=i.next;}
   System.out.println();
   i=tail;
   while(i!=null){
     System.out.print(i.value + " ");
     i=i.prev;}
  System.out.println();}
  
  public Node searchNode(int n){
    Node nnode=new Node(0);
    nnode.value=n;
    nnode.prev=nnode.next=null;
    return nnode;
  }
  
  public Node doub(int o){//number of skips
    Node nnode=head;
    for(int x=0;x<o;x++){
      nnode=nnode.next.next;
    }return nnode;}
    
  /*public static llist append(llist list, int value){ //constructor with append function
    Node nnode = new Node(value);
    nnode.next=null;
    if(list.head == null){ //if no elements add first node
      list.head=nnode;
    }else{ //else add new node at end of line
      Node last = list.head; //saves old head
      while(last.next !=null){
        last = last.next;
      }last.next=nnode;
    }return list;
  }public static llist prepend(llist list, int value){
    Node nnode = new Node(value);
    nnode.prev=null;
    return list;
  }*/
}
  