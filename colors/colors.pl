read_input(File, N, K, C) :-
    open(File, read, Stream),
    read_line(Stream, [N, K]),
    read_line(Stream, C).

read_line(Stream, L) :-
    read_line_to_codes(Stream, Line),
    atom_codes(Atom, Line),
    atomic_list_concat(Atoms, ' ', Atom),
    maplist(atom_number, Atoms, L).

contains_all(K, N, _) :-
    K is N+1.
contains_all(K, N, List) :-
    member(K, List),
    NewK is K+1,
    contains_all(NewK, N, List).

subsequence(L1, L2) :-
    length(L1, _),
    subsequence1(L1, L2).

subsequence1([], _).
subsequence1([X|T1], [X|T2]) :-
    subsequence2(T1, T2).
subsequence1(L1, [_|L2]) :-
    subsequence(L1, L2).

subsequence2([], _).
subsequence2([X|T1], [X|T2]) :-
    subsequence2(T1, T2).

solve(K, List, Answer) :-
    \+ contains_all(1, K, List),
    Answer is 0, !.

solve(K, List, Answer) :-
    subsequence(Ans, List),
    length(Ans, Answer),
    contains_all(1, K, Ans),!.

colors(Fname, Answer) :-
    read_input(Fname, _, K, List),
    solve(K, List, Answer).
