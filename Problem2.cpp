#include <iostream>
#include <vector>

using namespace std;

class MinHeap{
    class Node{
    public:
        int val;
        Node* next;

        Node(int newVal)
        {
            this->val = newVal;
            this->next = nullptr;
        }
    };

    Node* head;
    public:

    //Time complexity : O(1)
    //Space complexity : O(1)
    //Approach : Pop the head element and delete the node

    int pop()
    {
        if(!empty())
        {
            int temp = head->val;
            Node* to_delete = head;
            head = head->next;
            return temp;
        }

        return INT_MIN;
    }

    //Time Complexity : O(n)
    //Space Complexity : O(n)
    //Approach : 
    //          Insert node such that priority of its previous node is lesser and next node is greater.
    void push(int new_num)
    {
        Node* newNode = new Node(new_num);

        //If list is empty
        if(empty())
        {
            head = newNode;
            return;
        }

        if(newNode->val < head->val)
        {
            newNode->next = head;
            head = newNode;
            return;
        }

        Node* currentNode = head;

        while((currentNode->next != nullptr) && (currentNode->next->val < newNode->val))
        {
            currentNode = currentNode->next;
        }

        newNode->next = currentNode->next;
        currentNode->next = newNode;
    }

    int peek()
    {
        if(!empty())
        {
            return head->val; 
        }
    }

    bool empty()
    {
        if(head == nullptr)
        {
            return true;
        }
        return false;
    }
};

int main()
{
    MinHeap mh;

    mh.push(3);
    mh.push(4);
    mh.push(2);
    mh.push(6);
    mh.push(7);
    mh.push(5);
    mh.push(1);

    while(!mh.empty())
    {
        cout << mh.pop() << endl;
    }

    return 0;
}