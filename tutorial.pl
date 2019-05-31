
%prolog scripts runs as: consult('test.pl').

loves(romeo, juliet).
%a fact that means romeo loves juliet


loves(juliet, romeo) :- loves(romeo ,juliet).
%afto einai ena rule to opoio mas leei
%oti o juliet loves romeo  dinei oti o 
%romeo loves julietg

happy(albert). 
happy(alice).
happy(bob).
with_albert(alice).

%o albert runs if albert happy
%same as if 
runs(albert) :- 
    happy(albert).


%comma " , " einai san AND
dances(alice) :-
    happy(alice),
    with_albert(alice).


does_alice_dance :- dances(alice),
    write('When alice is happy and with albert she dances').  

near_water :- true.

swims(bob) :-
    happy(bob).

swims(bill):-
    near_water(bill).

