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
