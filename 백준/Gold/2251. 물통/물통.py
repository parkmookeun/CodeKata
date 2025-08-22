# 2251 물통
import sys
from collections import deque

input = sys.stdin.readline

A, B, C = map(int,input().split())
size = [A,B,C]
result = set()
visited = [[[False]*201 for i in range(201)] for j in range(201)]

def bfs(start, visited):
    q = deque([start])
    while q:
        elem = q.popleft()
        if elem[0] == 0:
            result.add(elem[2])
        for i in range(3):
            l = [0,0,0]
            min_value = min(elem[i], size[(i+1) % 3]-elem[(i+1) % 3])
            l[i] = elem[i] - min_value
            l[(i+1) % 3] = elem[(i+1) % 3] + min_value
            l[(i+2) % 3] = elem[(i+2) % 3]
            if not visited[l[0]][l[1]][l[2]]:
                q.append(l)
                visited[l[0]][l[1]][l[2]] = True

    return result


ll = bfs([0,0,C],visited)
ll = list(ll)
ll.sort()
for v in ll:
    print(v, end=' ')