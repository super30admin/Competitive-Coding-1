"""
Problem: Hackerland Radio Transmitters
--------------------------------------

Hackerland is a one-dimensional city with houses located at integer positions along a road.
The Mayor wants to install radio transmitters on the roofs of some houses.  
Each transmitter has a fixed range `k`, meaning it can transmit signals to all houses
within `k` units distance (to both the left and right).

Goal:
-----
Determine the **minimum number of transmitters** required so that every house is
within range of at least one transmitter.  
Each transmitter must be installed **on top of an existing house**.

---

Function Description:
---------------------
def hackerlandRadioTransmitters(x: List[int], k: int) -> int

Parameters:
- x (List[int]): the locations of houses along the road.
- k (int): the effective transmission range of each transmitter.

Returns:
- int: the minimum number of transmitters required to cover all houses.

---

Input Format:
-------------
- The first line contains two space-separated integers:
  - n: the number of houses in Hackerland.
  - k: the range of each transmitter.
- The second line contains n space-separated integers describing house locations.

---

Output Format:
--------------
Print a single integer — the minimum number of transmitters needed.

---

Constraints:
------------
- 1 ≤ n ≤ 10^5
- 1 ≤ k ≤ 10^4
- 1 ≤ x[i] ≤ 10^5
- There may be more than one house at the same location.

---

Subtasks:
---------
For 30% of the maximum score:
- n ≤ 1000

---

Examples:
----------
Sample Input 0:
---------------
5 1
1 2 3 4 5

Sample Output 0:
----------------
2

Explanation 0:
--------------
We can cover all houses by installing transmitters at locations 2 and 4.
Coverage:
- Transmitter at 2 → covers houses [1, 2, 3]
- Transmitter at 4 → covers houses [3, 4, 5]

---

Sample Input 1:
---------------
8 2
7 2 4 6 5 9 12 11

Sample Output 1:
----------------
3

Explanation 1:
--------------
We can install transmitters at locations 4, 9, and 12.
Coverage:
- Transmitter at 4 → covers houses [2, 3, 4, 5, 6]
- Transmitter at 9 → covers houses [7, 8, 9, 10, 11]
- Transmitter at 12 → covers houses [10, 11, 12, 13, 14]
"""
#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'hackerlandRadioTransmitters' function below.
#
# The function is expected to return an INTEGER.
# The function accepts following parameters:
#  1. INTEGER_ARRAY x
#  2. INTEGER k
#

def hackerlandRadioTransmitters(x, k):
    lenX = len(x)
    if lenX < 1:
        return 0
    # First we need to sort all the houses in x, so that we know that the houses are being read in sequence.
    x.sort()
    
    # Now that we have all houses in sequence, we know that we can check if a given house if there are antenas places, how many houses it can cover.
    # For this we can assume that we place the antena at the first house. This means it will cover next k houses.
    # So we move to the next house which will be the last one to recieve signal, if antena places at the first house.
    # This also means that if the antena is places at this last house, the first house on the left will recieve the signal. So instead of placing the antena at the first house, we place it at the current house. This gives us an advantage that we can use this to calculate which is the next house the antena can be placed and which houses current antena will cover.
    currHouse = 0
    count = 0
    while currHouse < lenX:
        # Find the place where we can place the antena
        tillWeCanPlace = x[currHouse] + k
        while currHouse < lenX and x[currHouse] <= tillWeCanPlace:
            currHouse += 1
        # At this point the curr is at a house where if we placed the antena the first house will not get signal.
        # So we just move our curr to one house earlier
        currHouse -= 1
        
        # We can safely place an antena here, becase we know that the houses on the left will all recieve signal
        count += 1
        
        # Now that we have placed the antena check for all the houses that this antena will give signal till on the right side
        tillWeCanPlace = x[currHouse] + k
        while currHouse < lenX and x[currHouse] <= tillWeCanPlace:
            currHouse += 1
        # Now curr is at a place where there is no signal. So we continue in the while loop and find the next place where we can place the antena. This is a greedy way of solving the problem.
        
    return count

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    first_multiple_input = input().rstrip().split()

    n = int(first_multiple_input[0])

    k = int(first_multiple_input[1])

    x = list(map(int, input().rstrip().split()))

    result = hackerlandRadioTransmitters(x, k)

    fptr.write(str(result) + '\n')

    fptr.close()
