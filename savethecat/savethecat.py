import sys
from queue import Queue

#declarations
grid = []
data





#read from file
with open(sys.argv[1], 'r') as infile:
    grid = infile.readlines()

grid = [list(line.strip('\n')) for line in grid]
N, M = len(grid), len(grid[0])


q = Queue()
cat = Queue()
solutions = Queue()


