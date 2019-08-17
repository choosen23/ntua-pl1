%gia arithmitika exw:
positive(N) :- N>0.
non_zero(N) :- N<0 ; N>0.


%Grafw to minimum function gia pl kai gia c
% int minimum(int x, int y)
% {
%   if (x < y) 
%     return x;
%   else 
%     return y;
% }

%an X < Y return true else .
minimum(X,Y,X) :- X < Y.
minimum(X,Y,Y) :- X >= Y.

%find maximum of 2 numbers
maximum(X,Y,X) :- X >= Y.
maximum(X,Y,Y) :- X < Y.

%absolute value of number
abs(X,X1) :- X > 0 , X1 is X.
abs(X,Y) :- X < 0, Y is -X.


% (a) Factorial:	
% fact(0)	=	1
% fact(n)	=	n*fact(n-1),	when n>0
% (b) The Fibonacci function:	
% fib(0)	=	1
% fib(1)	=	1
% fib(n)	=	fib(n-1)+fib(n-2),	when n>1
% (c) Ackermann's function:	
% Ack(0,y)	=	y+1
% Ack(x,0)	=	Ack(x-1,1)	when x >0
% Ack(x,y)	=	Ack(x-1,Ack(x,y-1))	when x,y>0

%factorial function
fact(X,Fact) :- X =:= 1, Fact is 1.
fact(X,Fact) :- X > 1,
    NewX is X - 1,
    fact(NewX,NF),
    Fact is X*NF.

%fibonacci function
fib(X,Res) :- X = 0, Res is 1.
fib(X,Res) :- X = 1, Res is 1.
fib(X,Res) :- X > 1,
    NewX is X - 1,
    NewX2 is X - 1,
    fib(NewX,NR).
    


diff(X,Y):-
    X <> Y.











