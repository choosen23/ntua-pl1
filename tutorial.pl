<<<<<<< HEAD
=======
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
>>>>>>> b3f9c0b978c2d5640de0a82a318229fd8405d9b8
