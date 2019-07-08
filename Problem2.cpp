//
// Created by shazmaan on 7/8/2019.
//

#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

class StackNode{
public:
    int data;
    StackNode* next;
    int index;
};

StackNode* newNode(int data)
{
    StackNode* stackNode = new StackNode();
    stackNode->data = data;
    stackNode->next = NULL;
    stackNode->index = index;
    return stackNode;
}

int isEmpty(StackNode* root)
{
    if(root==NULL){
        return true;
    }
    return false;//Your code here
}

void push(StackNode** root, int data, int pos)
{
    StackNode* node = newNode(data);
    StackNode* temp = (*root);
    while(temp->index < pos  && temp->next != NULL){
        (temp) = (temp)->next;
    }
    node->next = temp;
    temp = node;
    //Your code here
}

int pop(StackNode** root)
{
    if(isEmpty((*root))){
        cout<<"Stack Underflow"<<endl;
        return 0;
    }
    StackNode* temp = (*root);
    (*root) = (*root)->next;
    int ret = temp->data;
    delete temp;
    return ret;
    //Your code here
}

int peek(StackNode* root)
{
    if(isEmpty(root)){
//        cout<<"Stack Underflow"<<endl;
        return 0;
    }
    return root->data;
    //Your code here
}
};

int main(){
    StackNode s;
    return 0;
}
