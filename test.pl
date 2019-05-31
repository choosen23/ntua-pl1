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






















