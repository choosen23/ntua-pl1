<<<<<<< HEAD
<<<<<<< HEAD

%prolog scripts runs as: consult('test.pl').

parent(john, nick). parent(john, ann). parent(helen, nick).
parent(helen, ann). parent(nick, mary). parent(nick, bill).
parent(margaret, mary). parent(margaret, bill). parent(mary, george).
parent(mary, jack). parent(mary, alice). parent(bill, peter).
parent(chris, paul). parent(ann, paul). parent(paul, sophie).

grandparent(X, Z) :- parent(X, Y), parent(Y, Z).

male(john). male(nick).
male(bill). male(george).
male(jack). male(peter).
male(chris). male(paul).
female(helen). female(margaret).
female(mary). female(alice).
female(ann). female(sophie).


father(X, Y) :- male(X), parent(X, Y).
sister(X, Y) :- female(X), parent(Z, X), parent(Z, Y).

%anadromi
ancestor(X, Z) :- parent(X, Z).
ancestor(X, Z) :- parent(X, Y), ancestor(Y, Z).

% %member 
% member(X,[X|_]).
% member(X,[_|L]):- member(X,L).

% %append 
% append(_,L,L).
% append([X|L1], L2, [X|L3]):- append(L1,L2,L3).

triangle(point(2,-1),point(0,7),point(3,10)).
=======
=======
>>>>>>> b3f9c0b978c2d5640de0a82a318229fd8405d9b8
%ena paixnidaki p madeueui enan arithmo
guess_num :- loop(start).

loop(15) :-write('You guess it').

loop(X):-
    X \= 15,
    write('guess number '),
    read(Guess),
    write(Guess),
    write(' is not the number, Try again.'), nl,
    loop(Guess).
<<<<<<< HEAD
>>>>>>> b3f9c0b978c2d5640de0a82a318229fd8405d9b8
=======
>>>>>>> b3f9c0b978c2d5640de0a82a318229fd8405d9b8
