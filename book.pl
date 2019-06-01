% askiseis apo to vivlio



%askisi 7
third( X,Y) :-
    nth0(2, X, Y).

%ask 8
firstpair([X, Y | _]) :-
    X = Y.
      
%ask 9
del3([A,B,_ | Tail],Y):-
    append([A,B],Tail ,Y).

%ask 10
duplicate([],[]).
duplicate([X|T1],[Y,Z|T2]) :-
    X = Y,
    X = Z,
    duplicate(T1,T2).    


%ask12
odd([_]).
odd([_,_|T]) :-
    odd(T) ,!.

%ask13
even([_,_]).
even([_,_|T]) :-
    even(T) ,!.

%ask14
prefix([],_).
prefix([X|T1],[Y|T2]) :-
    X = Y,
    prefix(T1,T2).
    

%ask16
union([],[],[]).
union([H|T],[],[H|T]).     
union([],[H|T],[H|T]).    
union([H|T], SET2, RESULT) :- member(H,SET2), union(T,SET2,RESULT), ! .    
union([H|T], SET2, [H|RESULT]) :- not(member(H,SET2)), union(T,SET2,RESULT),!.


%ask18

eq([],[]).
eq([H|T],[H2|T2]) :- 
    H = H2 , 
    eq(T,T2).


%paradeigmata tou kefalaiou 22
sum([],0).
sum([H|T], X):-
    sum(T,Tailsum),
    X is H + Tailsum.

%paradigma gcd
gcd(X,1,X).
gcd(1,Y,Y).
gcd(X,Y,Z):-
    X > Y, NewX is X - Y,
    gcd(NewX,Y,Z).
gcd(X2,Y2,Z2) :-
    X2 <= NewY, NewY is Y2 - X2, 
    gcd(newY).






