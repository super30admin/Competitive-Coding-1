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

StackNode* newNode(int data, int index)
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
    StackNode* node = newNode(data,pos);
    StackNode* temp = (*root);
    if(temp==NULL || temp->index>pos){
        node->next = (*root);
        (*root) = node;
    }else{
        while(temp->next != NULL && temp->next->index < pos){
            (temp) = (temp)->next;
//            cout<<temp->data<<" temp data\n";
        }
        node->next = temp->next;
        temp->next = node;
//        cout<<node->data<<" node data\n";
    }
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
        cout<<"Stack Underflow"<<endl;
        return 0;
    }
    return root->data;
    //Your code here
}

int main(){
    StackNode* root = NULL;

    push(&root, 10,1);
    push(&root, 20,2);
    push(&root, 40,4);
    push(&root, 30,3);

    cout<<pop(&root)<<endl;
    cout<<pop(&root)<<endl;
    cout<<pop(&root)<<endl;

    return 0;
}
