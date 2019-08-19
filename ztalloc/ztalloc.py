import sys

def bfs(l_in, r_in, r_out, l_out):
    level = dict()
    parent = dict()
    level[(l_in, r_in)] = 0
    parent[(l_in, r_in)] = -1
    frontier = [(l_in, r_in)]
    i = 1
    while frontier:
        next = []
        for u in frontier:
            if (u[0]//2, u[1]//2) not in level:
                level[(u[0]//2, u[1]//2)] = i
                parent[(u[0]//2, u[1]//2)] = u
                next.append((u[0]//2, u[1]//2))
                if (u[0]//2 >= l_out and u[0]//2 <= r_out and
                    u[1]//2 >= l_out and u[1]//2 <= r_out):
                    return parent, level, (u[0]//2, u[1]//2)
            if (u[0]*3+1, u[1]*3+1) not in level and u[1]*3+1 <= 1000000:
                level[(u[0]*3+1, u[1]*3+1)] = i
                parent[(u[0]*3+1, u[1]*3+1)] = u
                next.append((3*u[0]+1, 3*u[1]+1))
                if (u[0]*3+1 >= l_out and u[0]*3+1 <= r_out and
                    u[1]*3+1 >= l_out and u[1]*3+1 <= r_out):
                    return parent, level, (3*u[0]+1, 3*u[1]+1)
        frontier = list(next)
        i += 1
    print('IMPOSSIBLE')
    return [], [], -1

import sys
filename = sys.argv[1]
f = open(filename, "r")
Q = int(f.readline())
for _ in range(Q):
    l_in, r_in, l_out, r_out = [int(x) for x in f.readline().split()]
    if not (r_out < l_in and l_out < l_in or r_out > r_in and l_out > r_in) :
        print('EMPTY')
        continue
    parent, level, target = bfs(l_in, r_in, r_out, l_out)
    if parent != []:
        c = target
        answer = ''
        while(parent[c] != -1):
            if parent[c] > c:
                answer = 'h' + answer
                c = parent[c]
            else:
                answer = 't' + answer
                c = parent[c]
        print(answer)
