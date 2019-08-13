print("f")

from dataclasses import dataclass
import sys
import queue as queue


class _Getch:   #from http://code.activestate.com/recipes/134892/
    """Gets a single character from standard input.  Does not echo to the
screen."""
    def __init__(self):
        try:
            self.impl = _GetchWindows()
        except ImportError:
            self.impl = _GetchUnix()

    def __call__(self): return self.impl()


class _GetchUnix:
    def __init__(self):
        import tty, sys

    def __call__(self):
        import sys, tty, termios
        fd = sys.stdin.fileno()
        old_settings = termios.tcgetattr(fd)
        try:
            tty.setraw(sys.stdin.fileno())
            ch = sys.stdin.read(1)
        finally:
            termios.tcsetattr(fd, termios.TCSADRAIN, old_settings)
        return ch


class _GetchWindows:
    def __init__(self):
        import msvcrt

    def __call__(self):
        import msvcrt
        return msvcrt.getch()


getch = _Getch()

@dataclass
class Grid:
    death_time:int = -1
    cat_time:int  = -1
    sym:str
    seq:str
    visited:bool = False
    cat_visit:bool = False


@dataclass
class cell:
    row:int
    col:int
    time:int


############
# programma #

#read from file

#read from terminal

q = queue()
cat = queue()
solution = queue()



