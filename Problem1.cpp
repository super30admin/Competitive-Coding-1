//Provide an array of n-1 integers in the range of 1 to n with no duplicates in list, One of the integers is missing in the list. Write a code to find the missing integer.

#include <iostream>
#include <vector>
using namespace std;

int missingnumber(vector<int>& arr) {
int start = 0;
int end = arr.size() – 1;
while(start <= end) {
int mid = start + (end – start)/2;
if (arr[mid] – mid == 1) {
start = mid + 1;
}
else {
end = mid - 1;
}}
return start + 1;
}

