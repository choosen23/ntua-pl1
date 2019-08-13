import sys


grid = []
depth = {}
griddeathTime = [] #-1 int
gridcatTime = []    #-1 int
gridSymbol = []
gridSeq = []
gridVisited = [] # 0 false
gridcatVisited = [] #0 balse


with open(sys.argv[1], 'r') as infile:
    grid = infile.readlines()

grid = [(list(line.strip('\n'))) for line in grid]
N, M = len(grid), len(grid[0])

#other grid initializations
griddeathTime = [[-1 for i in range(M)] for j in range(N)] 
gridcatTime = [[-1 for i in range(M)] for j in range(N)] 
gridSymbol = [[' ' for i in range(M)] for j in range(N)] 
gridSeq = [[' ' for i in range(M)] for j in range(N)] 
gridVisited = [[False for i in range(M)] for j in range(N)] 
gridcatVisited = [[False for i in range(M)] for j in range(N)] 


print(grid,N,M)

import queue

q = queue.Queue()
cat = queue.Queue()
solutions = queue.Queue()





for i in range(N):
    for j in range(M):
        if grid[i][j] == 'X':
            gridSymbol[i][j] = 'X'
        elif grid[i][j] == 'W':
            q.put((i,j,0))
            gridcatTime[i][j] = 0
            gridVisited = True

        elif grid[i][j] == 'A':
            gridSymbol[i][j] = '.'
            gridcatTime[i][j] = 0
            gridSeq[i][j] = 's'
            gridcatVisited = True
            cat.put((i,j,0))

maxTime = 0
while (not(q.empty())):
    print("haha")
    take = q.get()
    maxTime = take[2]
    print(maxTime)
    if take[0] > 0 and gridSymbol[take[0]-1][take[1]] == '.' and not(gridVisited[take[0]-1][take[1]]):
        griddeathTime[take[0]-1][take[1]] = take[2]+1
        gridVisited[take[0]-1][take[1]] = True
        q.put((take[0]-1,take[1],take[2]+1))
    
    elif take[0] < N-1 and gridSymbol[take[0]+1][take[1]] and not gridVisited[rake[0] +1][take[1]] :
        griddeathTime[take[0] +1][take[1]] = take[2] + 1
        gridVisited[take[0] +1][take[1]] = True
        q.put((take[0]+1,take[1],take[2]+1))

    elif take[1] > 0 and gridSymbol[take[0]][take[1] -1] and not gridVisited[take[0]][take[1] -1]:
        griddeathTime[take[0]][take[1] -1] = take[2] -1
        gridVisited[take[0]][take[1] -1] = True
        q.put((take[0],take[1] -1,take[2] +1))

    elif take[1] < M-1 and gridSymbol[take[0]][take[1] +1] and not gridVisited[take[0]][take[1] +1]:
            griddeathTime[take[0]][take[1] +1] = take[2] +1
            gridVisited[take[0]][take[1] +1] = True
            q.put((take[0],take[1] +1,take[2] +1))    

while (not(cat.empty())):  
    break  
    print("Hm")
    take = cat.get()
    

    if take[0] < N-1 and gridSymbol[take[0]+1][take[1]] == '.' and not gridcatVisited[take[0]+1][take[1]] :
        gridcatTime[take[0]+1][take[1]] = take[2] + 1
        gridcatVisited[take[0]+1][take[1]] = True
        gridSeq[take[0]+1][take[1]] = gridSeq[take[0]][take[1]]+'D' 
        cat.put((take[0] + 1,take[1],take[2]+1)
    
    elif take[1] > 0 and gridSymbol[take[0]][take[1] -1] == '.' and not gridcatVisited[take[0]][take[1] -1] :
        gridcatTime[take[0]][take[1] -1] = take[2] + 1
        gridcatVisited[take[0]][take[1] -1] = True
        gridSeq[take[0]][take[1] -1] =  gridSymbol[take[0]][take[1]] + 'L'
        cat.put((take[0],take[1] -1,take[2]+1))
    
    elif take[1] < M-1 and gridSymbol[take[0]][take[1] + 1] == '.' and not gridVisited[take[0][take[1] +1] :
        gridcatTime[take[0]][take[1] + 1] = take[2] + 1
        gridcatVisited[take[0]][take[1] + 1] = True
        gridSeq[take[0]][take[1] + 1] = gridSeq[take[0]][take[1] + 'R'
        cat.put((take[0],take[1] +1,take[2]+1))


     elif take[0] > 0 and gridSymbol[take[0] -1][take[1]] == '.' and not gridcatVisited[take[0] -1][take[1]] :
        gridcatTime[take[0] -1][take[1]] = take[2] + 1
        gridcatVisited[take[0] -1][take[1]] = True
        gridSeq[take[0] -1][take[1]] = gridSeq[take[0]][take[1]]+'D' 
        cat.put((take[0] - 1,take[1],take[2]+1))   


for i in range(N):
    for j in range(M):
        if gridcatTime[i][j] >= 0:
            if gridcatTime[i][j] < griddeathTime[i][j] and griddeathTime[i][j] <= maxTime:
                solutions.put(i,j,griddeathTime[i][j] -1)
            elif griddeathTime[i][j] == -1 :
                solutions.put(i,j,-1)

best = solutions.get()

while not solutions.empty():
    tmp = solutions.get()
    if tmp[2] == best[2]:
        if tmp[0] < best[0]:
            best = tmp
        elif tmp[0] == best[0]:
            if tmp[1] < best[1]:
                best = a
    elif tmp[2] > best[2]:
        best = tmp

if best[2] == -1: print('infinity')
elif print(best[2])
if gridSeq[best[0]][best[1]] == 's': print('stay')
else: print(gridSeq[best[0]][best[1]]) #kati exei me erase..Na to dw kapia stigmi






