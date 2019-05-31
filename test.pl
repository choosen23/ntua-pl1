%merika eisagogika gia tin prolog:
%atomo einai mai stathera pou apotelite apo alfarithmitikous xaraktires px san string se alles gloese

%metavliti einai jathe ti opou arxizei apo kefalaio gramma h underscore kai mporoun na exoun 2 times, dld
%na einai desmeumenes h oxi. Dld dn mporoume na tin allaksoume tin timi tis

%sinthetoi oroi:
%arxizoun me ena atomo kai akolouthountai apo mia akolouthia oron  px university('Ε.Μ.Π.') 
%oi sinthetoi oroi einai san domes dedomenwn

%enopoihsh: Oi oroi couple(adamn, eve) ennopoiounte me tous couple(With,Withwhom) kai tha prokipsei:
% adam = with && eva = withwhom



% erminia: kim einai parent tis holly

parent(kim, holly).
parent(margaret, kim).
parent(margaret, kent).
parent(esther, margaret).
parent(herbert, margaret).
parent(herbert, jean).


%episeis h telia einai aparaititi '.'

% h sizeuksi ginete me to ,  px
% parent(margaret, X), parent(X, holly).

% an patisw ';' anti gia enter pernw oles tis diathesimes liseis
% parent(Parent, kim), parent(GrandParent, Parent).

%anagi gia kanones
%gia na doume pos tha grapsoume kauthian tin erotisi: poioi einai oi papoudes tis ester

%kanonas grandparents
grandparents(Pappous , Eggoni) :- 
    parent(Pappous,Paidiou),
    parent(Paidiou, Eggoni).

%kanonas grandgrandparents
grandgrandparents( Propappous , Eggoni) :- 
    grandparents( Propappous ,Paidiou),
    parent(Paidiou, Eggoni).


%kai oi 2 kanones xrisimopoioun ides metavlites alla den mas pirazei dioti h evmvelia kapoias metavlitis einai monon o kanonas
%pou tin periexei


%anadromikoi kanones:
% gia paradigma o progonos kapoiou

% afto simenei oti o X einai progonos tou Y otan o X einai goneas tou Y OR
% an uparxei kapoios Z oste o Z na einai gonios toy Y kai o X na einai progonos toy Z
ancestor(X, Y) :- parent(X, Y).
ancestor(X, Y) :-
 parent(Z, Y),
 ancestor(X, Z).
%h prolog emfanizei tous kanones me tin seira p emfanizontai


%katigorima "=/2"
%to atomo '=' mas dinei:
% ?- parent(adam,seth) = parent(adam,X).
% X = seth.


%listes stin prolog:
% to atomo [] anaparasta tin keni lista
% to sinartisiako simvolo '.' antistoizei ston telesti :: ths ML (append)
% px
% ?- X = .(1,.(2,.(3,[]))).
% X = [1, 2, 3].
% ?- .(X,Y) = [1,2,3].
% X = 1
% Y = [2, 3].


%anaparastasi listwn me outa:
% to telos tis listas einai to simvolo | akolouthoymeno apo ti oura tis listas
% episeis xrisimopoihtai kai se protipa:

% ?- [1,2|X] = [1,2,3,4,5].
% X = [3, 4, 5].

% to append stin prolog epitinxanei mono an h lista Z einai to apotelesma tis sinenonis tin listas Y sto telos tis lista X 
% DLD
% ?- append([1,2], [3,4], Z).
% Z = [1, 2, 3, 4].

%episeis to append xrisimopoihtai kai gia elenxo :
% ?- append(X, [3,4], [1,2,3,4]).
% X = [1, 2] ;
% false.


%alla katigorimata gia listes einai ta 
% member/2
% select/3
% nth0/3
% lenght/2

%iparxei to reverse gia anastrofi mia listas
%iparxei to sort p ilopoiei taksinomisi



% h spazokefalia me ton agroti p thelei na perasei apo to potami me to laxano to arni kai ton liko


%anaparistw me mai lista tin thesi tou kathenos dld oloi kasekinane apo [w,w,w,w] kai kataligoun [e,e,e,e]
%tha anaparastisoume tis 4 epitreptes kiniseis
%dld wolf, sheep , and cabbage (nothing an einai stin varka monos t)





%stin prolog sximatizoume tin lisi me ena katigorima to move( Conf, Move, NextConf)
% Conf : o sximatismos [w,w,w,w]
% Move einai px Wolf
% Next conf einai px o epomenos sindiasmo


change(e,w) :-
    change(w,e) .

change(w,e) :-
    change(e,w) .

move( [X,X,Goat,Cabbage] , wolf , [Y,Y,Goat,Cabbage] ) :-
    change(X,Y).
move( [X,Wolf,X,Cabbage] , goat, [Y,Wolf,Y,Cabbage] ) :-
    change(X,Y).
move( [X,Wolf,Goat,X] ,cabbage , [Y,Wolf,Goat,Y] ) :-
    change(X,Y).
move( [X,Wolf,Goat,Cabbage] , nothing, [Y,Wolf, Goat, Cabbage] ) :-
    change(X,Y).


%tha dimiourgisoume tora tous asfaleis sximatismous dld:

guarded_or_sep(X,X,X) .
guarded_or_sep(_,Y,Z) :- Y \= Z.

safe([Man,Wolf,Goat,Cabbage] ) :-
    guarded_or_sep(Man,Goat,Wolf),
    guarded_or_sep(Man,Goat,Cabbage) .


% ftiaxnw tin sinartisi p tha 'trexei' to programma

solution([e,e,e,e], [] ).
solution(Conf, [Move|Moves]) :-
    move(Conf,Move, NextConf),
    safe(NextConf),
    solution(NextConf,Moves) .



% to programma trexei me tin entoli 
%length(L,N) , solution([w,w,w,w], L).
% kathos an dn valw to lenthe tha etrexe epaoristwn se mia atermoni loopa
