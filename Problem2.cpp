#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

// StackNode 
class StackNode { 
    public:
        int data; 
        int priority; 
        StackNode* next; 
  
}; 
  
// Function to Create A New Node 
StackNode* newNode(int data, int priority) 
{ 
    StackNode* node = new StackNode();
    node->data = data;
    node->next = NULL;
    node->priority = priority;
    return node; 
} 
  
// Return the value at head 
int peek(StackNode** head) 
{ 
    return (*head)->data; 
} 
  
// Removes the element with the 
// highest priority form the list 
int pop(StackNode** head) 
{   
    StackNode* temp = *head; 
    (*head) = (*head)->next; 
    int popped = temp->data;
    delete temp;
    return popped; 
} 
  
// Function to push according to priority 
void push(StackNode** head, int data, int priority) 
{ 
    StackNode* start = (*head); 
  
    // Create new Node 
    StackNode* temp = newNode(data, priority); 
  
    // Special Case: The head of list has lesser 
    // priority than new node. So insert new 
    // node before head node and change head node. 
    if ((*head)->priority > priority) { 
  
        // Insert New Node before head 
        temp->next = *head; 
        (*head) = temp; 
    } 
    else { 
  
        // Traverse the list and find a 
        // position to insert new node 
        while (start->next != NULL && 
               start->next->priority < priority) { 
            start = start->next; 
        } 
  
        // Either at the ends of the list 
        // or at required position 
        temp->next = start->next; 
        start->next = temp; 
    } 
} 
  
// Function to check is list is empty 
int isEmpty(StackNode** head) 
{ 
    return (*head) == NULL; 
} 
  
// Driver code 
int main() 
{ 
    // Create a Priority Queue 
    // 7->4->5->6 
    StackNode* pq = newNode(4, 1); 
    push(&pq, 5, 2); 
    push(&pq, 6, 3); 
    push(&pq, 7, 0); 
  
    while (!isEmpty(&pq)) { 
        printf("%d ", peek(&pq)); 
        pop(&pq); 
    } 
  
    return 0; 
} 
