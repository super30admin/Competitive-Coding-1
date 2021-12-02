#include <iostream>
using namespace std;
//Time complexity --> For Push--> O(n), For POP, PEEK --> O(1)
// Space complexity --> O(n)

class PriorityQue{

    class Node{
    public:
        int val;
        int priority;
        Node * next;
        Node(int val,int priority){
            this->val = val;
            this->priority = priority;
            this->next = NULL;
        }
    };
public :
    Node * head = NULL;
    void push(int val, int priority){
        Node * current = head;
        Node * temp = new Node(val,priority);
        if(head == NULL){
            head = temp;
            return;
        }
        if(head->priority > temp->priority){
            temp->next = current;
            head = temp;
            return;
        }
        while(current->next != NULL && current->next->priority < temp->priority){
            current = current->next;
        }
        temp->next = current->next;
        current->next = temp;
        return;
    }
    void pop(){
        if(head == NULL){
            return ;
        }
        Node * temp = head;
        head = temp->next;
        temp->next = NULL;
    }
    int peek(){
        if(head == NULL){
            return -1;
        }
        return head->val;
    }
};

int main(){
    PriorityQue pq;
    pq.push(4,1);
    pq.push(5,2);
    pq.push(6,3);
    pq.push(7,0);

    while (pq.head != NULL)
    {
        cout << " " << pq.peek();
        pq.pop();
    }
    return 0;
}
